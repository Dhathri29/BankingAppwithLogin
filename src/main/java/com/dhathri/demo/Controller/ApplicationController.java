package com.dhathri.demo.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhathri.demo.model.Item;
import com.dhathri.demo.model.User;
import com.dhathri.demo.services.ItemService;
import com.dhathri.demo.services.UserService;

@Controller
public class ApplicationController {

	@Autowired
	UserService userService;
    
	@Autowired
	ItemService itemService;
	
	@RequestMapping("/") 
	public String welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@RequestMapping("/transaction") 
	public String transpage(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_TRANSACTION");
		request.setAttribute("users", userService.showAllTransactions());
		return "welcomepage";
	}
	
	@RequestMapping("/registration")
	public String Registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		request.setAttribute("items", itemService.showAllUsers());
		return "welcomepage";
	}
	
	@GetMapping("/alltransactions")
	public String showAllTransactions(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_ALL_TRANSACTIONS");
		request.setAttribute("users", userService.showAllTransactions());
		return "welcomepage";
	}
	
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute Item item, BindingResult bindingResult, HttpServletRequest request) {
		itemService.saveMyUser(item);
		//request.setAttribute("items", itemService.showAllUsers());
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	  @PostMapping("/save-transaction") 
	  public String registerTransfer(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
	 userService.saveMyTransaction(user); 
	 request.setAttribute("users", userService.showTop5Transactions()); 
	 request.setAttribute("mode", "MODE_ALL_TRANSACTIONS");
     return "welcomepage"; 
	}
	  
	  @RequestMapping("/login")
		public String login(HttpServletRequest request) {
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
	}
	  
	  @RequestMapping("/logout")
	  public String logout(HttpServletRequest request) {
		  request.getSession().invalidate();
		  request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	  
	  @RequestMapping ("/login-user")
		public String loginUser(@ModelAttribute Item item, HttpServletRequest request) {
			if(itemService.findByUsernameAndPassword(item.getUsername(), item.getPassword())!=null) {
				request.setAttribute("mode", "MODE_HOME");
			  //System.out.println(item.getUsername());
			  HttpSession session = request.getSession(true);
			  String use = request.getParameter("username");
			  session.setAttribute("u", use);
				return "welcomepage";
	}
			else {
				request.setAttribute("error", "Invalid Username or Password");
				request.setAttribute("mode", "MODE_LOGIN");
				return "welcomepage";
				
			}
	}
}