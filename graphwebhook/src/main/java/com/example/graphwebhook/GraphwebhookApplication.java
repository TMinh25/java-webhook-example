// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.example.graphwebhook;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphwebhookApplication {


    /**
     * @return A configured SocketIO server instance
     */
    @Bean
    public SocketIOServer socketIOServer() {
        var config = new Configuration();
        config.setHostname("localhost");
        config.setPort(8888);
        return new SocketIOServer(config);
    }


    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(GraphwebhookApplication.class, args);
    }
}
