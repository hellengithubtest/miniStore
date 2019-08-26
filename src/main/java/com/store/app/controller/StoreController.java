package com.store.app.controller;

import com.store.app.entity.Product;
import com.store.app.service.StoreService;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class StoreController {
    private StoreService service;

    public StoreController(StoreService service) {
        this.service = service;
    }

    @GetMapping(value = {"/products/{page}"})
    public ModelAndView listOfProducts(@PathVariable(required = false, name = "page") String page,
                                       @RequestParam(value = "filter", required = false) String filter,
                                       @RequestParam(value = "size", defaultValue = "15") int size,
                                       ModelMap modelMap){
        Page<Product> pages;
        if(filter != null && !filter.isEmpty()){
            pages = service.search(filter, new PageRequest(Integer.parseInt(page), size));
            System.out.println("the first variable filter " + filter);
            System.out.println("the first variable pages " + pages);
        } else {
            pages = service.findAll(new PageRequest(Integer.parseInt(page), size));
        }
        modelMap.addAttribute("filter", filter);
/*        modelMap.addAttribute("page", new PageImpl<Product>(pages.getContent()));
        System.out.println("pages" + pages);*/
        modelMap.addAttribute("list", pages.getContent());
        System.out.println("list" + pages.getContent());

        modelMap.addAttribute("number", pages.getNumber());
        System.out.println("number" + pages.getNumber());

        modelMap.addAttribute("totalPages", pages.getTotalPages());
        System.out.println("totalPages" + pages.getTotalPages());

        modelMap.addAttribute("totalElements", pages.getTotalElements());
        System.out.println("totalElements" + pages.getTotalElements());

        modelMap.addAttribute("size", pages.getSize());
        System.out.println("size" + pages.getSize());

        return new ModelAndView("listOfProducts", modelMap);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String productInformation(@PathVariable(value = "id") int id, Model model) {
        try {
            model.addAttribute("product", service.findById(id));
            return "productInformation";
        } catch (RuntimeException e) {
            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("product", service.findById(id));
        return "edit";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("cost") int cost){
        Product product = new Product(id, name, cost);
        service.update(product);
        return "redirect:/";
    }

    @GetMapping("product/new")
    public String add(){
        return "add";
    }

    @PostMapping("product/new")
    public String newProduct(@RequestParam("name") String name, @RequestParam("cost") int cost) {
        Product newproductBean = new Product();
        newproductBean.setName(name);
        newproductBean.setCost(cost);
        service.save(newproductBean);
        return "redirect:/";
    }

}
