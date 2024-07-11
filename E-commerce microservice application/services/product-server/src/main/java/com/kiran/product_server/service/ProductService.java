package com.kiran.product_server.service;

import com.kiran.product_server.dto.ProductPurchaseRequest;
import com.kiran.product_server.dto.ProductPurchaseResponse;
import com.kiran.product_server.dto.ProductRequest;
import com.kiran.product_server.dto.ProductResponse;
import com.kiran.product_server.mapper.ProductMapper;
import com.kiran.product_server.model.Product;
import com.kiran.product_server.productexceptionhandler.ProductPurchaseException;
import com.kiran.product_server.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public Integer createProduct(ProductRequest request) {
        var product = mapper.toProduct(request);
        return productRepository.save(product).getId();
    }

    public ProductResponse findById(Integer id) {
        return productRepository.findById(id)
                .map(mapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID:: " + id));
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }


    @Transactional
    public void updateCustomer(ProductRequest request) {
        var product = this.productRepository.findById(request.id())
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Cannot update customer:: No customer found with the provided ID: %s", request.id())
                ));
        mergeProduct(product, request);
        this.productRepository.save(product);
    }


    private void mergeProduct(Product product, ProductRequest request) {
        if (StringUtils.isNotBlank(request.name())) {
            product.setName(request.name());
        }
        if (StringUtils.isNotBlank(request.description())) {
            product.setDescription(request.description());
        }
        product.setAvailableQuantity(request.availableQuantity());
        product.setPrice(request.price());
    }

    @Transactional(rollbackFor = ProductPurchaseException.class)
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();
        var storedProducts = productRepository.findAllByIdInOrderById(productIds);
        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exist");
        }
        var sortedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = sortedRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.quantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.productId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            purchasedProducts.add(mapper.toproductPurchaseResponse(product, productRequest.quantity()));
        }
        return purchasedProducts;
    }

}
