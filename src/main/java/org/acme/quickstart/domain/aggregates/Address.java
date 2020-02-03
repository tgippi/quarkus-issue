package org.acme.quickstart.domain.aggregates;

import org.acme.quickstart.domain.commands.CreateAddress;
import org.acme.quickstart.domain.events.AddressCreated;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "address")
public class Address {

    @AggregateIdentifier
    @Id
    private String id;

    private String street;

    @CommandHandler
    public Address(CreateAddress cmd) {
        AggregateLifecycle.apply(new AddressCreated(cmd.getId(), cmd.getStreet()));
        this.id = cmd.getId();
    }

    @EventHandler
    public void on(AddressCreated evt) {
        this.street = evt.getStreet();
    }

}
