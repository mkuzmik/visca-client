package com.agh.command.implementations;

import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;
import jssc.SerialPort;
import jssc.SerialPortException;
import pl.edu.agh.kis.visca.cmd.PanTiltDownCmd;

public class PanTiltDown extends ViscaCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        viscaConnection.writeBytes(getCommandData());
        return new ViscaResponse(viscaConnection.readResponse());
    }

    @Override
    public String getCode() {
        return "move-down";
    }

    private byte[] getCommandData() {
        byte[] cmdData = (new PanTiltDownCmd()).createCommandData();
        pl.edu.agh.kis.visca.cmd.ViscaCommand vCmd = new pl.edu.agh.kis.visca.cmd.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        return vCmd.getCommandData();
    }
}
