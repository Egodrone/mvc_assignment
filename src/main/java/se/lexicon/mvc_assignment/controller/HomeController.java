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
        model.addAttribute("customerDtoList", customerService.getAll());

        return "customer";
    }


    @GetMapping("/details")
    public String details(Model model) {
        CustomerDto dto = new CustomerDto();
        model.addAttribute("dto", dto);

        return "details";
    }


    @PostMapping("/details")
    public String addDetails(@ModelAttribute("dto") @Valid CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println("Create new Customer");

        // Check if string is numerical
        int a;
        try {
            a = Integer.parseInt(customerDto.getCustomerDetailsDto().getCellphone());
        } catch (NumberFormatException e) {
            FieldError error2 = new FieldError("dto", "customerDetailsDto.cellphone", "Mobile phone should be a number");
            bindingResult.addError(error2);
        }
        try {
            a = Integer.parseInt(customerDto.getCustomerDetailsDto().getZipCode());
        } catch (NumberFormatException e) {
            FieldError error3 = new FieldError("dto", "customerDetailsDto.zipCode", "Zip Code should be a number");
            bindingResult.addError(error3);
        }
        try {
            a = Integer.parseInt(customerDto.getCustomerDetailsDto().getHomePhone());
        } catch (NumberFormatException e) {
            FieldError error4 = new FieldError("dto", "customerDetailsDto.homePhone", "Home Phone should be a number");
            bindingResult.addError(error4);
        }

        if (bindingResult.hasErrors()) {

            return "details";
        } else {
            customerDto.setActive(true);
            customerDto.setRegDate(LocalDate.now());
            customerService.saveOrUpdate(customerDto);
        }

        redirectAttributes.addFlashAttribute("message", "New record was created in the database. User with email: "
                + customerDto.getEmail() + " was created.");
        redirectAttributes.addFlashAttribute("alertClass", "alert-info");

        return "redirect:/customer/";
    }


    @GetMapping("/customer/delete/{id}")
    public String deleteById(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        customerService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "User with Customer ID: " + id + " was removed from the database");
        redirectAttributes.addFlashAttribute("alertClass", "alert-info");

        return "redirect:/customer/";
    }


    //customer Details
    @GetMapping("/customer/find/{id}")
    public String getProductById(@PathVariable("id") String id, Model model) {
        CustomerDto optionalCustomerDto = customerService.findById(id);
        model.addAttribute("customerDto", optionalCustomerDto);

        return "customerDetails";
    }


    //edit
    @GetMapping("/customer/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        CustomerDto optionalCustomerDto = customerService.findById(id);
        model.addAttribute("customerDto", optionalCustomerDto);
        model.addAttribute("customerDtoList", customerService.getAll());

        return "edit";
    }


    //edit
    @PostMapping("/edit")
    public String editDetails(@ModelAttribute("customerDto") @Valid CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println("Edit Customer");

        /*
        if (customerDto.getCustomerDetailsDto().getStreet().isEmpty()) {
            FieldError error = new FieldError("customerDto", "customerDetailsDto.street", "Street should not be empty");
            bindingResult.addError(error);
        }

        if (customerDto.getCustomerDetailsDto().getStreet().length() > 30 || customerDto.getCustomerDetailsDto().getStreet().length() < 3) {
            FieldError error2 = new FieldError("customerDto", "customerDetailsDto.street", "Street must be between 3 and 30 characters");
            bindingResult.addError(error2);
        }

        if (customerDto.getCustomerDetailsDto().getZipCode().isEmpty()) {
            FieldError error = new FieldError("customerDto", "customerDetailsDto.zipCode", "Zip Code should not be empty");
            bindingResult.addError(error);
        }

        if (customerDto.getCustomerDetailsDto().getZipCode().length() > 20 || customerDto.getCustomerDetailsDto().getZipCode().length() < 3) {
            FieldError error = new FieldError("customerDto", "customerDetailsDto.zipCode", "Zip Code must be between 3 and 20 characters");
            bindingResult.addError(error);
        }

        if (customerDto.getCustomerDetailsDto().getCity().isEmpty()) {
            FieldError error = new FieldError("customerDto", "customerDetailsDto.city", "City should not be empty");
            bindingResult.addError(error);
        }

        if (customerDto.getCustomerDetailsDto().getCity().length() > 20 || customerDto.getCustomerDetailsDto().getCity().length() < 3) {
            FieldError error = new FieldError("customerDto", "customerDetailsDto.city", "City should be between 3 and 20 characters");
            bindingResult.addError(error);
        }

        if (customerDto.getCustomerDetailsDto().getHomePhone().isEmpty()) {
            FieldError error = new FieldError("customerDto", "customerDetailsDto.homePhone", "Home Phone should not be empty");
            bindingResult.addError(error);
        }

        if (customerDto.getCustomerDetailsDto().getHomePhone().length() > 10 || customerDto.getCustomerDetailsDto().getHomePhone().length() < 6) {
            FieldError error = new FieldError("customerDto", "customerDetailsDto.homePhone", "Home Phone should be between 6 and 10 numbers");
            bindingResult.addError(error);
        }

        if (customerDto.getCustomerDetailsDto().getCellphone().isEmpty()) {
            FieldError error = new FieldError("customerDto", "customerDetailsDto.cellphone", "Mobile phone should not be empty");
            bindingResult.addError(error);
        }

        if (customerDto.getCustomerDetailsDto().getCellphone().length() > 10 || customerDto.getCustomerDetailsDto().getCellphone().length() < 6) {
            FieldError error = new FieldError("customerDto", "customerDetailsDto.cellphone", "Mobile phone should be between 6 and 10 numbers");
            bindingResult.addError(error);
        }
        */
        // Check for the numbers if needed
        /*
        try {
            //double d = Double.parseDouble(customerDto.getCustomerDetailsDto().getCellphone());
            int a = Integer.parseInt(customerDto.getCustomerDetailsDto().getCellphone());
        } catch (NumberFormatException e) {
            FieldError error2 = new FieldError("dto", "customerDetailsDto.cellphone", "Mobile phone should be a number");
            bindingResult.addError(error2);
        }
        */

        if (bindingResult.hasErrors()) {
            System.out.println("error--------");

            return "edit";
        } else {
            customerDto.setActive(true);
            customerDto.setRegDate(LocalDate.now());
            customerService.saveOrUpdate(customerDto);
        }

        redirectAttributes.addFlashAttribute("message", "User user id: "
                + customerDto.getCustomerId() + " was edited.");
        redirectAttributes.addFlashAttribute("alertClass", "alert-info");

        return "redirect:/customer/";
    }


}

