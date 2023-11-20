package com.project.BankMS.demoBankMS.controller;

import com.project.BankMS.demoBankMS.entities.Account;
import com.project.BankMS.demoBankMS.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account") // We are sending infos to the localhost.../account (main link)
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("allAccounts") // /account/allAccounts
    public ResponseEntity<List<Account>> getAllAccounts(){
        return accountService.getAccounts();
    }

    @GetMapping("accountNumber/{accountNumber}") //By using @PathVariable annotation we cen assign it into the bracket
    public ResponseEntity<List<Account>> getAccountsByAccountNumber(@PathVariable("accountNumber") String accountNumber){
        return accountService.getAccountsByAccountNumber(accountNumber);
    }

    // This annotation is used because you are sending this data in request form the client side to server in the body
    @PostMapping("add") // It enables to send data to the server
    public ResponseEntity<String> addQuestion(@RequestBody Account account) { //T his annotation is used because you are sending this data in request form the client side to server
        return accountService.addAccount(account);
    }
    
    @PutMapping("update") // It enables to update and send to the server
    public  ResponseEntity<String> updateAccount(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }

    @DeleteMapping("delete") // It enables to update and send to the server
    public  ResponseEntity<String> deleteAccount(@RequestBody Account account) {
        return accountService.deleteAccount(account);
    }
}

