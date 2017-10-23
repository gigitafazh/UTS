package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.ProductModel;
import com.example.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productDAO;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	// viewall
	@RequestMapping("/product/viewall")
	public String view(Model model) {
		List<ProductModel> products = productDAO.selectAllProducts();
		model.addAttribute("product", products);

		return "viewall";
	}

	// view
	@RequestMapping("/product/view")
	public String view(Model model, @RequestParam(value = "id", required = false) int id) {
		ProductModel product = productDAO.selectProduct(id);

		if (product != null) {
			model.addAttribute("product", product);
			return "view";
		} else {
			model.addAttribute("id", id);
			return "not-found";
		}
	}

	// view
	@RequestMapping("/product/view/{id}")
	public String viewPath(Model model, @PathVariable(value = "id") int id) {
		ProductModel product = productDAO.selectProduct(id);

		if (product != null) {
			model.addAttribute("product", product);
			return "view";
		} else {
			model.addAttribute("id", id);
			return "not-found";
		}
	}

	// update product
	@RequestMapping("/product/update/{id}")
	public String update(Model model, @PathVariable(value = "id") int id) {
		ProductModel product = productDAO.selectProduct(id);
		if (product != null) {
			model.addAttribute("product", product);
			return "form-update";
		} else {
			model.addAttribute("id", id);
			return "not-found";
		}
	}

	// submit update product
	@RequestMapping(value = "/product/update/submit", method = RequestMethod.POST)
	public String updateForm(@ModelAttribute ProductModel product) {
		productDAO.updateProduct(product);

		return "redirect:/product/view/" + product.getId();
	}

	// add product
	@RequestMapping("/product/add")
	public String add() {
		return "form-add";
	}

	// submit add product
	@RequestMapping("/product/add/submit")
	public String addSubmit(@RequestParam(value = "nama", required = false) String nama,
			@RequestParam(value = "deskripsi", required = false) String deskripsi,
			@RequestParam(value = "kategori", required = false) String kategori,
			@RequestParam(value = "pabrikan", required = false) String pabrikan,
			@RequestParam(value = "berat", required = false) double berat,
			@RequestParam(value = "harga", required = false) int harga,
			@RequestParam(value = "tahun_produksi", required = false) int tahun_produksi,
			@RequestParam(value = "jumlah_stok", required = false) int jumlah_stok,
			@RequestParam(value = "kondisi", required = false) String kondisi) {

		ProductModel product = new ProductModel(0, nama, deskripsi, kategori, pabrikan, berat, harga, tahun_produksi,
				jumlah_stok, kondisi);
		productDAO.addProduct(product);

		return "redirect:/product/viewall";
	}

	// submit add product
	// @RequestMapping(value = "/product/add/submit", method = RequestMethod.POST)
	// public String addSubmit(Model model, @ModelAttribute ProductModel product) {
	//
	// productDAO.addProduct(product);
	// return "redirect:/product/viewall";
	// }
}
