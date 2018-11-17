package com.agh.connection;

import com.agh.command.ViscaResponse;

public interface ViscaConnection {

    ViscaResponse readResponse();

    boolean writeBytes(byte[] data);

}
