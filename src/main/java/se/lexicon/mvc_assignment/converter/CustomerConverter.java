package se.lexicon.mvc_assignment.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.mvc_assignment.dto.CustomerDto;
import se.lexicon.mvc_assignment.entity.Customer;

import java.util.ArrayList;
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
            model.setCustomerDetails(customerDetailsConverter.toModel(dto.getCustomerDetailsDto()));
        }

        return model;
    }


    @Override
    public CustomerDto toDTO(Customer model) {
        CustomerDto dto = new CustomerDto();

        if (model != null) {
            dto.setActive(true);
            dto.setCustomerId(model.getCustomerId());
            dto.setEmail(model.getEmail());
            dto.setRegDate(model.getRegDate());
            dto.setCustomerDetailsDto(customerDetailsConverter.toDTO(model.getCustomerDetails()));
        }

        return dto;
    }


    @Override
    public Collection<Customer> toModels(Collection<CustomerDto> collection) {
        Collection<Customer> models = new ArrayList<>();

        if (collection != null) {
            for (CustomerDto dto : collection) {
                models.add(toModel(dto));
            }
        }

        return models;
    }


    @Override
    public Collection<CustomerDto> toDTos(Collection<Customer> collection) {
        Collection<CustomerDto> dtoList = new ArrayList<>();

        if (collection != null) {
            for (Customer model : collection) {
                CustomerDto dto = toDTO(model);
                dtoList.add(dto);
            }
        }

        return dtoList;
    }


}
