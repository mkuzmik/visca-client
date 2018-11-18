package pl.edu.agh.visca.http;

import spark.Spark;

public class HttpServer {

    public static void start(int port) {
        Spark.port(port);
        Spark.staticFiles.location("/public");
        Spark.get("/hello", (req, res) -> "Hello World");
    }

    public static void stop() {
        Spark.stop();
    }
}
