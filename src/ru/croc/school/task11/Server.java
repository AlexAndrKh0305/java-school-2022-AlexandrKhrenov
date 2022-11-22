package ru.croc.school.task11;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.io.Writer;

public class Server {

    public void connecting() throws IOException {
        ServerSocket serverSocket = new ServerSocket(2021);
        Socket socket = serverSocket.accept();
        OutputStream out = socket.getOutputStream();
        Writer w = new OutputStreamWriter(socket.getOutputStream());
        w.write("getting connection");
        w.flush();
    }
}
