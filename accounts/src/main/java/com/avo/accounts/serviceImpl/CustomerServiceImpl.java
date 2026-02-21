package com.avo.accounts.serviceImpl;

import com.avo.accounts.client.CardsFeignClient;
import com.avo.accounts.client.LoansFeignClient;
import com.avo.accounts.dto.*;
import com.avo.accounts.entity.Accounts;
import com.avo.accounts.entity.Customer;
import com.avo.accounts.exception.ResourceNotFoundException;
import com.avo.accounts.mapper.AccountsMapper;
import com.avo.accounts.mapper.CustomerMapper;
import com.avo.accounts.repository.AccountsRepository;
import com.avo.accounts.repository.CustomerRepository;
import com.avo.accounts.service.IAccountsService;
import com.avo.accounts.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    private IAccountsService iAccountsService;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {

//        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
//                new Supplier<ResourceNotFoundException>() {
//                    @Override
//                    public ResourceNotFoundException get() {
//                        return new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber);
//                    }
//                }
//        );
//        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
//
//        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
//                new Supplier<ResourceNotFoundException>() {
//                    @Override
//                    public ResourceNotFoundException get() {
//                        return new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString());
//                    }
//                }
//        );
//        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(iAccountsService.fetchAccount(mobileNumber), new CustomerDetailsDto());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCard(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoan(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
