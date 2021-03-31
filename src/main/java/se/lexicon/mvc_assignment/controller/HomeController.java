package se.lexicon.mvc_assignment.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.lexicon.mvc_assignment.dto.CustomerDetailsDto;
import se.lexicon.mvc_assignment.dto.CustomerDto;
import se.lexicon.mvc_assignment.entity.Customer;
import se.lexicon.mvc_assignment.entity.CustomerDetails;


import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    List<CustomerDto> customerDtoList;
    List<CustomerDetailsDto> customerDetailsDtoList;

    @PostConstruct
    public void init() {
        if (customerDtoList == null) customerDtoList = new ArrayList<>();
        if (customerDetailsDtoList == null) customerDetailsDtoList = new ArrayList<>();

        //simple test
        //String "123e4567-e89b-12d3-a456-556642440000", String "gg@gmail.com", LocalDate
        CustomerDto customerDto = new CustomerDto();
        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();

        //another test
        Customer customer = new Customer();
        CustomerDetails customerDetails = new CustomerDetails();
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }


    /*
    @PostMapping(path = "/customer")
    public String email(@RequestParam String email, @RequestParam String street) {
        System.out.println("***********");
        System.out.println("email = " + email);
        System.out.println("street = " + street);
        System.out.println("***********");

        if (street == "") {
            //len, chars etc
            System.out.println("You need to write a street name");
        }

        String result = (street == "") ? " You need to write a street name" : " OK ";

        System.out.println(result);

        return "redirect:/customer/";
    }
    */

    @PostMapping("/customer")
    public String add(@ModelAttribute("dto") @Valid CustomerDto customerDto, BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.toString());
            FieldError error = new FieldError("dto","email","Email should not contain less than 6 or more than 35 characters");
            bindingResult.addError(error);
            return "/customer";
        }

        customerDtoList.add(customerDto);
        System.out.println(customerDtoList.toString());
        //maybe redirect to the page where all details are
        return "redirect:/customer/";
    }


    @GetMapping("/customer")
    public String customer(Model model) {
        System.out.println("--- GetMapping ---");
        return "customer";
    }


    @GetMapping("/details")
    public String details(Model model) {
        System.out.println("--- GetMapping ---");
        return "details";
    }


    @PostMapping("/details")
    public String addDetails(@ModelAttribute("dto") CustomerDetailsDto customerDetailsDto) {
        customerDetailsDtoList.add(customerDetailsDto);
        System.out.println(customerDetailsDtoList.toString());
        return "redirect:/details/";
    }


}
