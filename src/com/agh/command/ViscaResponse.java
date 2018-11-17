package com.agh.command;

import com.agh.Util;

public class ViscaResponse {

    private byte[] data;

    public ViscaResponse(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return Util.cloneByteArray(data);
    }
}
