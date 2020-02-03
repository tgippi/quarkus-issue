package org.acme.quickstart.domain.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class CreateAddress {

    @TargetAggregateIdentifier
    String id;

    String street;

    public CreateAddress(String street) {
        this.id = UUID.randomUUID().toString();
        this.street = street;
    }

    public String getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
