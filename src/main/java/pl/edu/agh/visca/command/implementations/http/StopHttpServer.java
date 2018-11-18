package pl.edu.agh.visca.command.implementations.http;

import pl.edu.agh.visca.command.TechnicalCommand;
import pl.edu.agh.visca.command.ViscaResponse;
import pl.edu.agh.visca.connection.ViscaConnection;
import pl.edu.agh.visca.http.HttpServer;

public class StopHttpServer extends TechnicalCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        HttpServer.stop();
        return new ViscaResponse(new byte[0]);
    }

    @Override
    public String getCode() {
        return "stop-http";
    }
}
