package se.lexicon.mvc_assignment.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.mvc_assignment.dto.CustomerDto;
import se.lexicon.mvc_assignment.entity.Customer;

import java.util.Collection;


@Component
public class CustomerConverter implements Converter<Customer, CustomerDto> {

    CustomerDetailsConverter customerDetailsConverter;

    @Autowired
    public void setCustomerDetailsConverter(CustomerDetailsConverter customerDetailsConverter) {
        this.customerDetailsConverter = customerDetailsConverter;
    }


    @Override
    public Customer toModel(CustomerDto dto) {
        Customer model = new Customer();

        if (dto != null) {
            model.setCustomerId(dto.getCustomerId());
            model.setEmail(dto.getEmail());
            model.setRegDate(dto.getRegDate());
            model.setActive(true);
            //model.setCustomerDetails();
        }
        return model;
    }

    @Override
    public CustomerDto toDTO(Customer model) {
        return null;
    }

    @Override
    public Collection<Customer> toModels(Collection<CustomerDto> collection) {
        return null;
    }

    @Override
    public Collection<CustomerDto> toDTos(Collection<Customer> collection) {
        return null;
    }
}
