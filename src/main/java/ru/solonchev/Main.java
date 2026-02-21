package ru.solonchev;

import ru.solonchev.entity.Fork;
import ru.solonchev.entity.Philosopher;

import java.util.stream.IntStream;

import static ru.solonchev.Constant.NUMBER_OF_FORKS;
import static ru.solonchev.Constant.NUMBER_OF_PHILOSOPHERS;

public class Main {

    static void main() {
        Fork[] forks = new Fork[NUMBER_OF_FORKS];
        Philosopher[] philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];

        IntStream.range(0, NUMBER_OF_FORKS).forEach(i -> forks[i] = new Fork(i));
        IntStream.range(0, NUMBER_OF_PHILOSOPHERS).forEach(i -> {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % NUMBER_OF_FORKS];
            philosophers[i] = new Philosopher(i, leftFork, rightFork);
        });

        DinnerCoordinator dinnerCoordinator = new DinnerCoordinator(philosophers);
        dinnerCoordinator.imitateDinnerProcess();
    }

}