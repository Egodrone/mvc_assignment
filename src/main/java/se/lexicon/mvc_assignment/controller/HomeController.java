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

        //simple test
        //String "123e4567-e89b-12d3-a456-556642440000", String "gg@gmail.com", LocalDate
        CustomerDto customerDto = new CustomerDto();
        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();

        //another test
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

        /*
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.toString());
            FieldError error = new FieldError("dto","email","Email should not contain less than 6 or more than 35 characters");
            bindingResult.addError(error);
            return "/customer";
        }
        */
        customerDtoList.add(customerDto);
        System.out.println(customerDtoList.toString());

        //test to fill with some data
        // Customer info
        customerDto.setActive(true);
        String id = "123e4567-e89b-12d3-a456-556642440000";
        customerDto.setCustomerId(id);
        LocalDate today = LocalDate.now();
        //LocalDate.parse("2021-03-31");
        customerDto.setRegDate(today);
        customerDto.getCustomerDetailsDto();

        // Customer Details dto
        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
        customerDetailsDto.setDetailsId(id);
        String zip = "89182982";
        customerDetailsDto.setZipCode(zip);
        String strName = "Name of the str";
        customerDetailsDto.setStreet(strName);
        customerDetailsDto.setHomePhone(zip);
        customerDetailsDto.setCellphone(zip);
        String city = "City name";
        customerDetailsDto.setCity(city);

        // save to the db
        //null pointer
        //customerService.saveOrUpdate(customerDto);
        customerService.saveOrUpdate(new CustomerDto(id, customerDto.getEmail(), today, true, customerDetailsDto));
        //maybe redirect to the page where all details are
        redirectAttributes.addFlashAttribute("message", "Customer with email: " + customerDto.getEmail() + " is Added");
        redirectAttributes.addFlashAttribute("alertClass","alert-success");
        return "redirect:/customer/";
    }


    @GetMapping("/customer")
    public String customer(Model model) {
        System.out.println("--- GetMapping ---");
        model.addAttribute("customerDtoList", customerService.getAll());
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


    @GetMapping("/customer/delete/{id}")
    public String deleteById(@PathVariable("id") String id, RedirectAttributes redirectAttributes){
        customerService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Delete Customer ID: " + id + " is Completed");
        redirectAttributes.addFlashAttribute("alertClass","alert-info");
        return "redirect:/customer/";
    }


}
