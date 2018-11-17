package com.agh.command.implementations;

import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;
import pl.edu.agh.kis.visca.cmd.AddressCmd;

public class SendAddress extends ViscaCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        byte[] commandData = getCommandData(new AddressCmd(), (byte) 0, (byte) 8);
        viscaConnection.writeBytes(commandData);
        return viscaConnection.readResponse();
    }

    @Override
    public String getCode() {
        return "send-address";
    }
}
