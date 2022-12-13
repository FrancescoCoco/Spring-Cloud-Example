package com.services.customer.Services;

import com.services.customer.Models.Customer;
import com.services.customer.Records.CustomerRegistrationRequest;
import com.services.customer.Records.FraudCheckResponse;
import com.services.customer.Repositories.CustomerRepository;
import com.services.customer.utils.UrlPaths;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@AllArgsConstructor
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();
        // todo: if email is valid
        // todo: store customer

        // todo: Save and flush customerRepository in this way we can catch the customer id
        customerRepository.saveAndFlush(customer);

        // todo: check if fraudster
        FraudCheckResponse response = restTemplate.getForObject(
                UrlPaths.URL_FRAUD_CONTROL+"/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if(response.isFraudSter()){
            throw new IllegalStateException("fraudstet");
        }


        // todo: send notification to the message queeue
    }
}
