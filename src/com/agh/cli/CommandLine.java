package com.agh.cli;

import com.agh.command.CommandRegistry;
import com.agh.command.ViscaCommand;

import java.util.Scanner;

public class CommandLine {

    private final static String prompt = "$ ";

    private Scanner scanner = new Scanner(System.in);

    public ViscaCommand readCommand() {
        String input = readInput();
        return CommandParser.parse(input);
    }

    public void print(String response) {
        System.out.println(response);
    }

    private String readInput() {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
