package io.pivotal.literx;

//generic imports to help with simpler IDEs (ie tech.io)

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
public class Part01Flux {

//========================================================================================

    // Return empty flux using Flux#empty() - done
    Flux<String> emptyFlux() {
        Flux<String> empty = Flux.empty();
        return empty;
    }

//========================================================================================

    // Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection - done
    Flux<String> fooBarFluxFromValues() {
        Flux<String> foobar = Flux.just("foo", "bar");
        foobar.subscribe();
        return foobar;
    }

//========================================================================================

    // Create a Flux from a List that contains 2 values "foo" and "bar" - done
    Flux<String> fooBarFluxFromList() {
        List<String> myList = Arrays.asList("foo", "bar");
        Flux<String> myFlux = Flux.fromIterable(myList);
        myFlux.subscribe();
        return myFlux;
    }

//========================================================================================

    // Create a Flux that emits an IllegalStateException - done
    Flux<String> errorFlux() {
        Flux<String> myFlux = Flux.error(new IllegalStateException());
        myFlux.subscribe();
        return myFlux;
    }

//========================================================================================

    // Create a Flux that emits increasing values from 0 to 9 each 100ms - done
    Flux<Long> counter() {
        Flux<Long> myFlux = Flux.interval(Duration.ofMillis(100)).take(10);
        return myFlux;
    }

}
