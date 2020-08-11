package com.company;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class HomeHandler implements HttpHandler {

    LogManager logManager = LogManager.getLogManager();
    Logger logger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String methodName = exchange.getRequestMethod();
        if(Objects.equals(methodName, "GET")){
            handleGETRequest(exchange);
        }
        else if(Objects.equals(methodName, "POST")){
            handlePOSTRequest(exchange);
        }
    }

    public void handleGETRequest(HttpExchange exchange) throws IOException {
        String response = exchange.getRequestURI().toString();
        Headers headers = exchange.getResponseHeaders();
        headers.add("Content-Type", "text");
        exchange.sendResponseHeaders(200, response.length());
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
        String logMessage = exchange.getRequestMethod() +  exchange.getRequestURI().toString() + " " + "200";
        logger.log(Level.INFO, logMessage);
    }

    public void handlePOSTRequest(HttpExchange exchange) throws IOException {
        String response = exchange.getRequestURI().toString();
        Headers headers = exchange.getResponseHeaders();
        headers.add("Content-Type", "text");
        exchange.sendResponseHeaders(200, response.length());
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
        String logMessage = exchange.getRequestMethod() +  exchange.getRequestURI().toString() + " " + "200";
        logger.log(Level.INFO, logMessage);
    }
}
