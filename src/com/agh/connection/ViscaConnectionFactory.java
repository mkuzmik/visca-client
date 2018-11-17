package com.agh.connection;

public class ViscaConnectionFactory {

    public static ViscaConnection getStubConnection() {
        return new StubConnection();
    }

    public static ViscaConnection getViscaConnection(String portname) {
        return new SerialConnection(portname);
    }
}
