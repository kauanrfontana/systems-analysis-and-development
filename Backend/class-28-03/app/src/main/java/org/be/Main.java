package org.be;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpServer srv = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);

        srv.createContext("/index.html", new FileHandler("/index.html"));

        srv.start();
    }
}