package org.acme.quickstart.domain.events;

public class AddressCreated {

    String id;

    String street;

    public AddressCreated(String id, String street) {
        this.id = id;
        this.street = street;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
