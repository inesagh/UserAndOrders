package com.example.springjparelations.controller.productcontroller;

import com.example.springjparelations.controller.personcontroller.model.PersonResponse;
import com.example.springjparelations.controller.productcontroller.model.ProductRequest;
import com.example.springjparelations.controller.productcontroller.model.ProductResponse;
import com.example.springjparelations.facade.ProductFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductFacade facade;

    public ProductController(ProductFacade facade) {
        this.facade = facade;
    }

    @PostMapping("product")
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request){
        return ResponseEntity.ok(facade.create(request));
    }

    @GetMapping("product/all")
    public ResponseEntity<List<ProductResponse>> getAll(){
        return ResponseEntity.ok(facade.getAll());
    }

    @GetMapping("product")
    public ResponseEntity<List<ProductResponse>> getByYourChoice(@RequestParam String term,
                                                                 @RequestParam String value){
        if(term.equals("id")){
            List<ProductResponse> list = List.of(facade.getById((long) Integer.parseInt(value)));
            return ResponseEntity.ok(list);
        }else{
            return ResponseEntity.ok(facade.getByYourChoice(term, value));
        }
    }

    @PutMapping("product/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id,
                                  @RequestParam ProductRequest request){
        return ResponseEntity.ok(facade.update(id, request));
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(facade.delete(id));
    }
}
