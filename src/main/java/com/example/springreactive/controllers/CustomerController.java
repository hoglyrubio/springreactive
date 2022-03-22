package com.example.springreactive.controllers;

import com.example.springreactive.model.Customer;
import com.example.springreactive.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {

    @Autowired
    public CustomerRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/customers")
    public Mono<Customer> create(@RequestBody Mono<Customer> customer) {
        return repository.saveAll(customer).next();
    }

    @GetMapping("/customers")
    public Flux<Customer> readAll() {
        return repository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Mono<Customer> read(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @PutMapping("/customers")
    public Mono<Customer> update(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    public Mono<Void> update(@PathVariable("id") Long id) {
        return repository.deleteById(id);
    }

}
