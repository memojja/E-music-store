package com.example.service.impl;

import com.example.dao.ProductDao;
import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ari on 11.02.2017.
 */
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getProducts() {
        fakeProduct();
        return (List) productDao.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productDao.findOne(id);
    }

    private void fakeProduct(){

        for (int i=0;i<10;i++){
            productDao.save(    new Product("AA")  );
        }
    }

}
