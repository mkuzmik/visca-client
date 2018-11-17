package com.agh.command;

import com.agh.command.implementations.PanTiltDown;
import com.agh.command.implementations.SendAddress;

import java.util.Arrays;

public enum CommandRegister {

    PAN_TILT_DOWN(new PanTiltDown()),
    SEND_ADDRESS(new SendAddress());


    CommandRegister(ViscaCommand command) {
        this.command = command;
        this.code = command.getCode();
    }

    private String code;
    private ViscaCommand command;

    public String getCode() {
        return code;
    }

    public ViscaCommand getCommand() {
        return command;
    }

    public static ViscaCommand getByCode(String code) {
        return Arrays.stream(CommandRegister.values())
                .filter(command -> command.getCode().equals(code))
                .findFirst()
                .orElseThrow(CommandNotFoundException::new)
                .getCommand();
    }
}
