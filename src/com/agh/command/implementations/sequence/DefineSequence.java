package com.agh.command.implementations.sequence;

import com.agh.cli.CommandLine;
import com.agh.command.CommandParameterException;
import com.agh.command.CommandRegistry;
import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;

import java.util.ArrayList;
import java.util.List;

public class DefineSequence extends ViscaCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        List<ViscaCommand> commands = new ArrayList<>();
        ViscaCommand command = null;

        // only for param validation
        String seqName = getRequiredParam("name");
        CommandLine commandLine = new CommandLine(" " + seqName + "$ ");

        while (command == null || !command.getCode().equals(CommandRegistry.END_SEQ.getCode())) {
            command = commandLine.readCommand();
            commands.add(command);
        }

        SequenceRegistry.INSTANCE.add(seqName, new Sequence(commands));

        return new ViscaResponse(new byte[0]);
    }

    @Override
    public String getCode() {
        return "seq";
    }
}
