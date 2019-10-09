package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "agents")
public class Agent
{
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long agentcode;

    private String agentname;
    private String workingarea;
    private double commission;
    private String phone;
    private String country;

    @OneToMany
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties("agents")
    private Customer customer;

    // constructors
    public Agent(String agentname, String workingarea, double commission, String phone, String country)
    {
        this.agentname = agentname;
        this.workingarea = workingarea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
    }

    public Agent()
    {
    }

    // getters and setters
    public long getAgentcode()
    {
        return agentcode;
    }

    public void setAgentcode(long agentcode)
    {
        this.agentcode = agentcode;
    }

    public String getAgentname()
    {
        return agentname;
    }

    public void setAgentname(String agentname)
    {
        this.agentname = agentname;
    }

    public String getWorkingarea()
    {
        return workingarea;
    }

    public void setWorkingarea(String workingarea)
    {
        this.workingarea = workingarea;
    }

    public double getCommission()
    {
        return commission;
    }

    public void setCommission(double commission)
    {
        this.commission = commission;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
}
