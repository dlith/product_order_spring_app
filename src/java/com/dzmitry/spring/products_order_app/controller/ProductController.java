package com.dzmitry.spring.products_order_app.controller;



import com.dzmitry.spring.products_order_app.entity.Product;
import com.dzmitry.spring.products_order_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String showFirstView(){
        return "start-page";
    }

    @RequestMapping("/products")
    public String showAllProducts(Model model){
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("allProducts", allProducts);
        return "all-products";
    }

    @RequestMapping("/updateInfo")
    public String updateProduct(@RequestParam("prodId") int id, Model model){
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "product-info";
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveOrUpdateProduct(product);
        return "redirect:/products";
    }

    @RequestMapping("/addNewProduct")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return"product-info";
    }


}
