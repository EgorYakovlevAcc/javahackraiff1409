package com.javahack.demo.controllers.productandcatalog;

import com.javahack.demo.controllers.AbstractController;
import com.javahack.demo.models.ComponentOfProductWithValue;
import com.javahack.demo.models.Product;
import com.javahack.demo.models.ProductCatalog;
import com.javahack.demo.models.User;
import com.javahack.demo.services.catalogandproducts.ProductCatalogService;
import com.javahack.demo.services.catalogandproducts.componentsofproductwithvalue.ComponentOfProductWithValueService;
import com.javahack.demo.services.catalogandproducts.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class ProductCatalogController extends AbstractController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ComponentOfProductWithValueService componentOfProductWithValueService;
    @Autowired
    private ProductCatalogService productCatalogService;
//    @GetMapping("/catalog/product/create")
//    public String createPC(Model model, @AuthenticationPrincipal User user){
//        model.addAttribute("productCatalog", new ProductCatalog());
//    }
//    @PostMapping("/catalog/product/create")
//    public String createPC(Model model, @AuthenticationPrincipal User user){
//        model.addAttribute("productCatalog", new ProductCatalog());
//    }
//    @GetMapping("/product/create")
//    public String createPC(Model model, @AuthenticationPrincipal User user){
//        model.addAttribute("product", new Product());
//    }
//    @PostMapping("/product/create")
//    public String createPC(Model model, @AuthenticationPrincipal User user){
//        model.addAttribute("product", new Product());
//    }
//    @GetMapping("/product/components/create")
//    public String createPC(Model model, @AuthenticationPrincipal User user){
//        model.addAttribute("productComponents", new ComponentOfProductWithValue());
//    }
//    @PostMapping("/product/components/create")
//    public String createPC(Model model, @AuthenticationPrincipal User user){
//        model.addAttribute("productComponents", new ComponentOfProductWithValue());
//    }
    @GetMapping("/catalog")
    public String getCatalog(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("productCatalog", productCatalogService.findProductCatalogsByUser(user));
        return "catalog";
    }
}
