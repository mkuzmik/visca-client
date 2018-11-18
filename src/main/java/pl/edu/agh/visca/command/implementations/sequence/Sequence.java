package pl.edu.agh.visca.command.implementations.sequence;

import pl.edu.agh.visca.cli.CommandLine;
import pl.edu.agh.visca.command.TechnicalCommand;
import pl.edu.agh.visca.command.ViscaCommand;
import pl.edu.agh.visca.command.ViscaResponse;
import pl.edu.agh.visca.connection.ViscaConnection;

import java.util.List;

public class Sequence extends TechnicalCommand {

    private List<ViscaCommand> commands;
    private CommandLine commandLine = new CommandLine();

    Sequence(List<ViscaCommand> commands) {
        this.commands = commands;
    }

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        commands.forEach(viscaCommand -> {
            commandLine.print(viscaCommand.execute(viscaConnection));
        });
        return new ViscaResponse(new byte[0]);
    }

    @Override
    public String getCode() {
        return null;
    }
}
