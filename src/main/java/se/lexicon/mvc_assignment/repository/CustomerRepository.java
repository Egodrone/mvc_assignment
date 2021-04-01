package se.lexicon.mvc_assignment.repository;


import org.springframework.data.repository.CrudRepository;
import se.lexicon.mvc_assignment.entity.Customer;


import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByNameIgnoreCase(String name);
    List<Customer> findAll();
}