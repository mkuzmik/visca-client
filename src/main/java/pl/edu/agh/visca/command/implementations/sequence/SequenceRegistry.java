package pl.edu.agh.visca.command.implementations.sequence;

import pl.edu.agh.visca.command.ViscaCommand;

import java.util.HashMap;
import java.util.Map;

public enum SequenceRegistry {

    INSTANCE;

    private Map<String, ViscaCommand> sequences = new HashMap<>();

    public void add(String name, ViscaCommand command) {
        sequences.put(name, command);
    }

    public ViscaCommand getByName(String name) {
        ViscaCommand command = sequences.get(name);
        if (command == null) {
            throw new SequenceDoesNotExistException();
        }
        return command;
    }
}
