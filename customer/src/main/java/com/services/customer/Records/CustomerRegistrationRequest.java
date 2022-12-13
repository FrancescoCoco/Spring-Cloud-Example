package com.services.customer.Records;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
