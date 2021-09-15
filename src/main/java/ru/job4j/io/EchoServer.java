package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String clientMessage = null;
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("?msg=")) {
                            clientMessage = str;
                        }
                    }
                    if (clientMessage != null) {
                        if (clientMessage.contains("?msg=Exit")) {
                            out.write("HTTP/1.1 503 Service Unavailable\r\n\r\n".getBytes());
                            server.close();
                        } else if (clientMessage.contains("?msg=Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello".getBytes());
                        } else {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write(clientMessage.split("msg=")[1].split(" ")[0].getBytes());
                        }
                    }
                    out.flush();
                }
            }
        }
    }
}
