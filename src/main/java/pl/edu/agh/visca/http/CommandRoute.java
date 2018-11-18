package pl.edu.agh.visca.http;

import pl.edu.agh.visca.command.CommandNotFoundException;
import pl.edu.agh.visca.command.CommandRegistry;
import pl.edu.agh.visca.command.ViscaCommand;
import pl.edu.agh.visca.connection.ViscaConnection;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommandRoute implements Route {

    private ViscaConnection connection;

    CommandRoute(ViscaConnection connection) {
        this.connection = connection;
    }

    @Override
    public Object handle(Request request, Response response) {
        Optional<String> maybeCommand = Optional.ofNullable(request.queryParams("cmd"));
        String cmd = maybeCommand.orElseThrow(CommandNotFoundException::new);
        ViscaCommand viscaCommand = CommandRegistry.getByCode(cmd);
        viscaCommand.setParams(getParams(request));

        return viscaCommand.execute(connection).humanized();
    }

    private Map<String, String> getParams(Request request) {
        return request.queryParams().stream()
                .collect(Collectors.toMap(Function.identity(), request::queryParams));
    }
}
