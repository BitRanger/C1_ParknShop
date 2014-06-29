package com.bitranger.parknshop.buyer.controller;

<<<<<<< HEAD
=======
import java.lang.ProcessBuilder.Redirect;

>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.ResponseBody;

>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
import com.bitranger.parknshop.buyer.dao.IPsCustomerDAO;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.seller.dao.IPsSellerDAO;
import com.bitranger.parknshop.seller.model.PsSeller;

/**
 * @author Yu Bowen "/login" Input: email, password combination for login
 *         Output: currentCustomer set if customer log in currentSeller set if
 *         seller log in
 */
// TODO This login function is non-functioning for seller, Due to LACK for
// information
@Controller
public class CustomerLogin {
	@Autowired
	private IPsCustomerDAO psCustomerDao;

	@Autowired
	private IPsSellerDAO psSellerDao;

	@RequestMapping("/login")
	public String customerLogin(HttpServletRequest req, String email,
			String password, String role) {
<<<<<<< HEAD

		role = "buyer";
		HttpSession session = req.getSession(true);
=======
		HttpSession session = req.getSession();
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
		if (session.getAttribute("currentCustomer") != null
				|| session.getAttribute("currentSeller") != null)
			return "redirect:/";
		if (role == null || email == null)
			return Utility.error("Role unspecified.");
		if (role.equals("buyer")) {
			PsCustomer persistCustomer = psCustomerDao.findByEmail(email);
<<<<<<< HEAD
System.out.println("CustomerLogin.customerLogin()");
System.out.println(persistCustomer);
if (persistCustomer != null) {
	System.out.println(persistCustomer.getEmail());
	System.out.println(persistCustomer.getPassword());
}
			if (persistCustomer == null)
					//|| !persistCustomer.getPassword().equals(password))
				return "redirect:/";
			
			session.setAttribute("currentCustomer", persistCustomer);
			
			System.out.println("CustomerLogin.customerLogin()");
			System.out.println("================================================");
			System.out.println(req.getSession().getAttribute("currentCustomer"));		
			
=======
			if (persistCustomer == null
					|| !persistCustomer.getPassword().equals(password))
				return "redirect:/";
			session.setAttribute("currentCustomer", persistCustomer);
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
			return "redirect:/";
		}
		if (role.equals("seller")) {
			PsSeller persistSeller = psSellerDao.findByEmail(email);
			if (persistSeller == null
					|| !persistSeller.getPassword().equals(password))
				return Utility.error("Password Error.");
			session.setAttribute("currentSeller", persistSeller);
			return "redirect:/";
		}
		return Utility.error("Params Role Error");
	}
}
