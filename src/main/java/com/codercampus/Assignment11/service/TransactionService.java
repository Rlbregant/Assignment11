package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public List<Transaction> getAllTransactions() {
		List<Transaction> transactions = transactionRepository.findAll();
		Collections.sort(transactions, (t1, t2) -> t1.getDate().compareTo(t2.getDate()));
		return transactions;
	}

	public Transaction getTransactionById(Long id) {
		List<Transaction> transactions = transactionRepository.findAll();
		for (Transaction transaction : transactions) {
			if (transaction.getId().equals(id)) {
				return transaction;
			}
		}
		return null;
	}
}