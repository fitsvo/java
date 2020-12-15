package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static final int SERVER_PORT = 8189;

    public static void main(String[] args) throws IOException {
        MyServer s = new MyServer();
        s.start();
        s.catchClient();
        Thread echoServer = new Thread(new GoThread(s));
        Thread consoleServer = new Thread(new GoConsoleThread(s));
        consoleServer.setDaemon(true);
        echoServer.start();
        consoleServer.start();
    }
}

class GoThread implements Runnable{
    private final MyServer serv;
    public GoThread(MyServer serv){
        this.serv = serv;
    }
    @Override
    public void run() {
        while (true) {
                String txt;
                try {
                    txt = serv.in.readUTF();
                    if (txt.equals("/end")) break;
                    serv.sendMessage(txt, "Echo: ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("Server has been closed");
        try {
            serv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class GoConsoleThread implements Runnable{
    private final MyServer serv;
    public GoConsoleThread(MyServer serv){
        this.serv = serv;
    }

    @Override
    public void run() {
        try {
            serv.writeToConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyServer {
    DataInputStream in = null;
    DataOutputStream out = null;
    ServerSocket serverSocket = null;
    Socket socket = null;
    BufferedReader console = null;

    void start() {
        try {
            serverSocket = new ServerSocket(EchoServer.SERVER_PORT);
        } catch (IOException e) {
            System.out.println("Can't open port " + EchoServer.SERVER_PORT);
            System.exit(1);
        }
        System.out.print("Server started. Waiting for a client...");
    }

    void catchClient() throws IOException {
        //while (!serverSocket.isClosed()) {
            try {
                socket = serverSocket.accept();
                System.out.println("Client connected");
            } catch (IOException e) {
                System.out.println("Can't accept");
                System.exit(1);
            }

            in  = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            //executeIt.execute();
            System.out.println("Wait for messages...");
       // }

    }

    void sendMessage(String msg, String typeMsg) throws IOException {
        out.writeUTF(typeMsg + msg);
        System.out.println(msg);
    }

    void close() throws IOException {
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }

    void writeToConsole() throws IOException {
        while (true) {
            console = new BufferedReader(new InputStreamReader(System.in));
            String txt = console.readLine();
            sendMessage(txt, "Server says: " );
        }
    }
}
