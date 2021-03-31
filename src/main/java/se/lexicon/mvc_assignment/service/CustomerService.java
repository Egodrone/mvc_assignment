package se.lexicon.mvc_assignment.service;


import se.lexicon.mvc_assignment.dto.CustomerDto;

import java.util.List;


public interface CustomerService {

    CustomerDto saveOrUpdate(CustomerDto customerDto);

    List<CustomerDto> getAll();

    CustomerDto findById(int id);

    void deleteById(int id);

    List<CustomerDto> findByName(String name);
}
