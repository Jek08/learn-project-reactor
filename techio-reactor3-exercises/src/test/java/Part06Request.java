//generic imports to help with simpler IDEs (ie tech.io)
import java.util.*;
import java.util.function.*;
import java.time.*;

import io.pivotal.literx.domain.User;
import io.pivotal.literx.repository.ReactiveRepository;
import io.pivotal.literx.repository.ReactiveUserRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * Learn how to control the demand.
 *
 * @author Sebastien Deleuze
 */
public class Part06Request {

    ReactiveRepository<User> repository = new ReactiveUserRepository();

//========================================================================================

    // Create a StepVerifier that initially requests all values and expect 4 values to be received - done
    StepVerifier requestAllExpectFour(Flux<User> flux) {
        return StepVerifier.create(flux)
                .expectNextCount(4)
                .expectComplete();
    }

//========================================================================================

    // Create a StepVerifier that initially requests 1 value and expects User.SKYLER then requests another value and expects User.JESSE then stops verifying by cancelling the source - done
    StepVerifier requestOneExpectSkylerThenRequestOneExpectJesse(Flux<User> flux) {
        return StepVerifier.create(flux)
                .thenRequest(1)
                .expectNextMatches((user) -> user == User.SKYLER)
                .thenRequest(1)
                .expectNextMatches((user) -> user == User.JESSE)
                .thenCancel();
    }

//========================================================================================

    // TODO Return a Flux with all users stored in the repository that prints automatically logs for all Reactive Streams signals
    Flux<User> fluxWithLog() {
        return repository.findAll()
                .log();
    }

//========================================================================================

    // Return a Flux with all users stored in the repository that prints "Starring:" at first, "firstname lastname" for all values and "The end!" on complete - done
    Flux<User> fluxWithDoOnPrintln() {
        return repository.findAll()
                .doFirst(() -> System.out.println("Starring:"))
                .doOnNext(user -> System.out.printf("%s %s\n", user.getFirstname(), user.getLastname()))
                .doOnComplete(() -> System.out.println("The end!"));
    }

}
