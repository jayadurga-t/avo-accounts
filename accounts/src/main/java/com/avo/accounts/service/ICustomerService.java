package com.avo.accounts.service;

import com.avo.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);

}
