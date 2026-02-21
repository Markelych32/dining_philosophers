package ru.solonchev;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.solonchev.entity.Philosopher;

import java.util.Arrays;
import java.util.stream.IntStream;

import static ru.solonchev.Constant.WASTE_TIME_MS;

public class DinnerCoordinator {

    private static final int CYCLE_COUNT = 3;

    private final Philosopher[] philosophers;

    public DinnerCoordinator(@NotNull Philosopher[] philosophers) {
        this.philosophers = philosophers;
    }

    public void imitateDinnerProcess() {
        Arrays.stream(philosophers).forEach(ph -> {
            Thread philosopherThread = new Thread(new PhilosopherDiningProcess(ph));
            philosopherThread.start();
        });
    }


    private record PhilosopherDiningProcess(Philosopher philosopher) implements Runnable {

            @Override
            public void run() {
                IntStream.range(0, CYCLE_COUNT).forEach(_ -> {
                    philosopher.think();
                    philosopher.pickUpForkWithLowerNumber();
                    wasteSomeTime();
                    philosopher.pickUpForkWithHigherNumber();
                    philosopher.eat();
                    philosopher.putDownForkWithLowerNumber();
                    philosopher.putDownForkWithHigherNumber();
                });
            }

            @SneakyThrows
            private void wasteSomeTime() {
                Thread.sleep(WASTE_TIME_MS);
            }

        }

}
