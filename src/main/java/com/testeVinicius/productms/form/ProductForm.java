package com.testeVinicius.productms.form;

import com.sun.istack.NotNull;
import com.testeVinicius.productms.entities.Product;
import com.testeVinicius.productms.repository.ProductRepository;
import org.springframework.web.bind.annotation.RequestBody;

public class ProductForm {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Integer price;

    public Product insertConverter(){ return new Product(name, description, price);}

    public Product updateConverter(String id, ProductRepository productRepository, @RequestBody ProductForm form) {

        Product product = productRepository.getById(id);
        if (form.name != null)
            product.setName(this.name);
        if (form.description != null)
            product.setDescription(this.description);
        if (form.price != null)
            product.setPrice(this.price);

        return product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
