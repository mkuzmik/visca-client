package pl.edu.agh.visca.command.implementations.http;

import pl.edu.agh.visca.command.TechnicalCommand;
import pl.edu.agh.visca.command.ViscaResponse;
import pl.edu.agh.visca.connection.ViscaConnection;
import pl.edu.agh.visca.http.HttpServer;

public class StartHttpServer extends TechnicalCommand {

    @Override
    public ViscaResponse execute(ViscaConnection viscaConnection) {
        HttpServer.start(getPort(), viscaConnection);
        return new ViscaResponse(new byte[0]);
    }

    @Override
    public String getCode() {
        return "start-http";
    }

    private int getPort() {
        String portStr = getParams().getOrDefault("port", "8000");
        return Integer.valueOf(portStr);
    }
}
