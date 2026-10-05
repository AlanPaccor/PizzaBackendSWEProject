package com.pizzashop.pizzabackend.customer;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
    @GetMapping("/{phoneNumber}")
    public Optional<Customer> getCustomer(@PathVariable String phoneNumber) {
        return customerRepository.findByPhoneNumber((phoneNumber));
    }
}
