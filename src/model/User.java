package model;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    AtomicInteger Auto = new AtomicInteger();
    private String id;
    private String username;
    private String email;
    private Address address;
    private String phonenumber;
    // ------------------------------------------------

    // Contructor -------------------------------------
    public User(String id, String username, String email, Address address, String phonenumber) {
        this.id = String.format("%03d", Auto.incrementAndGet());
        this.username = username;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
    }
    // ------------------------------------------------

    // Getter and Setter ------------------------------
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }

    public Optional<String> getPhoneNumber() {
        return Optional.ofNullable(phonenumber);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phonenumber = phoneNumber;
    }
    // ------------------------------------------------

    // toString ---------------------------------------
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + getAddress().map(Address::toString).orElse("N/A") +
                //", phonenumber=" + (phonenumber != null ? phonenumber : "N/A") + '\'' +         // ko dungf ddc .orElse("N/A") ??????????, nhuwng trar veef gioongs nau
                ", phonrnumber=" + getPhoneNumber().orElse("N/A") +
                '}';
    }
    // ------------------------------------------------
}
