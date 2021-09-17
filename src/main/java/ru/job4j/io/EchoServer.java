package ru.job4j.io;

import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String clientMessage = null;
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("?msg=")) {
                            clientMessage = str;
                        }
                    }
                    if (clientMessage != null) {
                        if (clientMessage.contains("?msg=Exit")) {
                            server.close();
                        } else if (clientMessage.contains("?msg=Hello")) {
                            out.write("Hello".getBytes());
                        } else {
                            out.write(clientMessage.split("msg=")[1].split(" ")[0].getBytes());
                        }
                    }
                    out.flush();
                } catch (IOException e) {
                    LOG.error("An error occurred when trying to open I/O stream in socket", e);
                }
            }
        } catch (IOException e) {
            LOG.error("An error occurred when trying to create new server socket", e);
        }
    }
}
