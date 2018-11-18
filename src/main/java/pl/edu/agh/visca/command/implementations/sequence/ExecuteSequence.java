package pl.edu.agh.visca.command.implementations.sequence;

import pl.edu.agh.visca.command.TechnicalCommand;
import pl.edu.agh.visca.command.ViscaCommand;
import pl.edu.agh.visca.command.ViscaResponse;
import pl.edu.agh.visca.connection.ViscaConnection;

public class ExecuteSequence extends TechnicalCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        ViscaCommand command = SequenceRegistry.INSTANCE.getByName(getRequiredParam("name"));
        return command.execute(viscaConnection);
    }

    @Override
    public String getCode() {
        return "execute-seq";
    }
}
