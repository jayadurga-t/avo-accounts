package com.avo.accounts.service;

import com.avo.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

    CustomerDetailsDto fetchCustomerDetails(String correlationId, String mobileNumber);

}
