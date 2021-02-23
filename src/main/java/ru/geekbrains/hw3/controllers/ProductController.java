package ru.geekbrains.hw3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.hw3.models.Product;
import ru.geekbrains.hw3.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model){
        model.addAttribute("Products", productService.getAllProducts());
        return "productsView";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product){
        productService.addProduct(product);
        return "redirect:/products/all";
    }

    @GetMapping("/remove/{id}")
    public String removeProduct(@PathVariable int id){
        productService.deleteProductByID(id);
        return "redirect:/products/all";
    }

}
