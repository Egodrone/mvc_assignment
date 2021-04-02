package se.lexicon.mvc_assignment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.lexicon.mvc_assignment.dto.CustomerDetailsDto;
import se.lexicon.mvc_assignment.dto.CustomerDto;
import se.lexicon.mvc_assignment.entity.Customer;
import se.lexicon.mvc_assignment.entity.CustomerDetails;
import se.lexicon.mvc_assignment.service.CustomerService;


import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    List<CustomerDto> customerDtoList;
    List<CustomerDetailsDto> customerDetailsDtoList;
    CustomerService customerService;


    @PostConstruct
    public void init() {
        if (customerDtoList == null) customerDtoList = new ArrayList<>();
        if (customerDetailsDtoList == null) customerDetailsDtoList = new ArrayList<>();

        CustomerDto customerDto = new CustomerDto();
        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();

        Customer customer = new Customer();
        CustomerDetails customerDetails = new CustomerDetails();
    }


    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @GetMapping("/customer")
    public String customer(Model model) {
        System.out.println("--- GetMapping ---");
        model.addAttribute("customerDtoList", customerService.getAll());
        return "customer";
    }


    @GetMapping("/details")
    public String details(Model model) {
        System.out.println("--- GetMapping details ---");
        CustomerDto dto = new CustomerDto();
        model.addAttribute("dto", dto);

        return "details";
    }


    @PostMapping("/details")
    public String addDetails(@ModelAttribute("dto") @Valid CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println("Create new Customer");

        if (customerDto.getCustomerDetailsDto().getStreet().isEmpty()) {
            FieldError error= new FieldError("dto","customerDetailsDto.street","Street should not be empty");
            bindingResult.addError(error);
        }

        if (customerDto.getCustomerDetailsDto().getZipCode().isEmpty()) {
            FieldError error= new FieldError("dto","customerDetailsDto.zipCode","Zip Code should not be empty");
            bindingResult.addError(error);
        }

        if (customerDto.getCustomerDetailsDto().getCity().isEmpty()) {
            FieldError error= new FieldError("dto","customerDetailsDto.city","City should not be empty");
            bindingResult.addError(error);
        }

        if (customerDto.getCustomerDetailsDto().getHomePhone().isEmpty()) {
            FieldError error= new FieldError("dto","customerDetailsDto.homePhone","Home Phone should not be empty");
            bindingResult.addError(error);
        }

        if (customerDto.getCustomerDetailsDto().getCellphone().isEmpty()) {
            FieldError error= new FieldError("dto","customerDetailsDto.cellphone","Mobile phone should not be empty");
            bindingResult.addError(error);
        }

        if (!customerDto.getEmail().equals("") ) {
            System.out.println("\n");
            System.out.println(customerDto.getEmail());

            customerDto.setEmail(customerDto.getEmail());
            customerDto.setActive(true);

            //default UUID it will be overwritten on insert
            String id = "123e4567-e89b-12d3-a456-556642440000";
            customerDto.setCustomerId(id);
            customerDto.setRegDate(LocalDate.now());

            System.out.println(customerDto.toString());
            System.out.println(customerDto.getCustomerDetailsDto().getStreet());

            customerService.saveOrUpdate(customerDto);
        }

        if (bindingResult.hasErrors()) {
            return "details";
        }

        return "redirect:/customer/";
    }


    @GetMapping("/customer/delete/{id}")
    public String deleteById(@PathVariable("id") String id, RedirectAttributes redirectAttributes){
        customerService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Delete Customer ID: " + id + " is Completed");
        redirectAttributes.addFlashAttribute("alertClass","alert-info");

        return "redirect:/customer/";
    }


    //customer Details
    @GetMapping("/customer/find/{id}")
    public String getProductById(@PathVariable("id") String id, Model model) {
        CustomerDto optionalCustomerDto = customerService.findById(id);
        model.addAttribute("customerDto", optionalCustomerDto);

        return "customerDetails";
    }


}
