package com.agh.command.implementations;

import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;
import pl.edu.agh.kis.visca.cmd.PanTiltLeftCmd;

public class PanTiltLeft extends ViscaCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        byte[] commandData = getCommandData(new PanTiltLeftCmd());
        viscaConnection.writeBytes(commandData);
        return viscaConnection.readResponse();
    }

    @Override
    public String getCode() {
        return "move-left";
    }

    @Override
    protected byte getDefaultSourceAddress() {
        return 0;
    }

    @Override
    protected byte getDefaultDestinationAddress() {
        return 1;
    }
}
