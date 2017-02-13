package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ari on 13.02.2017.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping("")
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String getProductInventory(Model model){
        model.addAttribute("products",productService.getProducts());
        return "productInventory";
    }
    @RequestMapping(value = "/productInventory/addProduct",method = RequestMethod.GET)
    public String addProduct(Model model){
        model.addAttribute("product",new Product());
        return "addProduct";
    }

    @RequestMapping(value = "/productInventory/addProduct" ,method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product){
        productService.addProduct(product);
        return "redirect:/admin/productInventory";
    }
}
