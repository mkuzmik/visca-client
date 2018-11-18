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

    public String humanized() {
        if (data.length > 0)
            return translateResponse(Util.byteArrayToString(getData()));
        else
            return "OK";
    }

    private String translateResponse(String response) {
        for (ResponseMatch responseMatch : ResponseMatch.values()) {
            if (response.matches(responseMatch.getPattern())) {
                return responseMatch.getMessage();
            }
        }

        return "Unknown response";
    }

}
