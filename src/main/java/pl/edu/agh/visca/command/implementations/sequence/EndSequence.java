package pl.edu.agh.visca.command.implementations.sequence;

import pl.edu.agh.visca.command.TechnicalCommand;
import pl.edu.agh.visca.command.ViscaResponse;
import pl.edu.agh.visca.connection.ViscaConnection;

public class EndSequence extends TechnicalCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        // do nothing
        return new ViscaResponse(new byte[0]);
    }

    @Override
    public String getCode() {
        return "end-seq";
    }
}
