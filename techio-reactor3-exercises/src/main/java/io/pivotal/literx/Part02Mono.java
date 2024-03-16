package io.pivotal.literx;

//generic imports to help with simpler IDEs (ie tech.io)

import reactor.core.publisher.Mono;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 */
public class Part02Mono {

//========================================================================================

    // Return an empty Mono - done
    Mono<String> emptyMono() {
        Mono<String> empty = Mono.empty();
        return empty;
    }

//========================================================================================

    // Return a Mono that never emits any signal - done
    Mono<String> monoWithNoSignal() {
        Mono<String> noSignal = Mono.never();
        noSignal.subscribe();
        return noSignal;
    }

//========================================================================================

    // Return a Mono that contains a "foo" value - done
    Mono<String> fooMono() {
        Mono<String> foo = Mono.just("foo");
        foo.subscribe();
        return foo;
    }

//========================================================================================

    // Create a Mono that emits an IllegalStateException - done
    Mono<String> errorMono() {
        Mono<String> errMono = Mono.error(new IllegalStateException());
        errMono.subscribe();
        return errMono;
    }

}
