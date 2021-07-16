package com.example.springjparelations.converter;

import com.example.springjparelations.controller.productcontroller.model.ProductRequest;
import com.example.springjparelations.controller.productcontroller.model.ProductResponse;
import com.example.springjparelations.persistence.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {
    public ProductResponse convertToResponse(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }
    public Product convertToEntity(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return product;
    }
    public List<ProductResponse> convertListToResponse(List<Product> productList){
        return productList.stream().map(each -> convertToResponse(each))
                .collect(Collectors.toList());
    }
}
