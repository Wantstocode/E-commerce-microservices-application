package com.kiran.customer_server.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.kiran.customer_server.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String> {
}
