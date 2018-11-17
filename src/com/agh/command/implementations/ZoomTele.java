package com.agh.command.implementations;

import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;
import pl.edu.agh.kis.visca.cmd.PanTiltDownCmd;
import pl.edu.agh.kis.visca.cmd.ZoomTeleStdCmd;

public class ZoomTele extends ViscaCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        byte[] commandData = getCommandData(new ZoomTeleStdCmd(), (byte) 0, (byte) 1);
        viscaConnection.writeBytes(commandData);
        return viscaConnection.readResponse();
    }

    @Override
    public String getCode() {
        return "zoom-tele";
    }
}
