package com.codercampus.Assignment11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {

	private TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@GetMapping("/transactions")
	public String showTransactions(Model model) {
		model.addAttribute("transactions", transactionService.getAllTransactions());		
		return "transactions";
	}

	@GetMapping("/transactions/{transactionId}")
	public String showTransactionById(@PathVariable Long transactionId, Model model) {
		Transaction transaction = transactionService.getTransactionById(transactionId);

		if (transaction == null) {
			return "error";
		}

		model.addAttribute("transaction", transaction);
		return "transaction";
	}
}