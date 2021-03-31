
package se.lexicon.mvc_assignment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.mvc_assignment.converter.CustomerConverter;
import se.lexicon.mvc_assignment.dto.CustomerDto;
import se.lexicon.mvc_assignment.entity.Customer;
import se.lexicon.mvc_assignment.repository.CustomerRepository;


import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    CustomerConverter customerConverter;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Autowired
    public void setCustomerConverter(CustomerConverter customerConverter) {
        this.customerConverter = customerConverter;
    }


    @Override
    public CustomerDto saveOrUpdate(CustomerDto customerDto) {
        if (customerDto == null) throw new IllegalArgumentException("customerDto is not valid");

        Customer convertDtoToModel = customerConverter.toModel(customerDto);
        Customer savedObject = customerRepository.save(convertDtoToModel);

        return customerConverter.toDTO(savedObject);
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