package ru.solonchev;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constant {

    public static final String LEFT_SIDE = "left";
    public static final String RIGHT_SIDE = "right";

    public static final String PHILOSOPHER_NAME_TEMPLATE = "Philosopher %s";
    public static final String PHILOSOPHER_MESSAGE_THINK_TEMPLATE = "%s is thinking for %s ms";
    public static final String PHILOSOPHER_MESSAGE_PICKING_UP_FORK_TEMPLATE = "%s is picking up %s %s";
    public static final String PHILOSOPHER_MESSAGE_PUTTING_DOWN_FORK_TEMPLATE = "%s is putting down %s %s";

    public static final String FORK_NAME_TEMPLATE = "Fork №%s";

    public static final int LOWER_BOUND_THINK_TIME_MS = 10;
    public static final int UPPER_BOUND_THINK_TIME_MS = 30;
    public static final int LOWER_BOUND_EAT_TIME_MS = 2000;
    public static final int UPPER_BOUND_EAT_TIME_MS = 4000;
    public static final int WASTE_TIME_MS = 100;

}
