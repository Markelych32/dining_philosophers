package ru.solonchev.utility;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class LogUtility {

    private static final String TIME_FORMAT_WITH_MS = "HH:mm:ss SSS";
    private static final String MESSAGE_TEMPLATE = "[%s] %s\n";


    public static void logMessage(@NotNull String message) {
        String logTime = LocalTime.now().format(DateTimeFormatter.ofPattern(TIME_FORMAT_WITH_MS, Locale.GERMANY));
        System.out.printf(MESSAGE_TEMPLATE, logTime, message);
    }

}
