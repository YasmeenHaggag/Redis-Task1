package com.example.Task.repository;

import com.example.Task.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Integer> {

}
