package com.agh.command.implementations.sequence;

import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;

public class ExecuteSequence extends ViscaCommand {

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
