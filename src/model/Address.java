package model;

import java.util.Optional;

public class Address {
    private String Street;
    private String City;
    private String ZipCode;
    private String Country;
    // ------------------------------------------------

    // Contructor -------------------------------------
    public Address(String street, String city, String zipCode, String country) {
        Street = street;
        City = city;
        ZipCode = zipCode;
        Country = country;
    }
    // ------------------------------------------------

    // Getter and Setter ------------------------------
    public String getStreet() {                 // Getter Street
        return Street;
    }

    public void setStreet(String street) {      // Setter Street
        Street = street;
    }

    public String getCity() {                   // Getter City
        return City;
    }

    public void setCity(String city) {          // Setter City
        City = city;
    }

    public String getZipCode() {                // Getter ZipCode
        return ZipCode;
    }

    public void setZipCode(String zipCode) {    // Setter ZipCode
        ZipCode = zipCode;
    }

    public String getCountry() {                // Getter Country
        return Country;
    }

    public void setCountry(String country) {    // Setter Country
        Country = country;
    }
    // ------------------------------------------------

    // toString ---------------------------------------

    @Override
    public String toString() {
        return "Address{" +
                "Street='" + Street + '\'' +
                ", City='" + City + '\'' +
                ", ZipCode='" + ZipCode + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
    // ------------------------------------------------
}
