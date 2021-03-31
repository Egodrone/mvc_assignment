package se.lexicon.mvc_assignment.converter;


import org.springframework.stereotype.Component;
import se.lexicon.mvc_assignment.dto.CustomerDetailsDto;
import se.lexicon.mvc_assignment.entity.CustomerDetails;

import java.util.Collection;


@Component
public class CustomerDetailsConverter implements Converter<CustomerDetails, CustomerDetailsDto> {


    @Override
    public CustomerDetails toModel(CustomerDetailsDto dto) {
        return null;
    }

    @Override
    public CustomerDetailsDto toDTO(CustomerDetails model) {
        return null;
    }

    @Override
    public Collection<CustomerDetails> toModels(Collection<CustomerDetailsDto> collection) {
        return null;
    }

    @Override
    public Collection<CustomerDetailsDto> toDTos(Collection<CustomerDetails> collection) {
        return null;
    }
}
