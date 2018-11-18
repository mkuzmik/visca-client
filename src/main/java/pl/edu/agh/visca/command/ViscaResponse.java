package pl.edu.agh.visca.command;

import pl.edu.agh.visca.Util;

public class ViscaResponse {

    private byte[] data;

    public ViscaResponse(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return Util.cloneByteArray(data);
    }
}
