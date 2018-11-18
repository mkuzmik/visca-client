package pl.edu.agh.visca;

import pl.edu.agh.visca.cli.CommandLine;
import pl.edu.agh.visca.command.ViscaCommand;
import pl.edu.agh.visca.connection.ViscaConnection;

public class SimpleCliRunner {

    public static void run(ViscaConnection connection) {
        CommandLine commandLine = new CommandLine();

        while (true) {
            try {
                ViscaCommand viscaCommand = commandLine.readCommand();
                commandLine.print(viscaCommand.execute(connection));
            } catch (Exception e) {
                e.printStackTrace();
                // commandLine.print(e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
    }
}
