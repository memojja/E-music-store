package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ari on 11.02.2017.
 */

public interface ProductService {

    public List<Product> getProducts();
    public Product findById(Long id);

}
