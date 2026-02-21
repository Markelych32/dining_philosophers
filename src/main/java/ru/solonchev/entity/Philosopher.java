package ru.solonchev.entity;

import lombok.Data;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.solonchev.utility.LogUtility;
import ru.solonchev.utility.RandomUtility;

import static ru.solonchev.Constant.*;

@Data
public class Philosopher {

    private final int number;
    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;


    public Philosopher(int number, @NotNull Fork leftFork, @NotNull Fork rightFork) {
        this.number = number;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = PHILOSOPHER_NAME_TEMPLATE.formatted(number);
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

    public void pickUpForkWithLowerNumber() {
        if (leftFork.getNumber() < rightFork.getNumber()) {
            pickUpFork(leftFork, LEFT_SIDE);
        } else {
            pickUpFork(rightFork, RIGHT_SIDE);
        }
    }

    public void pickUpForkWithHigherNumber() {
        if (leftFork.getNumber() > rightFork.getNumber()) {
            pickUpFork(leftFork, LEFT_SIDE);
        } else {
            pickUpFork(rightFork, RIGHT_SIDE);
        }
    }

    public void putDownForkWithLowerNumber() {
        if (leftFork.getNumber() < rightFork.getNumber()) {
            putDownFork(leftFork, LEFT_SIDE);
        } else {
            putDownFork(rightFork, RIGHT_SIDE);
        }
    }

    public void putDownForkWithHigherNumber() {
        if (leftFork.getNumber() > rightFork.getNumber()) {
            putDownFork(leftFork, LEFT_SIDE);
        } else {
            putDownFork(rightFork, RIGHT_SIDE);
        }
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
