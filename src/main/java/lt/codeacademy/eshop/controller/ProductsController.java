package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.service.MessageService;
import lt.codeacademy.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(@Qualifier("productServiceImpl") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductDetail(@PathVariable(value = "id") UUID id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public void save(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        productService.delete(id);
    }
}
