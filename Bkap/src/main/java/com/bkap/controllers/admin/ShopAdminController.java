package com.bkap.controllers.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bkap.entities.Advertisement;
import com.bkap.service.AdvertisementService;

@Controller
@RequestMapping("/admin/shop")
public class ShopAdminController {
	@Autowired
	private AdvertisementService advertisementService;

	@RequestMapping("/decorate")
	public String shopDecoratePage(Model model) {

		Page<Advertisement> page = advertisementService.findAll(0, 10);
		List<Advertisement> advertisements = page.getContent();

		model.addAttribute("advertisementsList", advertisements);
		return "admin/decorateShop";
	}

	@RequestMapping("/add-banner")
	public String addBannerPage(Model model) {
		return "admin/addBanner";
	}

	@RequestMapping("/edit-banner/{id}")
	public String editBannerPage(@PathVariable Long id, Model model, HttpServletRequest request) {
		String referer = request.getHeader("Referer");

		Advertisement advertisement = advertisementService.findById(id);

		if (advertisement != null) {
			model.addAttribute("advertisement", advertisement);
			return "admin/editBanner";
		}

		return "redirect:" + referer;
	}

	@RequestMapping("/use-banner/{id}")
	public String toggleBanner(@PathVariable Long id, Model model, HttpServletRequest request) {
		String referer = request.getHeader("Referer");

		Advertisement advertisement = advertisementService.findById(id);

		if (advertisement != null) {
			advertisement.setIsUse(!advertisement.getIsUse());
			advertisementService.save(advertisement);

			model.addAttribute("advertisement", advertisement);
			return "redirect:" + referer;
		}

		return "redirect:" + referer;
	}
}
