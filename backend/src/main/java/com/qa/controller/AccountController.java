package com.qa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qa.buisness.service.AccountService;
import com.qa.persistence.domian.Account;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:8080")
public class AccountController {

	@Autowired
	private AccountService serv;

	@GetMapping("/getall")
	public List<Account> getAllAccounts() {
		return serv.getAllAccounts();
	}

	@GetMapping("/get/{id}")
	public Optional<Account> getAccountById(@PathVariable long id) {
		return serv.getAccountById(id);
	}

	@PostMapping("/add")
	public String addAccount(@RequestBody Account account) {
		return serv.addAcount(account);
	}

	@PutMapping("/update/{id}")
	public String updateAccount(@RequestBody Account account, @PathVariable long id) {
		return serv.updateAccount(id, account);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteAccount(@PathVariable long id) {
		return serv.deleteAccount(id);
	}

	public AccountService getServ() {
		return serv;
	}

	public void setServ(AccountService serv) {
		this.serv = serv;
	}
}
