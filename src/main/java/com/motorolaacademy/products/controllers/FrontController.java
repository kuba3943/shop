package com.motorolaacademy.products.controllers;

import com.motorolaacademy.products.ProductDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@AllArgsConstructor
public class FrontController {

    private final ProductDao productDao;

    @GetMapping("/products/details")
    public String showDetails(Model model, @RequestParam(value = "name") String name) {

        model.addAttribute("product", productDao.byName(name));
        return "details";
    }

    @GetMapping("/products/list")
    public String showList(Model model) {

        model.addAttribute("products", productDao.all());
        return "list";
    }


}
