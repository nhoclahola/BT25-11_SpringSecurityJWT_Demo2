package com.nhoclahola.bt2511_springsecurityjwt_demo2.controllers;

import com.nhoclahola.bt2511_springsecurityjwt_demo2.models.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableMethodSecurity
public class CustomerController
{
    private final List<Customer> customers = List.of(
            Customer.builder().id("001").name("Bao Nguyen").email("nhoclahola@gmail.com").build(),
            Customer.builder().id("002").name("Nguyen Bao").email("nlg.bao1340@gmail.com").build()
    );

    @GetMapping("/hello")
    public ResponseEntity<String> hello()
    {
        return ResponseEntity.ok("hello is guest");
    }

    @GetMapping("/customer/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Customer>> getCustommerList()
    {
        List<Customer> list = this.customers;
        return ResponseEntity.ok(list);
    }

    @GetMapping("/customer/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Customer> getCustommerList(@PathVariable("id") String id)
    {
        List<Customer> customers = this.customers.stream().filter(customer -> customer.getId().equals(id)).toList();
        return ResponseEntity.ok(customers.get(0));
    }
}
