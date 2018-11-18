package pl.edu.agh.visca.command;

/**
 * Command that has no effect on visca cam
 */
public abstract class TechnicalCommand extends ViscaCommand {

    @Override
    protected byte getDefaultDestinationAddress() {
        return 0;
    }

    @Override
    protected byte getDefaultSourceAddress() {
        return 0;
    }
}
