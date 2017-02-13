package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ari on 11.02.2017.
 */

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping("/productList")
    public String productList(Model model){
        List<Product> products= productService.getProducts();
        model.addAttribute("products",products);
        return "productList";
    }

    @RequestMapping(value = "/productDetail/{id}")
    public ModelAndView updateProduct(@PathVariable("id") Long id){
        return new ModelAndView("productDetail","product",productService.findById(id));
    }


}
