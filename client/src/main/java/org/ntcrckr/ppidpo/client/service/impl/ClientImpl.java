package org.ntcrckr.ppidpo.client.service.impl;

import org.ntcrckr.ppidpo.client.service.Client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class ClientImpl implements Client {
    private final Path serverInputFolder;

    public ClientImpl(String serverInputFolder) {
        this.serverInputFolder = Path.of(serverInputFolder);
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            try {
                String fileName = String.valueOf(random.nextInt());
                Path newFile = serverInputFolder.resolve(fileName);
                Files.createFile(newFile);
                Thread.sleep(3000);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
