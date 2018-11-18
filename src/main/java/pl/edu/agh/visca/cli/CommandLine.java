package pl.edu.agh.visca.cli;

import pl.edu.agh.visca.command.ViscaCommand;
import pl.edu.agh.visca.command.ViscaResponse;

import java.util.Scanner;

import static pl.edu.agh.visca.Util.byteArrayToString;

public class CommandLine {

    private String prompt = "$ ";

    private Scanner scanner = new Scanner(System.in);

    public CommandLine() {
        // default prompt
    }

    public CommandLine(String prompt) {
        this.prompt = prompt;
    }

    public ViscaCommand readCommand() {
        String input = readInput();
        return CommandParser.parse(input);
    }

    public void print(String response) {
        System.out.println(response);
    }

    public void print(ViscaResponse response) {
        byte[] data = response.getData();
        if (data.length > 0) {
            System.out.println("Response: " + byteArrayToString(data));
        } else {
            System.out.println("OK");
        }
    }

    private String readInput() {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
