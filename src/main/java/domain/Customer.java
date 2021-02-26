package domain;

import java.util.Objects;

public class Customer {
    private int customer_id;
    private String name;
    private String city;

    public Customer(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Customer(int id, String name, String city) {
        this.customer_id = id;
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "customer_id: " + customer_id + ", name: " + name + ", city: " + city;
    }
}
