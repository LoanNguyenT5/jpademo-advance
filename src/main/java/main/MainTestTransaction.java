package main;

import configuration.JPAConfig;
import entity.AccountEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.AccountRepository;
import repository.BookRepository;
import service.AccountService;

import java.time.LocalDate;
import java.util.Date;

public class MainTestTransaction {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static AccountRepository accountRepository = applicationContext.getBean("accountRepository", AccountRepository.class);
    static AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
    public static void main(String[] args) throws Exception {
        // Create new account
       //  createNewAccount();
        // Transfer money with platform transaction management
       accountService.transferMoney(1,2,50);
        // Transfer money using annotion
       //  accountService.transferMoneyUsingAnnotion(1,2,60);


    }
    //
    public static void createNewAccount(){
        AccountEntity account1 = new AccountEntity();
        account1.setOwnerName("Nguyen Van Nam");
        account1.setBalance(50);
        account1.setAccessTime(new Date());
        accountRepository.save(account1);

        AccountEntity account2 = new AccountEntity();
        account2.setOwnerName("Nguyen Khanh Huyen");
        account2.setBalance(90);
        account2.setAccessTime(new Date());
        accountRepository.save(account2);

    }
}
