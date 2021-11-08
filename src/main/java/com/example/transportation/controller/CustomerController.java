package com.example.transportation.controller;

import com.example.transportation.entity.Customer;
import com.example.transportation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        List<Customer> customersList = (List<Customer>) customerRepository.findAll();
        model.addAttribute("customersList", customersList);
        return "customers";
    }

    @GetMapping("/customers/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers-form";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{customerID}")
    public String editCustomer(@PathVariable("customerID") Long customerID, Model model) {
        if (customerRepository.findById(customerID).isPresent()) {
            Customer customer = customerRepository.findById(customerID).get();
            model.addAttribute("customer", customer);
            return "customers-form";
        } else {
            return "error";
        }
    }

    @RequestMapping("/customers/delete/{customerID}")
    public String deleteCustomer(@PathVariable("customerID") Long customerID, Model model) {
        if (customerRepository.findById(customerID).isPresent()) {
            customerRepository.deleteById(customerID);
            List<Customer> customersList = (List<Customer>) customerRepository.findAll();
            model.addAttribute("customersList", customersList);
            return "customers";
        } else {
            return "error";
        }
    }
}
