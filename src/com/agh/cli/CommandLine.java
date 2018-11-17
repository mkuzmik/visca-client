package com.agh.cli;

import com.agh.command.ViscaCommand;

import java.util.Scanner;

public class CommandLine {

    private final static String prompt = "$ ";

    Scanner scanner = new Scanner(System.in);

    public ViscaCommand readCommand() {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return CommandParser.parse(input);
    }

    public void print(String response) {
        System.out.println(response);
    }
}
