package com.agh.cli;

import com.agh.command.CommandRegister;
import com.agh.command.ViscaCommand;

import java.util.Scanner;

public class CommandLine {

    private final static String prompt = "$ ";

    Scanner scanner = new Scanner(System.in);

    public ViscaCommand readCommand() {
        String input = readInput();
        return CommandParser.parse(input);
    }

    public ViscaCommand readSequence() {
        if (!readInput().equals("start")) {
            return CommandRegister.CLEAR_ALL.getCommand();
        }

        // TODO

        String input = "";
        do {
            input = readInput();

        } while (!input.equals("execute"));

        return null;
    }

    public void print(String response) {
        System.out.println(response);
    }

    private String readInput() {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
