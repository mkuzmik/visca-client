package com.agh.command.implementations.sequence;

import com.agh.cli.CommandLine;
import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;

import java.util.List;

public class Sequence extends ViscaCommand {

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
