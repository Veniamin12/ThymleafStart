package com.example.ThymleafStart.Services;

import com.example.ThymleafStart.Products.Product;
import com.example.ThymleafStart.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(){
        return productRepository.findAll();
    }

    public void save(Product product){
        productRepository.save(product);
    }
    public Product getId(Integer id){
        return productRepository.findById(id).get();
    }
    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }
}
