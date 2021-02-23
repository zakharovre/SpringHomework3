package ru.geekbrains.hw3.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.hw3.models.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepo {
    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        products.add(new Product(1, "Apple", 50));
        products.add(new Product(2, "Orange", 100));
        products.add(new Product(3, "Peach", 75));
        products.add(new Product(4, "Banana", 25));
        products.add(new Product(5, "Grape", 650));
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void deleteByID(int id){
        products.removeIf(p -> p.getId() == id);
    }
    public void addProd(Product product){
        products.add(product);
    }

}
