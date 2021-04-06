
package se.lexicon.mvc_assignment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.mvc_assignment.converter.CustomerConverter;
import se.lexicon.mvc_assignment.dto.CustomerDto;
import se.lexicon.mvc_assignment.entity.Customer;
import se.lexicon.mvc_assignment.repository.CustomerRepository;


import java.util.ArrayList;
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
        // if customer id == null    jpa repository calls save method otherwise it calls update
        Customer savedObject = customerRepository.save(convertDtoToModel);

        return customerConverter.toDTO(savedObject);
    }

    @Override
    public List<CustomerDto> getAll() {
        Iterable<Customer> iterable = customerRepository.findAll();
        List<Customer> customerList = new ArrayList<>();
        iterable.iterator().forEachRemaining(customerList::add);

        return new ArrayList<>(customerConverter.toDTos(customerList));
    }


    @Override
    public CustomerDto findById(String id) {
        if (id == null) throw new IllegalArgumentException("Id should not be null");
        Customer customer = customerRepository.findById(id).orElse(null);

        return customerConverter.toDTO(customer);
    }


    @Override
    public void deleteById(String id) {
        if (id == null) throw new IllegalArgumentException("Id should not be null");
        customerRepository.deleteById(id);
    }


    @Override
    public List<CustomerDto> findByName(String name) {
        /*
        if (name == null) throw new IllegalArgumentException("Name should not be null");
        List<Customer> customerList = customerRepository.findByNameIgnoreCase(name);

        return new ArrayList<>(customerConverter.toDTos(customerList));
         */
        return null;
    }


}