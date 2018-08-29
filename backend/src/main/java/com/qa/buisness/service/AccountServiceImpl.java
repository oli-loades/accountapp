package com.qa.buisness.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domian.Account;
import com.qa.persistence.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository repo;
	

	public List<Account> getAllAccounts() {
		return repo.findAll();
	}

	public Optional<Account> getAccountById(long id) {
		return repo.findById(id);
	}

	public String deleteAccount(long id) {
		String msg = "{\"message\": \"Account not found\"}";
		Optional<Account> account = repo.findById(id);
		if(account.isPresent()) {
			repo.deleteById(id);
			msg = "{\"message\": \"Account sucessfully removed\"}";
		}
		return msg;
	}

	public String updateAccount(long id, Account updated) {
		String msg = "{\"message\": \"Account not found\"}";
		Optional<Account> account = repo.findById(id);
		if(account.isPresent()) {
			Account acc = account.get();
			acc.setFirstname(updated.getFirstname());
			acc.setSurname(updated.getSurname());
			acc.setAccountNumber(updated.getAccountNumber());
			repo.save(acc);
			msg = "{\"message\": \"Account sucessfully updated\"}";
		}
		return msg;
	}

	public String addAcount(Account account) {
		repo.save(account);
		return "{\"message\": \"Account sucessfully added\"}";
	}

	public AccountRepository getRepo() {
		return repo;
	}

	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}

}
