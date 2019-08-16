package com.store.app.controller;

import com.store.app.bean.ProductBean;
import com.store.app.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String productInformation(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("product", listOfProducts.findId(id));
        return "productInformation";
    }

}
