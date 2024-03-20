package io.pivotal.literx;

//generic imports to help with simpler IDEs (ie tech.io)
import java.util.*;
import java.util.function.*;
import java.time.*;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to merge flux.
 *
 * @author Sebastien Deleuze
 */
public class Part05Merge {

//========================================================================================

    // Merge flux1 and flux2 values with interleave - done
    Flux<User> mergeFluxWithInterleave(Flux<User> flux1, Flux<User> flux2) {
        Flux<User> merged = Flux.merge(flux1, flux2);
        return merged;
    }

//========================================================================================

    // Merge flux1 and flux2 values with no interleave (flux1 values and then flux2 values) - done
    Flux<User> mergeFluxWithNoInterleave(Flux<User> flux1, Flux<User> flux2) {
        Flux<User> mergedInOrder = Flux.concat(flux1, flux2);
        return mergedInOrder;
    }

//========================================================================================

    // Create a Flux containing the value of mono1 then the value of mono2 - done
    Flux<User> createFluxFromMultipleMono(Mono<User> mono1, Mono<User> mono2) {
        Flux<User> monoMergedInOrder = Flux.concat(mono1, mono2);
        return monoMergedInOrder;
    }

}
