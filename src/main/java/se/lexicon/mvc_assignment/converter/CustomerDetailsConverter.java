package se.lexicon.mvc_assignment.converter;


import org.springframework.stereotype.Component;
import se.lexicon.mvc_assignment.dto.CustomerDetailsDto;
import se.lexicon.mvc_assignment.entity.CustomerDetails;

import java.util.ArrayList;
import java.util.Collection;


@Component
public class CustomerDetailsConverter implements Converter<CustomerDetails, CustomerDetailsDto> {


    @Override
    public CustomerDetails toModel(CustomerDetailsDto dto) {
        CustomerDetails model = new CustomerDetails();

        if (dto != null) {
            model.setDetailsId(dto.getDetailsId());
            model.setCellphone(dto.getCellphone());
            model.setCity(dto.getCity());
            model.setStreet(dto.getStreet());
            model.setHomePhone(dto.getHomePhone());
            model.setZipCode(dto.getZipCode());
        }

        return model;
    }


    @Override
    public CustomerDetailsDto toDTO(CustomerDetails model) {
        CustomerDetailsDto dto = new CustomerDetailsDto();

        if (model != null) {
            dto.setDetailsId(model.getDetailsId());
            dto.setCellphone(model.getCellphone());
            dto.setHomePhone(model.getHomePhone());
            dto.setCity(model.getCity());
            dto.setStreet(model.getStreet());
            dto.setZipCode(model.getZipCode());
        }

        return dto;
    }


    @Override
    public Collection<CustomerDetails> toModels(Collection<CustomerDetailsDto> collection) {
        Collection<CustomerDetails> models= new ArrayList<>();

        if (collection !=null){
            for (CustomerDetailsDto dto: collection){
                models.add(toModel(dto));
            }
        }

        return models;
    }


    @Override
    public Collection<CustomerDetailsDto> toDTos(Collection<CustomerDetails> collection) {
        Collection<CustomerDetailsDto> dtoList = new ArrayList<>();

        if (collection !=null){
            for (CustomerDetails model: collection){
                dtoList.add(toDTO(model));
            }
        }

        return dtoList;
    }


}
