package com.agh.connection;

import com.agh.Util;
import com.agh.command.ViscaResponse;
import jssc.SerialPort;
import jssc.SerialPortException;
import pl.edu.agh.kis.visca.ViscaResponseReader;
import pl.edu.agh.kis.visca.cmd.AddressCmd;
import pl.edu.agh.kis.visca.cmd.ViscaCommand;

public class ViscaConnection {

    private SerialPort serialPort;

    public ViscaConnection(String portName) {
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
            return serialPort.writeBytes(data);
        } catch (SerialPortException ex) {
            throw new ViscaConnectionException("Cannot write to serial port", ex);
        }
    }

}
