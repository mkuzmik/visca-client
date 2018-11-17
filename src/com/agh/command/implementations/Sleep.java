package com.agh.command.implementations;

import com.agh.command.TechnicalCommand;
import com.agh.command.ViscaCommand;
import com.agh.command.ViscaResponse;
import com.agh.connection.ViscaConnection;
import pl.edu.agh.kis.visca.cmd.ClearAllCmd;

public class Sleep extends TechnicalCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        try {
            Thread.sleep((long)(getTimeInSec() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ViscaResponse(new byte[0]);
    }

    @Override
    public String getCode() {
        return "sleep";
    }

    private int getTimeInSec() {
        String timeStr = getParams().getOrDefault("time", "1");
        return Integer.parseInt(timeStr);
    }
}
