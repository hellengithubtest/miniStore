package com.store.app.controller;

import com.store.app.bean.ProductBean;
import com.store.app.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StoreController {
    private StoreService listOfProducts;

    public StoreController(StoreService listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
    @GetMapping(value = {"/"})
    public ModelAndView listOfProducts(ModelMap modelMap) {
        List<ProductBean> list = listOfProducts.getList();
        modelMap.addAttribute("list", list);
        return new ModelAndView("listOfProducts", modelMap);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String productInformation(ModelMap modelMap) {
        return "productInformation";
    }

}
