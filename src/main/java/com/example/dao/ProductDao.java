package com.example.dao;

import com.example.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ari on 11.02.2017.
 */
@Repository
public interface ProductDao extends CrudRepository<Product,Long>{


}
