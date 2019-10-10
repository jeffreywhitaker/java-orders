package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service(value ="customerService")
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository custrepos;

    @Override
    public List<Customer> findall()
    {
        List<Customer> rtnList = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(rtnList::add);
        return rtnList;
    }

    @Override
    public Customer findById(long id)
    {
        return null;
    }

    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        Customer newCustomer = new Customer();

        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setAgent(customer.getAgent());

        return custrepos.save(newCustomer);
    }

    @Override
    public Customer update(Customer customer, long id)
    {
        // Does the customer exist already?
        Optional<Customer> optionalUpdateCustomer = custrepos.findById(id);
        // If not, abort
        if (optionalUpdateCustomer.isEmpty())
        {
            return null;
        }
        // Take the updated customer object and slap the id on so that custrepos knows which entry to update
        customer.setCustcode(id);
        // update the customer
        return custrepos.save(customer);
    }

    @Override
    public void delete(long id)
    {
        custrepos.deleteById(id);
    }
}
