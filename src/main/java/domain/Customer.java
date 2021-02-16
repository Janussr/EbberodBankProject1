package domain;

import java.util.Objects;

public class Customer {
    private int customer_id;
    private String name;
    private String city;

    public Customer(int customer_id, String name, String city) {
        this.customer_id = customer_id;
        this.name = name;
        this.city = city;
    }

    public String getName() { return name; }

    //Måske den også skal return Custommer_ID og custommerCity, i så fald skal der lige laves nogen gettere også.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getName(), customer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
