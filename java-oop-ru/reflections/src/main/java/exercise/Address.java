package exercise;
import lombok.NonNull;
class Address {
    // BEGIN
    @NonNull
    // END
    private String country;

    // BEGIN
    @NonNull
    // END
    private String city;

    // BEGIN
    @NonNull
    // END
    private String street;

    // BEGIN
    @NonNull
    // END
    private String houseNumber;

    private String flatNumber;

    Address(String country, String city, String street, String houseNumber, String flatNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }
}
