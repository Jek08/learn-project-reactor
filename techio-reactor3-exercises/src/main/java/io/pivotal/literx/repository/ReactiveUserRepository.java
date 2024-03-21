package io.pivotal.literx.repository;

import io.pivotal.literx.domain.User;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveUserRepository implements ReactiveRepository {
    @Override
    public Mono<Void> save(Publisher publisher) {
        return null;
    }

    @Override
    public Mono findFirst() {
        return null;
    }

    @Override
    public Flux findAll() {
        Flux<User> users = Flux.just(
                new User("swhite", "Skyler", "White"),
                new User("jpinkman", "Jesse", "Pinkman"),
                new User("wwhite", "Walter", "White"),
                new User("sgoodman", "Saul", "Goodman")
        );
        return null;
    }

    @Override
    public Mono findById(String id) {
        return null;
    }
}
