package com.bkap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bkap.entities.Advertisement;
import com.bkap.entities.Product;
import com.bkap.service.AdvertisementService;
import com.bkap.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private AdvertisementService advertisementService;

	@Autowired
	private ProductService productService;

	@RequestMapping()
	public String viewHomePage(Model model) {
		List<Advertisement> advertisements = advertisementService.findByIsUseTrue();
		List<Product> featureProducts = productService.findByAttributeValuesValue("feature");

		model.addAttribute("advertisements", advertisements);
		model.addAttribute("featureProducts", featureProducts);

		return "homepage";
	}
}
