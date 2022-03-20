package com.netz00.libraryapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryAppApplication {

    private static final Logger LOGGER = LogManager.getLogger(LibraryAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LibraryAppApplication.class, args);
        LOGGER.info("\n" +
                "                       _ _           _   _                   _             _           _ \n" +
                "     /\\               | (_)         | | (_)                 | |           | |         | |\n" +
                "    /  \\   _ __  _ __ | |_  ___ __ _| |_ _  ___  _ __    ___| |_ __ _ _ __| |_ ___  __| |\n" +
                "   / /\\ \\ | '_ \\| '_ \\| | |/ __/ _` | __| |/ _ \\| '_ \\  / __| __/ _` | '__| __/ _ \\/ _` |\n" +
                "  / ____ \\| |_) | |_) | | | (_| (_| | |_| | (_) | | | | \\__ \\ || (_| | |  | ||  __/ (_| |\n" +
                " /_/    \\_\\ .__/| .__/|_|_|\\___\\__,_|\\__|_|\\___/|_| |_| |___/\\__\\__,_|_|   \\__\\___|\\__,_|\n" +
                "          | |   | |                                                                      \n" +
                "          |_|   |_|                                                                      " +
                "\n");

    }

}
