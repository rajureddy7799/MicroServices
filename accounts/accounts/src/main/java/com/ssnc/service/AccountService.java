package com.ssnc.service;

import com.ssnc.dto.AccountsDto;
import com.ssnc.dto.CustomerDto;

public interface AccountService {

    void createAccount(CustomerDto customerDto);
}
