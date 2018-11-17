package com.agh;

import com.agh.cli.CommandLine;
import com.agh.command.ViscaCommand;
import com.agh.connection.ViscaConnection;

public class SimpleCliRunner {

    public static void run(ViscaConnection connection) {
        CommandLine commandLine = new CommandLine();

        while (true) {
            try {
                ViscaCommand viscaCommand = commandLine.readCommand();
                commandLine.print(viscaCommand.execute(connection));
            } catch (Exception e) {
                commandLine.print(e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
    }
}
