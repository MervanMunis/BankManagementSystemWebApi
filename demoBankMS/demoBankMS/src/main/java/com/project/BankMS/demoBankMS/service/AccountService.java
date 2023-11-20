package com.project.BankMS.demoBankMS.service;

import com.project.BankMS.demoBankMS.entities.Account;
import com.project.BankMS.demoBankMS.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    IAccountDao accountDao;
    public ResponseEntity<List<Account>> getAccounts() { // Response Entity enables us to manage the error
        try {
            return new ResponseEntity<>(accountDao.findAll(), HttpStatus.OK); // It goes to the Database (MySQL) and fetches it through the AccountDao (spring framework-jpa)
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST); // If there is something wrong an empty array will be returned.
    }

    public ResponseEntity<List<Account>> getAccountsByAccountNumber(String accountNumber) {
        try {
            return new ResponseEntity<>(accountDao.findByAccountNumber(accountNumber),HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addAccount(Account account) {
         accountDao.save(account);
         try {
             return new ResponseEntity<>( "success",HttpStatus.CREATED);
         }catch (Exception e) {
             e.printStackTrace();
         }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateAccount(Account account) {
        accountDao.save(account);
        try {
            return new ResponseEntity<>( "success",HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteAccount(Account account) {
        accountDao.delete(account);
        try {
            return new ResponseEntity<>( "success",HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
