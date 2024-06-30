package exercise;

class Address {
    @NotNull
    @MinLength
    private String country;

    @NotNull
    @MinLength
    private String city;

    @NotNull
    @MinLength
    private String street;

    @NotNull
    @MinLength
    private String houseNumber;

    @MinLength
    private String flatNumber;

    Address(String country, String city, String street, String houseNumber, String flatNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }
}