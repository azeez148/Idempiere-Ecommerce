package com.ecommerce.mvc.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.service.CartService;
import com.ecommerce.service.UserService;

@Controller
@RequestMapping("/")
public class MainTemplateController{

	@Inject
	CartService cartService;
	@Inject
	UserService userService;

	@RequestMapping(value = "/header")
	public String getPrinterDetailsTemplate0() {
		return "common/Header";
	}

	@RequestMapping(value = "/nav")
	public String getPrinterDetailsTemplate1(ModelMap model) {
		/*User user = null;
		List<ProductCategory> items = sOAPWebServiceImp.getProductCategory();
		model.addAttribute("categoryList", items);
		
		user = userService.getUserById("0");
		System.out.println(user);
		List<Cart> cartList = cartService.getAllAddedProducts(user);

		
		
		
		model.addAttribute("categoryList", items);
		model.addAttribute("cartSize", cartList.size());*/
		return "common/Menu";
	}

	@RequestMapping(value = "/content")
	public String getPrinterDetailsTemplate2(HttpServletRequest httpServletRequest) {
		
		return "content";
	}

	@RequestMapping(value = "/footer")
	public String getPrinterDetailsTemplate3() {
		return "common/Footer";
	}

	@RequestMapping(value = "/items")
	public String getPrinterDetailsTemplate4() {
		return "items";
	}
	//Change to the new view
	@RequestMapping(value = "home/search/{name}")
	public String getSearchResult(@PathVariable("name") String name,ModelMap model) {

		return "productHome";
	}

	@RequestMapping(value = "/home")
	public String getPrinterDetailsTemplate5() {

		return "home";
	}

	@RequestMapping(value = "/home/latestOffers")
	public String getLatestOffersPage() {
		// System.out.println(getClass().getProtectionDomain().getCodeSource().getLocation());

		return "latestOffers";
	}

	@RequestMapping(value = "/home/hotSellingProducts")
	public String getHotSellingPage(ModelMap model) {
		
		return "hotSellingProducts";
	}

	@RequestMapping(value = "/home/upComingProducts")
	public String getUpComingPage() {
		// System.out.println(getClass().getProtectionDomain().getCodeSource().getLocation());

		return "upComingProducts";
	}
	@RequestMapping(value = "/offer")
	public String getOfferPage() {
		// System.out.println(getClass().getProtectionDomain().getCodeSource().getLocation());

		return "offer";
	}
	
	@RequestMapping(value = "/home/category/{id}/{num}")
	public String getCategoryPagination(@PathVariable("id") long id,@PathVariable("num") long num,ModelMap model) {
		
		return "productHome";
	}
	@RequestMapping(value = "/latestOfferDetails/{id}")
	public String getLatestOfferDetails(@PathVariable("id") long id) {
		// System.out.println(getClass().getProtectionDomain().getCodeSource().getLocation());

		System.out.println(id);
		return "productHome";
	}

	
	@RequestMapping(value = "/cart")
	public String getCartPage() {
		
		
		return "cart";
	}
	@RequestMapping(value = "/cart/del")
	public String getCartPageAgain() {
		return "cart";
	}
	@RequestMapping(value = "/product")
	public String getProductDetailPage() {
		System.out.println("in getProductDetailPage");
		return "productDetail";
	}
	@RequestMapping(value = "/allCategories")
	public String getAllCategoriesList() {
		System.out.println("in getAllCategoriesList");
		return "allCategories";
	}
	@RequestMapping(value = "/latestOfferItems/{num}")
	public String getLatestOfferItemsPage(@PathVariable("num") long num,ModelMap model) {
		return "productHome";
	}
@RequestMapping(value = "/register")
	public String getRegistrationPage() {
		return "registration";
	}

	@RequestMapping(value = "/wish")
	public String getWishListPage() {
		
		return "wishList";
	}
	
	@RequestMapping(value = "/wish/del")
	public String getWishListPageAgain() {
		return "wishList";
	}

	@RequestMapping(value = "/customer-Account")
	public String getCustomerAccountPage() {
		
		System.out.println("In Customer Account");
		return "customerAccount";
	}
	@RequestMapping(value = "/admin")
	public String getAdminHome() {
		
		System.out.println("In getAdminHome");
		return "admin/adminHome";
	}
	@RequestMapping(value = "/admin/users")
	public String getUsersPage() {
		
		System.out.println("In getUsersPage");
		return "admin/usersList";
	}
	@RequestMapping(value = "/admin/vendors")
	public String getVendorsPage() {
		
		System.out.println("In getVendorsPage");
		return "admin/vendorsList";
	}
	@RequestMapping(value = "/admin/registerVendor")
	public String getVendorRegisterPage() {
		
		System.out.println("In getVendorRegisterPage");
		return "admin/vendorRegistration";
	}	
	@RequestMapping(value = "/admin/pdtcategory")
	public String getProductCategoryPage() {
		
		System.out.println("In getVendorRegisterPage");
		return "admin/productCategories";
	}
	@RequestMapping(value = "/admin/createCategory")
	public String getCreateCategoryPage() {
		
		System.out.println("In getVendorRegisterPage");
		return "admin/categoryCreation";
	}
	@RequestMapping(value = "/admin/pricelists")
	public String getPriceListPage() {
		
		System.out.println("In getPriceListPage");
		return "admin/priceLists";
	}
	@RequestMapping(value = "/admin/products")
	public String getProductsPage() {
		
		System.out.println("In getPriceListPage");
		return "admin/allProducts";
	}
}