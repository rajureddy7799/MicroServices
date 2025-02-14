package com.ssnc.service.impl;

import com.ssnc.constatnts.AccountConstants;
import com.ssnc.controller.AccountsController;
import com.ssnc.dto.AccountsDto;
import com.ssnc.dto.CustomerDto;
import com.ssnc.entity.Accounts;
import com.ssnc.entity.Customer;
import com.ssnc.exception.CustomerAlreadyExistsException;
import com.ssnc.mapper.AccountMapper;
import com.ssnc.mapper.CustomerMapper;
import com.ssnc.repository.AccountsRepository;
import com.ssnc.repository.CustomerRepository;
import com.ssnc.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountsServiceImpl implements AccountService {

    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private AccountMapper accountMapper;

    /**
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = customerMapper.mapCustomerDtoToCustomer(customerDto);
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber "
                    +customerDto.getMobileNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        return newAccount;
    }
}
