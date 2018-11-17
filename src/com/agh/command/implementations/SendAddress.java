package com.agh.command.implementations;

import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;
import pl.edu.agh.kis.visca.cmd.AddressCmd;

public class SendAddress extends ViscaCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        viscaConnection.writeBytes(getCommandData());
        return viscaConnection.readResponse();
    }

    @Override
    public String getCode() {
        return "send-address";
    }

    private byte[] getCommandData() {
        byte[] cmdData = (new AddressCmd()).createCommandData();
        pl.edu.agh.kis.visca.cmd.ViscaCommand vCmd = new pl.edu.agh.kis.visca.cmd.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 8;
        return vCmd.getCommandData();
    }
}
