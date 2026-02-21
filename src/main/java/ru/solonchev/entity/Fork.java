package ru.solonchev.entity;

import lombok.Data;
import lombok.SneakyThrows;

import static ru.solonchev.Constant.FORK_NAME_TEMPLATE;

@Data
public class Fork {

    private volatile boolean isUsed = false;

    private final int number;
    private final String name;


    public Fork(int number) {
        this.number = number;
        this.name = FORK_NAME_TEMPLATE.formatted(number);
    }

    @SneakyThrows
    public synchronized void pickUp() {
        while (isUsed) {
            wait();
        }
        isUsed = true;
    }

    public synchronized void putDown() {
        isUsed = false;
        notifyAll();
    }

}
