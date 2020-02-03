package org.acme.quickstart;

import io.quarkus.runtime.StartupEvent;
import org.acme.quickstart.domain.aggregates.Address;
import org.axonframework.common.transaction.NoTransactionManager;
import org.axonframework.config.AggregateConfigurer;
import org.axonframework.config.Configuration;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class AxonStarter {

    final static Logger LOG = LoggerFactory.getLogger(AxonStarter.class.getName());

    @Inject
    EntityManager em;

    void startup(@Observes StartupEvent e) {
        LOG.info("Axon configured");
        Configuration configuration = DefaultConfigurer
                .defaultConfiguration()
                .configureAggregate(AggregateConfigurer.jpaMappedConfiguration(Address.class, () -> em))
                .configureEmbeddedEventStore((c) ->
                        JpaEventStorageEngine.builder()
                                .entityManagerProvider(() -> em)
                                .transactionManager(NoTransactionManager.instance())
                                .build()).buildConfiguration();
        configuration.start();
    }

}
