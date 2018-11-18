package pl.edu.agh.visca.command.implementations.sequence;

import pl.edu.agh.visca.cli.CommandLine;
import pl.edu.agh.visca.command.CommandRegistry;
import pl.edu.agh.visca.command.TechnicalCommand;
import pl.edu.agh.visca.command.ViscaCommand;
import pl.edu.agh.visca.command.ViscaResponse;
import pl.edu.agh.visca.connection.ViscaConnection;

import java.util.ArrayList;
import java.util.List;

public class DefineSequence extends TechnicalCommand {

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
