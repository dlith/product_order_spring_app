package com.dzmitry.spring.products_order_app.controller;



import com.dzmitry.spring.products_order_app.entity.Order;
import com.dzmitry.spring.products_order_app.entity.Product;
import com.dzmitry.spring.products_order_app.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private MainService mainService;

    @RequestMapping("/")
    public String showFirstView(){
        return "start-page";
    }

    @RequestMapping("/products")
    public String showAllProducts(Model model){
        List<Product> allProducts = mainService.getAllProducts();
        model.addAttribute("allProducts", allProducts);
        return "all-products";
    }

    @RequestMapping("/updateInfo")
    public String updateProduct(@RequestParam("prodId") int id, Model model){
        Product product = mainService.getProduct(id);
        model.addAttribute("product", product);
        return "product-info";
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product){
        mainService.saveOrUpdateProduct(product);
        return "redirect:/products";
    }

    @RequestMapping("/addNewProduct")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "product-info";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("idProduct") int id){
        mainService.deleteProduct(id);
        return "redirect:/products";
    }

    @RequestMapping("/orders")
    public String showAllOrders(Model model){
        List<Order> allOrders = mainService.getAllOrders();
        model.addAttribute("allOrders", allOrders);
        return "all-orders";
    }

    @RequestMapping("/openOrderProduct")
    public String openOrderProduct(@RequestParam("orderId") int id, Model model){
        Order order  = mainService.getOrder(id);
        model.addAttribute("product", order.getProducts());
        model.addAttribute("orderId", id);
        return "all-ordered-products-info";
    }

    @RequestMapping("/addNewOrderProduct")
    public String addOrderProduct(@RequestParam("orderId") int id, Model model){
        Order order = mainService.getOrder(id);
        model.addAttribute("order", order);

        List<Product> products = mainService.getAllProducts();
        products.removeAll(order.getProducts());
        model.addAttribute("freeProducts", products);

        return "order-product-info";
    }

    @RequestMapping("/saveOrderProduct")
    public String saveOrderProduct(@ModelAttribute("orderProduct") Order order, @ModelAttribute("orderProducts2save") List<Product> products){
        //mainService.saveOrUpdateOrder(order);
        return "redirect:/openOrderProduct?orderId="+ order.getId();
    }
}
