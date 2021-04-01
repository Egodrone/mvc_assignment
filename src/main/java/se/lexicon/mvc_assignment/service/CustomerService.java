package se.lexicon.mvc_assignment.service;


import se.lexicon.mvc_assignment.dto.CustomerDto;

import java.util.List;


public interface CustomerService {

    CustomerDto saveOrUpdate(CustomerDto customerDto);

    List<CustomerDto> getAll();

    CustomerDto findById(String id);

    void deleteById(String id);

    List<CustomerDto> findByName(String name);
}
