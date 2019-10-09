package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value ="customerService")
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository custrepos;

    @Override
    public List<Customer> findall()
    {
        return null;
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
        return null;
    }

    @Override
    public Customer update(Customer customer, long id)
    {
        return null;
    }

    @Override
    public void delete(long id)
    {
        custrepos.deleteById(id);
    }
}
