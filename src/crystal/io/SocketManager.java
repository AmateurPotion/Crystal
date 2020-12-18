package crystal.io;

import arc.util.Log;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketManager {
    private String host = "localhost";
    private Integer port = 14792;

    public void receiver(){
        try {
            Socket socket = new Socket(host, port);
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            osw.write("hellow");

            socket.close();
        } catch (IOException e) {
            Log.info(e);
        }
    }
}
