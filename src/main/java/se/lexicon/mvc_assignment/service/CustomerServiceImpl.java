
package se.lexicon.mvc_assignment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.mvc_assignment.dto.CustomerDto;
import se.lexicon.mvc_assignment.repository.CustomerRepository;


import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto saveOrUpdate(CustomerDto customerDto) {
        if (customerDto == null) throw new IllegalArgumentException("customerDto is not valid");
        return null;
    }

    @Override
    public List<CustomerDto> getAll() {
        return null;
    }

    @Override
    public CustomerDto findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<CustomerDto> findByName(String name) {
        return null;
    }
}