package com.bankapp.web.controller;

import java.util.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankapp.model.entities.Account;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.formbeans.AccountFromBean;
import com.bankapp.web.formbeans.DepositWithdrawBean;
import com.bankapp.web.formbeans.Transferbean;

@Controller
public class AccountController {
	
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	/*@GetMapping("/")
	public String entry() {
		return "redirect:/home";
	}*/

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	

	@GetMapping("success")
	public String success() {
		return "success";
	}
	
	@GetMapping("transfer")
	public String tranferAmountGet(ModelMap mv) {
		mv.addAttribute("transferbean", new Transferbean());
		return "transfer";
	}
	@PostMapping("transfer")
	public String tranferAmountPost(@Valid @ModelAttribute(name="transferbean") Transferbean transferBean,BindingResult bindingResult) {
		if(bindingResult.hasErrors())
		{
			return "transfer";
		}
		else
		{
		
		int fromAcc=transferBean.getFromAccountId();
		int toAcc=transferBean.getToAccountId();
		double amount=transferBean.getAmount();
		accountService.tranfer(fromAcc, toAcc, amount);
		return "redirect:/success";
		}
	}
	//------new account-------
	
	@GetMapping("createaccount")
	public String createAccountGet(ModelMap model)
	{
		model.addAttribute("accountFromBean", new AccountFromBean() );
		return "createaccount";
	}
	@PostMapping("createaccount")
	public String createAmountPost(@Valid @ModelAttribute(name="accountFromBean") Account account,BindingResult bindingResult) {
		if(bindingResult.hasErrors())
		{
			
			
			return "redirect:/createaccount";
		}
		else
		{
			
			accountService.addAccount(account);
		    return "redirect:/showallaccounts";
		}
	}
	
	
	@GetMapping("withdraw")
	public String withdrawAmountGet(ModelMap mv) {
		mv.addAttribute("depositWithdrawBean", new DepositWithdrawBean());
		return "withdraw";
	}
	@PostMapping("withdraw")
	public String withdrawAmountPost(@Valid @ModelAttribute(name="depositWithdrawBean") DepositWithdrawBean depositWithdrawBean,BindingResult bindingResult) {
		if(bindingResult.hasErrors())
		{
			return "withdraw";
		}
		else
		{
		
		int accountId=depositWithdrawBean.getAccountId();
		double amount=depositWithdrawBean.getAmount();
		accountService.withdraw(accountId, amount);
		return "redirect:/success";
		}
	}
	
	@GetMapping("deposit")
	public String depositAmountGet(ModelMap mv) {
		mv.addAttribute("depositWithdrawBean", new DepositWithdrawBean());
		return "deposit";
	}
	@PostMapping("deposit")
	public String depositAmountPost(@Valid @ModelAttribute(name="depositWithdrawBean") DepositWithdrawBean depositWithdrawBean,BindingResult bindingResult) {
		if(bindingResult.hasErrors())
		{
			return "deposit";
		}
		else
		{
		
		int accountId=depositWithdrawBean.getAccountId();
		double amount=depositWithdrawBean.getAmount();
		accountService.deposit(accountId, amount);
		return "redirect:/success";
		}
	}
	@ModelAttribute(value="accountType")
	public List<String> getAccountTypes()
	{
		return Arrays.asList("SAVING","CURRENT");
	}
	@GetMapping("updateaccount")
	public String updateUserGet(ModelMap map, HttpServletRequest request) {
		Integer uid = Integer.parseInt(request.getParameter("id"));
		Account account = accountService.getAccountById(uid);
		map.addAttribute("accountFromBean", account);
		return "updateaccount";
	}
	
	@GetMapping("deleteaccount")
	public String deleteAccount( HttpServletRequest request) {
		Integer uid = Integer.parseInt(request.getParameter("uId"));
		accountService.deleteAccount(uid);
		return "redirect:/showallaccounts";
	}
	//showall accounts
	@GetMapping("showallaccounts")
	public ModelAndView showAllusers(ModelAndView mv) {
		List<Account> accounts = accountService.getAllAccounts();
		mv.addObject("allaccounts", accounts);
		mv.setViewName("showallaccounts");
		return mv;
	}
}
