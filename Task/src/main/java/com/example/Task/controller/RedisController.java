package com.example.Task.controller;

import com.example.Task.entity.Products;
import com.example.Task.service.ProductsService;
import com.example.Task.service.RedisService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class RedisController {

   @Autowired
   RedisService redisService;

   @Autowired
   ProductsService productsService;

   @GetMapping("/rateLimit/{userId}")
   public List<Products> rateLimit(@PathVariable int userId, HttpServletResponse httpServletRequest) throws IOException {
        if(!(redisService.checkLimit(userId)))
            return productsService.findAllProducts();
            System.out.println("Rate limit exceeded. Try again");
            httpServletRequest.getWriter().write("Rate limit exceeded. Try again");
            return null;
        }
   }
