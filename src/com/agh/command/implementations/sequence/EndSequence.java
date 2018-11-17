package com.agh.command.implementations.sequence;

import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;

public class EndSequence extends ViscaCommand {

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
