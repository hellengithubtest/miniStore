package com.store.app.controller;

import com.store.app.entity.Product;
import com.store.app.service.SearchService;
import com.store.app.service.StoreService;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StoreController {
    private StoreService service;
    private SearchService searchService;

    public StoreController(StoreService service, SearchService searchService) {
        this.service = service;
        this.searchService = searchService;
    }

    @GetMapping(value = {"/"})
    public ModelAndView listOfProducts(@RequestParam(value = "search", required = false) String q, ModelMap modelMap) {
        List<Product> list = null;
        System.out.println("Search parameter" + q);
        if(q != null){
            list = searchService.fuzzySearch(q);
            modelMap.addAttribute("list", list);
        }else {
            list = service.findAll();
            modelMap.addAttribute("list", list);
        }
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
