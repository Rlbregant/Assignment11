package com.codercampus.Assignment11.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.codercampus.Assignment11.domain.Transaction;

@Repository
public class TransactionRepository {
    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> findAll() {
        if (transactions.isEmpty()) {
            populateData();
        }
        return transactions;
    }

    @SuppressWarnings("unchecked")
    private void populateData() {
        try (FileInputStream fileInputStream = new FileInputStream("transactions.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            this.transactions = (List<Transaction>) objectInputStream.readObject();
            Collections.sort(transactions, (t1, t2) -> t1.getDate().compareTo(t2.getDate()));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}