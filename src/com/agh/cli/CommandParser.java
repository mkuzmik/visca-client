package com.agh.cli;

import com.agh.command.CommandRegister;
import com.agh.command.ViscaCommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandParser {

    /**
     * @param commandString: example "move-down", "sleep time=10s"
     * @return ViscaCommand subclass object with params set
     */
    public static ViscaCommand parse(String commandString) {
        List<String> splitted = Arrays.asList(commandString.split(" "));

        if (splitted.size() < 1) throw new InvalidCommandException("No command provided");

        ViscaCommand command = CommandRegister.getByCode(splitted.get(0));

        Map<String, String> params = new HashMap<>();

        splitted.forEach(param -> {
            if (param.equals(command.getCode())) {
                return;
            }

            String[] parameter = param.split("=");

            if (parameter.length < 2) throw new InvalidCommandException("Invalid parameter found. A" +
                    "All parameters must be declared as param_name=param_value e.g time=10s");

            params.put(parameter[0], parameter[1]);
        });

        command.setParams(params);
        return command;
    }
}
