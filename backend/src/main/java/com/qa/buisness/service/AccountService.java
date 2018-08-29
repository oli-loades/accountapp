package com.qa.buisness.service;

import java.util.List;
import java.util.Optional;

import com.qa.persistence.domian.Account;

public interface AccountService {
	String addAcount(Account account);

	List<Account> getAllAccounts();

	Optional<Account> getAccountById(long id);

	String deleteAccount(long id);

	String updateAccount(long id, Account account);
}
