package com.agh.command.implementations;

import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;
import pl.edu.agh.kis.visca.cmd.GetPanTiltMaxSpeedCmd;
import pl.edu.agh.kis.visca.cmd.PanTiltHomeCmd;

public class GetPanTiltMaxSpeed extends ViscaCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        byte[] commandData = getCommandData(new GetPanTiltMaxSpeedCmd());
        viscaConnection.writeBytes(commandData);
        return viscaConnection.readResponse();
    }

    @Override
    public String getCode() {
        return "get-max-speed";
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
