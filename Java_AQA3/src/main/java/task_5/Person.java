package task_5;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
    private String name;
    private LocalDate birthdate;
    private Address address;

    public Person() {}

    public Person(String name, LocalDate birthdate, Address address) {
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', birthdate=" + birthdate + ", address=" + address + '}';
    }

    public static class Address {
        private String street;
        private String city;
        private String state;

        public Address() {}

        public Address(String street, String city, String state) {
            this.street = street;
            this.city = city;
            this.state = state;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return "Address{street='" + street + "', city='" + city + "', state='" + state + "'}";
        }
    }
}