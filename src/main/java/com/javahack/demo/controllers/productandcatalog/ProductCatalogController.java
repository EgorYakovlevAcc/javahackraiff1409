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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductCatalogController extends AbstractController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ComponentOfProductWithValueService componentOfProductWithValueService;
    @Autowired
    private ProductCatalogService productCatalogService;

    @GetMapping("/catalog/product/create")
    public String getCreatePC(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("productCatalog", new ProductCatalog());
        return "create_catalog";
    }
    @PostMapping("/catalog/product/create")
    public String postCreatePC(Model model, RedirectAttributes attributes, @AuthenticationPrincipal User user, @ModelAttribute("productCatalog") ProductCatalog productCatalog){
        productCatalog.setUser(user);
        productCatalogService.save(productCatalog);
        attributes.addAttribute("id", productCatalog.getId());
        return "redirect:/product/create/{id}";
    }
    @GetMapping("/product/create/{id}")
    public String getCreateProduct(Model model, @AuthenticationPrincipal User user, @PathVariable("id") int id){
        model.addAttribute("product", new Product());
        model.addAttribute("id", id);
        return "create_product";
    }
    @PostMapping("/product/create/{id}")
    public String postCreateProduct(RedirectAttributes attributes, Model model, @AuthenticationPrincipal User user, @PathVariable("id") int id, @ModelAttribute("product") Product product){
        ProductCatalog productCatalog = productCatalogService.findProductCatalogById(id);
        product.setProductCatalog(productCatalog);
        productCatalogService.save(productCatalog);
        System.out.println(product.toString());
        System.out.println(product.getName());
        System.out.println(product.getId());
        productService.save(product);
        attributes.addAttribute("prId", product.getId());
        return "redirect:/product/components/create/{prId}";
    }
    @GetMapping("/product/components/create/{prId}")
    public String getCreateComponent(Model model, @AuthenticationPrincipal User user, @PathVariable("prId") int id){
        model.addAttribute("productComponent", new ComponentOfProductWithValue());
        return "create_component";
    }
    @PostMapping("/product/components/create/{id}")
    public String postCreateComponent(Model model, @AuthenticationPrincipal User user, @PathVariable("id") int id, @ModelAttribute("productComponent") ComponentOfProductWithValue componentOfProductWithValue){
            if (productService.findProductById(id) != null) {
                componentOfProductWithValue.setProduct(productService.findProductById(id));
                componentOfProductWithValueService.save(componentOfProductWithValue);
            }

        return "redirect:/account";
    }
    @GetMapping("/catalog")
    public String getCatalog(Model model, @AuthenticationPrincipal User user){
        List<ProductCatalog> productsCatalog = productCatalogService.findProductCatalogsByUser(user);
        model.addAttribute("productCatalogs", productsCatalog);
        return "catalog";
    }
}
