package com.example.Task.service;

import com.example.Task.entity.Products;
import com.example.Task.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository employeeRepository;

    public List<Products> findAllProducts(){
        return employeeRepository.findAll();
    }
}
