package com.agh.command;

import com.agh.command.implementations.*;

import java.util.Arrays;

/**
 * Each command must be registred here
 */
public enum CommandRegister {

    DOWN(new PanTiltDown()),
    UP(new PanTiltUp()),
    RIGHT(new PanTiltRight()),
    LEFT(new PanTiltLeft()),
    HOME(new PanTiltHome()),
    ABSOLUTE_POS(new PanTiltAbsolutePos()),
    GET_MAX_SPEED(new GetPanTiltMaxSpeed()),
    CLEAR_ALL(new ClearAll()),
    ZOOM_TELE(new ZoomTele()),
    ZOOM_WIDE(new ZoomWide()),
    ADDRESS(new SendAddress()),
    SLEEP(new Sleep());

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
