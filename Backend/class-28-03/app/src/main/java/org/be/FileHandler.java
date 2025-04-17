package org.be;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class FileHandler implements HttpHandler {
    private String baseDir = "/home/aluno/web";
    private String ext;
    public FileHandler(String filePath) {
        baseDir += filePath;
        ext = baseDir.substring(baseDir.lastIndexOf(".") + 1);
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        Headers headers = httpExchange.getRequestHeaders();

        headers.set("Content-type", "text/" + ext);

        String fileResponse = baseDir;

        httpExchange.sendResponseHeaders(200, fileResponse.length());

        outputStream.write(fileResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }



}
