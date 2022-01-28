package org.obiwan.kafka;

import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.reactive.messaging.*;
import org.obiwan.kafka.model.Quote;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.Random;
import java.util.stream.Stream;

@ApplicationScoped
public class ReactiveProcessorApplication {

    private Random random = new Random();

    @Incoming("requests")
    @Outgoing("quotes")
    public Quote process(String quoteRequest) throws InterruptedException {
        Thread.sleep(200);
        return new Quote(quoteRequest, random.nextDouble());
    }
}
