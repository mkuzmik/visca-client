package pl.edu.agh.visca.connection;

import pl.edu.agh.visca.command.ViscaResponse;
import pl.edu.agh.visca.Util;

public class StubConnection implements ViscaConnection {

    @Override
    public ViscaResponse readResponse() {
        return new ViscaResponse(new byte[] {0, 1, 2, 3, 4, 5, 6});
    }

    @Override
    public boolean writeBytes(byte[] data) {
        System.out.println("Writing data: " + Util.byteArrayToString(data));
        return true;
    }
}
