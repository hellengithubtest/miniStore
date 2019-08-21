package com.store.app.controller;

import com.store.app.bean.ProductBean;
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

    public StoreController(StoreService service) {
        this.service = service;
    }
    @GetMapping(value = {"/"})
    public ModelAndView listOfProducts(ModelMap modelMap) {
        List<ProductBean> list = service.findAll();
        modelMap.addAttribute("list", list);
        return new ModelAndView("listOfProducts", modelMap);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String productInformation(@PathVariable(value = "id") int id, Model model) {
        try {
            model.addAttribute("product", service.findById(id));
            model.addAttribute("id", id);
            return "productInformation";
        } catch (RuntimeException e) {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "product/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id){
        System.out.println("delete id " + id);
        service.delete(id);
        return "delete";
    }

    @GetMapping("product/edit/{id}")
    public String edit(){
        return "edit";
    }

    @RequestMapping(value = "/product/edit/{id}", method = RequestMethod.POST)
    public String updateProduct(@PathVariable int id, @RequestBody ProductBean productBean){
        System.out.println("edit id " + id);
        service.update(productBean);
        return "edit";
    }

    @PostMapping("product/new")
    public String newProduct(@RequestParam("name") String name, @RequestParam("cost") int cost) {
        ProductBean newproductBean = new ProductBean();
        System.out.println("post mapping name " + name + " cost " + cost);
        newproductBean.setProductName(name);
        newproductBean.setProductCost(cost);
        service.save(newproductBean);
        return "redirect:/";
    }

    @GetMapping("product/new")
    public String add(){
        return "add";
    }

}
