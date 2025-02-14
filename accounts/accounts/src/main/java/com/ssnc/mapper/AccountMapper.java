package com.ssnc.mapper;

import com.ssnc.dto.AccountsDto;
import com.ssnc.entity.Accounts;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") // Makes mapstruct manage it as a spring Bean
public interface AccountMapper {

    AccountsDto accountsToAccountsDto(Accounts accounts);

    Accounts accountsDtoToAccounts(AccountsDto accountsDto);

}
