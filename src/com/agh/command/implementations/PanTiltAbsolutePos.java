package com.agh.command.implementations;

import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;
import pl.edu.agh.kis.visca.cmd.GetPanTiltMaxSpeedCmd;
import pl.edu.agh.kis.visca.cmd.PanTiltAbsolutePosCmd;
import pl.edu.agh.kis.visca.cmd.PanTiltHomeCmd;

public class PanTiltAbsolutePos extends ViscaCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        byte[] commandData = getCommandData(new GetPanTiltMaxSpeedCmd(), (byte) 0, (byte) 1);
        viscaConnection.writeBytes(commandData);
        return viscaConnection.readResponse();
    }

    @Override
    public String getCode() {
        return "get-max-speed";
    }
}
