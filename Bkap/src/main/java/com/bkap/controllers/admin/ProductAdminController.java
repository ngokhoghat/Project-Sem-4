package com.bkap.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bkap.dto.ProductDTO;
import com.bkap.entities.Category;
import com.bkap.entities.Product;
import com.bkap.service.CategoryService;
import com.bkap.service.ProductService;
import com.bkap.utils.Converter;

@Controller
@RequestMapping("/admin/product")
public class ProductAdminController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping()
	public String viewProductPage(@RequestParam(required = false, value = "page-number") String pageNo, Model model) {
		int pageSize = 5;
		int pageNumber = pageNo != null ? Integer.parseInt(pageNo) : 1;
		Page<Product> page = productService.findPaginated(pageNumber, pageSize);
		List<Product> products = page.getContent();

		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listProduct", products);

		return "admin/product";
	}

	@RequestMapping("/add-product")
	public String viewAddProductPage(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("listCategory", categories);
		return "admin/addProduct";
	}

	@RequestMapping(path = "/add-product", method = RequestMethod.POST)
	public String createProduct(@ModelAttribute("product") ProductDTO productDTO) {
		Product product = productService.createProduct(new Converter().toProduct(productDTO));

		if (product != null) {
			return "admin/addProduct";
		}

		return "admin/addProduct";

	}

	@RequestMapping("/edit-product")
	public String viewEditProductPage(@RequestParam("id") Long id, Model model) {
		List<Category> categories = categoryService.findAll();
		Product product = productService.findById(id);

		model.addAttribute("listCategory", categories);
		model.addAttribute("product", product);
		return "admin/editProduct";
	}

	@RequestMapping(path = "/edit-product", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute("product") ProductDTO productDTO) {
		Product product = productService.createProduct(new Converter().toProduct(productDTO));

		if (product != null) {
			return "admin/addProduct";
		}

		return "admin/addProduct";

	}
}
