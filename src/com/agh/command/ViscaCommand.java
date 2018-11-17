package com.agh.command;

import com.agh.connection.ViscaConnection;

import java.util.Map;

public abstract class ViscaCommand {

    private Map<String, String> params;

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public abstract ViscaResponse execute(ViscaConnection viscaConnection);

    public abstract String getCode();
}
