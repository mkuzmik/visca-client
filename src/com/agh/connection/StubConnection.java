package com.agh.connection;

import com.agh.command.ViscaResponse;

public class StubConnection implements ViscaConnection {

    @Override
    public ViscaResponse readResponse() {
        return new ViscaResponse(new byte[] {0, 1, 2, 3, 4, 5, 6});
    }

    @Override
    public boolean writeBytes(byte[] data) {
        System.out.println("Writing data: " + data);
        return true;
    }
}
