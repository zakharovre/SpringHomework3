package ru.geekbrains.hw3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.hw3.models.Product;
import ru.geekbrains.hw3.repositories.ProductRepo;

import java.util.List;

@Component
public class ProductService {

    private ProductRepo productRepo;

    @Autowired
    public void setProductRepo(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts(){
        return productRepo.getProducts();
    }

    public void addProduct(Product product){
        productRepo.addProd(product);
    }

    public void deleteProductByID(int id){
        productRepo.deleteByID(id);
    }
}
