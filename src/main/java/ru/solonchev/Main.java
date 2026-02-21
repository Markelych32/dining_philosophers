package ru.solonchev;

import ru.solonchev.entity.Fork;
import ru.solonchev.entity.Philosopher;

import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Main {

    private static final int NUMBER_OF_PHILOSOPHERS = 5;
    private static final int NUMBER_OF_FORKS = 5;


    static void main() {
        Semaphore semaphore = new Semaphore(NUMBER_OF_PHILOSOPHERS - 1);
        Fork[] forks = new Fork[NUMBER_OF_FORKS];
        Philosopher[] philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];

        IntStream.range(0, NUMBER_OF_FORKS).forEach(i -> forks[i] = new Fork(i));
        IntStream.range(0, NUMBER_OF_PHILOSOPHERS).forEach(i -> {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % NUMBER_OF_FORKS];
            philosophers[i] = new Philosopher(i, leftFork, rightFork, semaphore);
        });

        DinnerCoordinator dinnerCoordinator = new DinnerCoordinator(philosophers);
        dinnerCoordinator.imitateDinnerProcess();
    }

}
