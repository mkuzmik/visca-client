package pl.edu.agh.visca.connection;

import pl.edu.agh.visca.command.ViscaResponse;

public interface ViscaConnection {

    ViscaResponse readResponse();

    boolean writeBytes(byte[] data);

}
