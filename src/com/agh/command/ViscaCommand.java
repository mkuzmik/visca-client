package com.agh.command;

import com.agh.connection.ViscaConnection;
import pl.edu.agh.kis.visca.cmd.Cmd;

import java.util.HashMap;
import java.util.Map;

public abstract class ViscaCommand {

    private Map<String, String> params;

    protected Map<String, String> getParams() {
        return params != null ? params : new HashMap<>();
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public abstract ViscaResponse execute(ViscaConnection viscaConnection);

    public abstract String getCode();

    protected byte[] getCommandData(Cmd cmd, byte sourceAdr, byte destinationAdr) {
        byte[] cmdData = cmd.createCommandData();
        pl.edu.agh.kis.visca.cmd.ViscaCommand vCmd = new pl.edu.agh.kis.visca.cmd.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = sourceAdr;
        vCmd.destinationAdr = destinationAdr;
        return vCmd.getCommandData();
    }

    protected String getRequiredParam(String param) {
        String value = getParams().get(param);
        if (value == null) {
            throw new CommandParameterException(String.format("Parameter %s is required", param));
        }
        return value;
    }
}
