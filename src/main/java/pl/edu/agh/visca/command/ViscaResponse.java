package pl.edu.agh.visca.command;

import pl.edu.agh.visca.Util;
import pl.edu.agh.visca.cli.Logger;

public class ViscaResponse {

    private byte[] data;

    public ViscaResponse(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return Util.cloneByteArray(data);
    }

    public String humanized() {
        Logger.info("Response data fetching %s", Util.byteArrayToString(getData()));

        if (data.length > 0)
            return translateResponse(Util.byteArrayToString(getData()).trim());
        else
            return "OK";
    }

    private String translateResponse(String response) {
        for (ResponseMatch responseMatch : ResponseMatch.values()) {
            if (response.matches(responseMatch.getPattern())) {
                return responseMatch.getMessage();
            }
        }

        return String.format("Unknown response: %s", response);
    }

}
