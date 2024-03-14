package dev.jakapw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread demoThread = new Thread(demo);
        final long startTime = System.currentTimeMillis();
        demoThread.start();
        try {
            demoThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Finished time: " + (endTime - startTime) + " ms");
    }
}

class Demo implements Runnable{
    List<Person> personList;

    void doDemo() {
        personList = List.of(
                new Person("1", "jak", 300),
                new Person("2", "gar", 250),
                new Person("3", "kae", 100),
                new Person("4", "jak", 300),
                new Person("5", "gar", 250),
                new Person("6", "kae", 100));

        var ids = ifhIds();

        var result = ids.thenComposeAsync(l -> {
            Stream<CompletableFuture<String>> zip = l.stream().map(i -> {
                CompletableFuture<String> nameTask = ifhName(i);

                CompletableFuture<Integer> statTask = ifhStat(i);

                return nameTask.thenCombineAsync(statTask, (name, stat) -> "Name " + name + "has stats " + stat);
            });

            List<CompletableFuture<String>> combinationList = zip.collect(Collectors.toList());
            CompletableFuture<String>[] combinationArray =
                    combinationList.toArray(new CompletableFuture[combinationList.size()]);

            CompletableFuture<Void> allDone = CompletableFuture.allOf(combinationArray);
            return allDone.thenApply(v -> combinationList.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList()));
        });

        List<String> results = result.join();
        results.stream().forEach(System.out::println);
    }

    CompletableFuture<List<String>> ifhIds() {
        List<String> result = List.of("1", "2", "3", "4", "5");
        return CompletableFuture.completedFuture(result);
    }

    CompletableFuture<String> ifhName(String id) {
        for(Person person: personList) {
            if (person.getId().equals(id))
                return CompletableFuture.completedFuture(person.getName());
        }
        return CompletableFuture.failedFuture(new Throwable("Id not match anyting"));
    }

    CompletableFuture<Integer> ifhStat(String id) {
        for(Person person: personList) {
            if (person.getId().equals(id))
                return CompletableFuture.completedFuture(person.getStat());
        }
        return CompletableFuture.failedFuture(new Throwable("Id not match anyting"));
    }

    @Override
    public void run() {
        doDemo();
    }
}