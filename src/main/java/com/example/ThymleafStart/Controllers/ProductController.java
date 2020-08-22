package com.example.ThymleafStart.Controllers;

import com.example.ThymleafStart.Products.Product;
import com.example.ThymleafStart.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ProductController {
    @Autowired
    private ProductServices service;

    @RequestMapping("/")
    public String ViewHomePage(Model model){
        List<Product> listProduct = service.listAll();
        model.addAttribute("listProduct", listProduct);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
     public String saveProduct(@ModelAttribute("product")Product product){
        service.save(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name="id") int id){
      ModelAndView mav = new ModelAndView("edit_product");
      Product product = service.getId(id);
      mav.addObject("product",product);
      return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable(name="id") int id){
        service.deleteById(id);
        return "redirect:/";
    }
}
