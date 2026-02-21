package ru.solonchev.entity;

import lombok.Data;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.solonchev.utility.LogUtility;
import ru.solonchev.utility.RandomUtility;

import java.util.concurrent.Semaphore;

import static ru.solonchev.Constant.*;

@Data
public class Philosopher {

    private final int number;
    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;
    private final Semaphore semaphore;


    public Philosopher(int number, @NotNull Fork leftFork, @NotNull Fork rightFork, @NotNull Semaphore semaphore) {
        this.number = number;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = PHILOSOPHER_NAME_TEMPLATE.formatted(number);
        this.semaphore = semaphore;
    }

    @SneakyThrows
    public void waitForSeat() {
        semaphore.acquire();
    }

    @SneakyThrows
    public void think() {
        int timeToThinkMs = RandomUtility.getRandomIntInclusive(LOWER_BOUND_THINK_TIME_MS, UPPER_BOUND_THINK_TIME_MS);
        LogUtility.logMessage(PHILOSOPHER_MESSAGE_THINK_TEMPLATE.formatted(name, timeToThinkMs));
        Thread.sleep(timeToThinkMs);
    }

    @SneakyThrows
    public void eat() {
        int timeToEatMs = RandomUtility.getRandomIntInclusive(LOWER_BOUND_EAT_TIME_MS, UPPER_BOUND_EAT_TIME_MS);
        Thread.sleep(timeToEatMs);
    }

    public void leaveSeat() {
        semaphore.release();
    }

    public void pickUpLeftFork() {
        pickUpFork(leftFork, LEFT_SIDE);
    }

    public void pickUpRightFork() {
        pickUpFork(rightFork, RIGHT_SIDE);
    }

    public void putDownLeftFork() {
        putDownFork(leftFork, LEFT_SIDE);
    }

    public void putDownRightFork() {
        putDownFork(rightFork, RIGHT_SIDE);
    }


    private void pickUpFork(@NotNull Fork fork, @NotNull String side) {
        fork.pickUp();
        LogUtility.logMessage(PHILOSOPHER_MESSAGE_PICKING_UP_FORK_TEMPLATE.formatted(name, side, fork.getName()));
    }

    private void putDownFork(@NotNull Fork fork, @NotNull String side) {
        fork.putDown();
        LogUtility.logMessage(PHILOSOPHER_MESSAGE_PUTTING_DOWN_FORK_TEMPLATE.formatted(name, side, fork.getName()));
    }

}
