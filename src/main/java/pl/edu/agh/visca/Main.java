package pl.edu.agh.visca;


import pl.edu.agh.visca.cli.Logger;
import pl.edu.agh.visca.connection.ViscaConnection;
import pl.edu.agh.visca.connection.ViscaConnectionFactory;

public class Main {

    public static void main(String[] args) {
        ViscaConnection connection = getViscaConnection(args);

        if (args.length > 1) {
            boolean logger = Boolean.parseBoolean(args[1]);
            Logger.loggingEnabled = logger;
        }

        SimpleCliRunner.run(connection);
    }

    private static ViscaConnection getViscaConnection(String[] args) {
        ViscaConnection connection;
        if (args.length > 0) {
            connection = ViscaConnectionFactory.getViscaConnection(args[0]);
        } else {
            connection = ViscaConnectionFactory.getStubConnection();
        }
        return connection;
    }
}
