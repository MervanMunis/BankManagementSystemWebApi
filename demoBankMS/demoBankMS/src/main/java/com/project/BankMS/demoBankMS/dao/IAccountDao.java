package com.project.BankMS.demoBankMS.dao;

import com.project.BankMS.demoBankMS.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; //JPA Repository

import java.util.List;

@Repository
public interface IAccountDao extends JpaRepository<Account, Integer> { // By using jpa spring framework we can handle query codes very easy.
    List<Account> findByAccountNumber(String accountNumber); // jpa is smart enough to understand that is one of the column.
}
