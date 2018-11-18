package pl.edu.agh.visca.http;

import pl.edu.agh.visca.connection.ViscaConnection;
import spark.Spark;

public class HttpServer {

    public static void start(int port, ViscaConnection connection) {
        Spark.port(port);
        Spark.staticFiles.location("/public");
        Spark.post("/command", new CommandRoute(connection));
    }

    public static void stop() {
        Spark.stop();
    }
}
