package pl.edu.agh.visca.command.implementations;

import pl.edu.agh.visca.command.TechnicalCommand;
import pl.edu.agh.visca.command.ViscaResponse;
import pl.edu.agh.visca.connection.ViscaConnection;

public class Sleep extends TechnicalCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        try {
            Thread.sleep((long)(getTimeInSec() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ViscaResponse(new byte[0]);
    }

    @Override
    public String getCode() {
        return "sleep";
    }

    private int getTimeInSec() {
        String timeStr = getParams().getOrDefault("time", "1");
        return Integer.parseInt(timeStr);
    }
}
