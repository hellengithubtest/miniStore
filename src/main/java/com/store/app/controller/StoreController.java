package com.store.app.controller;

import com.store.app.bean.ProductBean;
import com.store.app.repository.StoreRepository;
import com.store.app.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StoreController {
    private StoreService service;
    private StoreRepository repository;

    public StoreController(StoreService service, StoreRepository repository) {
        this.service = service;
        this.repository = repository;
    }
    @GetMapping(value = {"/"})
    public ModelAndView listOfProducts(ModelMap modelMap) {
        List<ProductBean> list = service.getAll();
        modelMap.addAttribute("list", list);
        return new ModelAndView("listOfProducts", modelMap);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String productInformation(@PathVariable(value = "id") int id, Model model) {
        try {
            model.addAttribute("product", service.getCurrentId(id));
            return "productInformation";
        } catch (RuntimeException e) {
            return "redirect:/";
        }
    }

}
