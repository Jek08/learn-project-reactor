package dev.jakapw;

import reactor.core.publisher.Flux;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.trySubsWithCompletion();
    }

    void trySubs() {
        Flux<String> ints = Flux.just("la", "di", "du");
        ints.subscribe(System.out::println);
    }

    void trySubsWithErr() {
        Flux<Integer> ints = Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) return i;
                    throw new RuntimeException("Got to 4");
                });
        ints.subscribe(i -> System.out.println(i), err -> System.err.println("Error: " + err));
    }

    void trySubsWithCompletion() {
        Flux<Integer> ints = Flux.range(1, 4);
        ints.subscribe(
                i -> System.out.println(i),
                err -> System.err.println("Error: " + err),
                () -> System.out.println("DONE"));
    }
}
