package webshop.domain;

public class Contact {
    private String phone;
    private String email;

    public Contact(){}

    public Contact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
