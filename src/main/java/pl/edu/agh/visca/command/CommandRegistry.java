package pl.edu.agh.visca.command;

import pl.edu.agh.visca.command.implementations.*;
import pl.edu.agh.visca.command.implementations.http.StartHttpServer;
import pl.edu.agh.visca.command.implementations.http.StopHttpServer;
import pl.edu.agh.visca.command.implementations.sequence.DefineSequence;
import pl.edu.agh.visca.command.implementations.sequence.EndSequence;
import pl.edu.agh.visca.command.implementations.sequence.ExecuteSequence;

import java.util.Arrays;

/**
 * Each command must be registred here
 */
public enum CommandRegistry {

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
    SLEEP(new Sleep()),
    DEFINE_SEQ(new DefineSequence()),
    END_SEQ(new EndSequence()),
    EXEC_SEQ(new ExecuteSequence()),
    START_HTTP(new StartHttpServer()),
    STOP_HTTP(new StopHttpServer());

    CommandRegistry(ViscaCommand command) {
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
        return Arrays.stream(CommandRegistry.values())
                .filter(command -> command.getCode().equals(code))
                .findFirst()
                .orElseThrow(CommandNotFoundException::new)
                .getCommand();
    }
}
