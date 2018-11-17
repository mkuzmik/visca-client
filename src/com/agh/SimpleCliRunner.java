package com.agh;

import com.agh.cli.CommandLine;
import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;

public class SimpleCliRunner {

    public static void run(ViscaConnection connection) {
        CommandLine commandLine = new CommandLine();

        while (true) {
            try {
                ViscaCommand viscaCommand = commandLine.readCommand();
                ViscaResponse response = viscaCommand.execute(connection);
                commandLine.print(response.toString());
            } catch (Exception e) {
                commandLine.print(e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
    }
}
