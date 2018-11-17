package com.agh.command.implementations;

import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;
import pl.edu.agh.kis.visca.cmd.PanTiltRightCmd;

public class PanTiltRight extends ViscaCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        byte dest = extractDestinationAdr();
        byte[] commandData = getCommandData(new PanTiltRightCmd(), (byte) 0, dest);
        viscaConnection.writeBytes(commandData);
        return viscaConnection.readResponse();
    }

    @Override
    public String getCode() {
        return "move-right";
    }

    private byte extractDestinationAdr() {
        String destStr = getParams().getOrDefault("dest", "1");
        return Byte.parseByte(destStr);
    }
}
