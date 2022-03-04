package com.example.security;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.security.models.User;
import com.example.security.models.UserPrincipal;
import com.example.security.models.Cakes;
import com.example.security.models.Orders;



@RestController
public class HomeController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CakesRepo cakeRepo;
	
	@Autowired
	OrderRepo orderRepo;

	
	//------user functionalities---------
	
	
	//	---- requesting jsp page for adding a user------
	@RequestMapping("/requestAddUser")
	public ModelAndView getWelcomePageAsModel() {
		      ModelAndView modelAndView = new ModelAndView();
		      modelAndView.setViewName("home.jsp");
		      return modelAndView;
	}

	//----- this function automatically by jsp page for adding user-------
	@RequestMapping("addUser")
	public String addUser(User user)
	{
		userRepo.save(user);
		return "User Added";
		
	}
	
	
	//-------display the available cakes for the logged in user------
	@GetMapping("/users")
	public List<Cakes> home2(Authentication authentication) {
	
		//System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		
		//System.out.println(authentication.getPrincipal());
		return cakeRepo.findAll();
	}
	
	//-------Retriving the loged in User----------
//	@GetMapping("/users/orderCake")
//	public int home2(Authentication authentication) {
//	
//		return ((UserPrincipal) authentication.getPrincipal()).getId();
//	}
	
	//-------Retriving the loged in User----------
	
	
	
	//-------user giving order based on cake id and adding it to orders table with logged in user id----
	@GetMapping("/users/orderCake/{cakeid}")
	public String orderCake(@PathVariable("cakeid") int cakeid,Authentication authentication) {
		int uid=((UserPrincipal) authentication.getPrincipal()).getId();
		Cakes c=cakeRepo.getOne(cakeid);
		int ids=c.getCakeid();
		String name1=c.getName();
		int price=c.getPrice();
		Orders o = new Orders(ids,name1,price,uid);
		orderRepo.save(o);
		return "order placed";
	}
	
	
//	------------placing cake details to orders table by user-------
//	@GetMapping("/users/placeOrder/{id}")
//	public String home2(@PathVariable("id") int id) {
//	
//		Cakes c=cakeRepo.getOne(id);
//		int ids=c.getCakeid();
//		String name1=c.getName();
//		int price=c.getPrice();
//		
//		Orders o = new Orders(ids,name1,price);
//		orderRepo.save(o);
//		return "Item Added";
//	}
//	
//	
	

	@GetMapping("/users/orderedCakes")
	public List<Orders> orderedCakes(Authentication authentication)
	{
		
		int uid=((UserPrincipal) authentication.getPrincipal()).getId();
		
		return orderRepo.orderedItems(uid);
	}
	
	@GetMapping("/users/orderedCakes/checkOut")
	public int check(Authentication authentication)
	{
		
		int uid=((UserPrincipal) authentication.getPrincipal()).getId();
		
		return orderRepo.checkOut(uid);
	}
//	@GetMapping("/Admin")
//	public String admin()
//	{
//		return "Iam Admin";
//	}

}
