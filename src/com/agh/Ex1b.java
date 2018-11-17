package com.agh;

import com.agh.command.ViscaCommand;
import jssc.SerialPort;
import jssc.SerialPortException;
import pl.edu.agh.kis.visca.ViscaResponseReader;
import pl.edu.agh.kis.visca.cmd.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex1b {

    public static void run(String[] args) {
        String commName = args[0];
        SerialPort serialPort = new SerialPort(commName);

        try {
            init(serialPort);
            Scanner scan = new Scanner(System.in);
            String command = "";
            List<String> commands = new ArrayList<>();


            while (!command.equals("execute")) {
                String command = scan.nextLine();

                execute(serialPort, command);
            }

        } catch (SerialPortException var18) {
            System.out.println(var18);
        }
    }

    private static void execute(SerialPort serialPort, String command) throws SerialPortException {
        switch (command) {
            case "zoomWideStd":
                System.out.println("zoomWideStd executing");
                zoomWideStd(serialPort);
                break;
            case "zoomTeleStd":
                System.out.println("zoomTeleStd executing");
                zoomTeleStd(serialPort);
                break;
            case "getPanTiltMaxSpeed":
                System.out.println("getPanTiltMaxSpeed executing");
                getPanTiltMaxSpeed(serialPort);
                break;
            case "panTiltHome":
                System.out.println("panTiltHome executing");
                panTiltHome(serialPort);
                break;
            case "panTiltAbsolutePos":
                System.out.println("panTiltAbsolutePos executing");
                panTiltAbsolutePos(serialPort);
                break;
            case "panTiltRight":
                System.out.println("panTiltRight executing");
                panTiltRight(serialPort);
                break;
            case "panTiltRight2":
                System.out.println("panTiltRight2 executing");
                panTiltRight2(serialPort);
                break;
            case "panTiltLeft":
                System.out.println("panTiltLeft executing");
                panTiltLeft(serialPort);
                break;
            case "panTiltLeft2":
                System.out.println("panTiltLeft2 executing");
                panTiltLeft2(serialPort);
                break;
            case "panTiltUp":
                System.out.println("panTiltUp executing");
                panTiltUp(serialPort);
                break;
            case "panTiltDown":
                System.out.println("panTiltDown executing");
                panTiltDown(serialPort);
                break;
            case "sleep 5s":
                System.out.println("sleeping 5s");
                sleep(5);
                break;
            case "sleep 10s":
                System.out.println("sleeping 10s");
                sleep(10);
                break;
            default:
                System.out.println("unknown command");
                break;
        }
    }

    private static void init(SerialPort serialPort) throws SerialPortException {
        serialPort.openPort();
        serialPort.setParams(9600, 8, 1, 0);
        System.out.println("Address");
        sendAddress(serialPort);

        byte[] response;
        try {
            response = ViscaResponseReader.readResponse(serialPort);
            System.out.println("> " + byteArrayToString(response));
        } catch (ViscaResponseReader.TimeoutException var17) {
            System.out.println("! TIMEOUT exception");
        }
    }

    private static void panTiltDown(SerialPort serialPort) throws SerialPortException {
        byte[] response;
        System.out.println("Down");
        sendPanTiltDown(serialPort);

        try {
            response = ViscaResponseReader.readResponse(serialPort);
            System.out.println("> " + byteArrayToString(response));
        } catch (ViscaResponseReader.TimeoutException var5) {
            System.out.println("! TIMEOUT exception");
        }
    }

    private static void panTiltLeft2(SerialPort serialPort) throws SerialPortException {
        byte[] response;
        sendPanTiltLeft2(serialPort);

        try {
            response = ViscaResponseReader.readResponse(serialPort);
            System.out.println("> " + byteArrayToString(response));
        } catch (ViscaResponseReader.TimeoutException var6) {
            System.out.println("! TIMEOUT exception");
        }
    }

    private static void panTiltLeft(SerialPort serialPort) throws SerialPortException {
        byte[] response;
        System.out.println("Left");
        sendPanTiltLeft(serialPort);

        try {
            response = ViscaResponseReader.readResponse(serialPort);
            System.out.println("> " + byteArrayToString(response));
        } catch (ViscaResponseReader.TimeoutException var7) {
            System.out.println("! TIMEOUT exception");
        }
    }

    private static void panTiltUp(SerialPort serialPort) throws SerialPortException {
        byte[] response;
        System.out.println("Up");
        sendPanTiltUp(serialPort);

        try {
            response = ViscaResponseReader.readResponse(serialPort);
            System.out.println("> " + byteArrayToString(response));
        } catch (ViscaResponseReader.TimeoutException var9) {
            System.out.println("! TIMEOUT exception");
        }
    }

    private static void panTiltRight2(SerialPort serialPort) throws SerialPortException {
        byte[] response;
        sendPanTiltRight2(serialPort);

        try {
            response = ViscaResponseReader.readResponse(serialPort);
            System.out.println("> " + byteArrayToString(response));
        } catch (ViscaResponseReader.TimeoutException var10) {
            System.out.println("! TIMEOUT exception");
        }
    }

    private static void panTiltRight(SerialPort serialPort) throws SerialPortException {
        byte[] response;
        System.out.println("Right");
        sendPanTiltRight(serialPort);

        try {
            response = ViscaResponseReader.readResponse(serialPort);
            System.out.println("> " + byteArrayToString(response));
        } catch (ViscaResponseReader.TimeoutException var11) {
            System.out.println("! TIMEOUT exception");
        }
    }

    private static void panTiltAbsolutePos(SerialPort serialPort) throws SerialPortException {
        byte[] response;
        System.out.println("Absolute Pos");
        sendPanTiltAbsolutePos(serialPort);

        try {
            response = ViscaResponseReader.readResponse(serialPort);
            System.out.println("> " + byteArrayToString(response));
        } catch (ViscaResponseReader.TimeoutException var12) {
            System.out.println("! TIMEOUT exception");
        }
    }

    private static void getPanTiltMaxSpeed(SerialPort serialPort) throws SerialPortException {
        byte[] response;
        System.out.println("Get Pan TiltMax Speed");
        sendGetPanTiltMaxSpeed(serialPort);

        try {
            response = ViscaResponseReader.readResponse(serialPort);
            System.out.println("> " + byteArrayToString(response));
        } catch (ViscaResponseReader.TimeoutException var13) {
            System.out.println("! TIMEOUT exception");
        }
    }

    private static void zoomTeleStd(SerialPort serialPort) throws SerialPortException {
        byte[] response;
        System.out.println("Tele");
        sendZoomTeleStd(serialPort);

        try {
            response = ViscaResponseReader.readResponse(serialPort);
            System.out.println("> " + byteArrayToString(response));
        } catch (ViscaResponseReader.TimeoutException var14) {
            System.out.println("! TIMEOUT exception");
        }
    }

    private static void zoomWideStd(SerialPort serialPort) throws SerialPortException {
        byte[] response;
        System.out.println("Wide");
        sendZoomWideStd(serialPort);

        try {
            response = ViscaResponseReader.readResponse(serialPort);
            System.out.println("> " + byteArrayToString(response));
        } catch (ViscaResponseReader.TimeoutException var15) {
            System.out.println("! TIMEOUT exception");
        }
    }

    private static void panTiltHome(SerialPort serialPort) throws SerialPortException {
        byte[] response;
        sendPanTiltHome(serialPort);

        try {
            response = ViscaResponseReader.readResponse(serialPort);
            System.out.println("> " + byteArrayToString(response));
        } catch (ViscaResponseReader.TimeoutException var16) {
            System.out.println("! TIMEOUT exception");
        }
    }

    private static void sleep(int timeSec) {
        try {
            Thread.sleep((long) (timeSec * 1000));
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }

    private static void sendClearAll(SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = (new ClearAllCmd()).createCommandData();
        com.agh.command.ViscaCommand vCmd = new com.agh.command.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 8;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }

    private static void sendPanTiltHome(SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = (new PanTiltHomeCmd()).createCommandData();
        com.agh.command.ViscaCommand vCmd = new com.agh.command.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }

    private static void sendPanTiltLeft(SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = (new PanTiltLeftCmd()).createCommandData();
        com.agh.command.ViscaCommand vCmd = new com.agh.command.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }

    private static void sendPanTiltLeft2(SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = (new PanTiltLeftCmd()).createCommandData();
        com.agh.command.ViscaCommand vCmd = new com.agh.command.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 2;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }

    private static void sendPanTiltRight(SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = (new PanTiltRightCmd()).createCommandData();
        com.agh.command.ViscaCommand vCmd = new com.agh.command.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }

    private static void sendPanTiltRight2(SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = (new PanTiltRightCmd()).createCommandData();
        com.agh.command.ViscaCommand vCmd = new com.agh.command.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 2;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }

    private static void sendPanTiltUp(SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = (new PanTiltUpCmd()).createCommandData();
        com.agh.command.ViscaCommand vCmd = new ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }

    private static void sendPanTiltDown(SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = (new PanTiltDownCmd()).createCommandData();
        com.agh.command.ViscaCommand vCmd = new com.agh.command.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }

    private static void sendPanTiltAbsolutePos(SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = (new PanTiltAbsolutePosCmd()).createCommandData();
        com.agh.command.ViscaCommand vCmd = new com.agh.command.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }

    private static void sendAddress(SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = (new AddressCmd()).createCommandData();
        com.agh.command.ViscaCommand vCmd = new com.agh.command.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 8;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }

    private static void sendGetPanTiltMaxSpeed(SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = (new GetPanTiltMaxSpeedCmd()).createCommandData();
        com.agh.command.ViscaCommand vCmd = new com.agh.command.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }

    private static String byteArrayToString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        byte[] var5 = bytes;
        int var4 = bytes.length;

        for (int var3 = 0; var3 < var4; ++var3) {
            byte b = var5[var3];
            sb.append(String.format("%02X ", b));
        }

        return sb.toString();
    }

    private static void sendZoomTeleStd(SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = (new ZoomTeleStdCmd()).createCommandData();
        com.agh.command.ViscaCommand vCmd = new com.agh.command.ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }

    private static void sendZoomWideStd(SerialPort serialPort) throws SerialPortException {
        byte[] cmdData = (new ZoomWideStdCmd()).createCommandData();
        com.agh.command.ViscaCommand vCmd = new ViscaCommand();
        vCmd.commandData = cmdData;
        vCmd.sourceAdr = 0;
        vCmd.destinationAdr = 1;
        cmdData = vCmd.getCommandData();
        System.out.println("@ " + byteArrayToString(cmdData));
        serialPort.writeBytes(cmdData);
    }
}
