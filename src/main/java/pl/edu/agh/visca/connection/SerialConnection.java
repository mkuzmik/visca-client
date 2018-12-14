package pl.edu.agh.visca.connection;

import pl.edu.agh.visca.Util;
import pl.edu.agh.visca.cli.Logger;
import pl.edu.agh.visca.command.ViscaResponse;
import jssc.SerialPort;
import jssc.SerialPortException;
import pl.edu.agh.kis.visca.ViscaResponseReader;

public class SerialConnection implements ViscaConnection {

    private SerialPort serialPort;

    public SerialConnection(String portName) {
        initSerialPort(portName);
    }

    private void initSerialPort(String portName) {
        try {
            serialPort = new SerialPort(portName);
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
        } catch (SerialPortException ex) {
            throw new ViscaConnectionException("Serial port connection error", ex);
        }
    }

    public ViscaResponse readResponse() {
        try {
            byte[] response = ViscaResponseReader.readResponse(serialPort);
            return new ViscaResponse(response);
        } catch (ViscaResponseReader.TimeoutException ex) {
            throw new ViscaConnectionException("Timeout exception", ex);
        } catch (SerialPortException ex) {
            throw new ViscaConnectionException("Serial port unavailable", ex);
        }
    }

    public boolean writeBytes(byte[] data) {
        try {
            Logger.info("Writing bytes: %s", Util.byteArrayToString(data));
            return serialPort.writeBytes(data);
        } catch (SerialPortException ex) {
            throw new ViscaConnectionException("Cannot write to serial port", ex);
        }
    }

}