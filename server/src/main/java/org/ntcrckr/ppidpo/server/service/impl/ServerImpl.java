package org.ntcrckr.ppidpo.server.service.impl;

import org.ntcrckr.ppidpo.server.service.Server;

import java.io.IOException;
import java.nio.file.*;
import java.util.function.Consumer;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

public class ServerImpl implements Server {
    private final Path inputFolder;

    public ServerImpl(String inputFolderLocation) {
        this.inputFolder = Paths.get(inputFolderLocation);
    }

    @Override
    public void run() {
        infiniteOnCreate(this::processInput);
    }

    private void processInput(Path path) {
        System.out.println(path.getFileName());
    }

    private void infiniteOnCreate(Consumer<Path> onCreate) {
        FileSystem fs = inputFolder.getFileSystem();
        try (WatchService service = fs.newWatchService()) {
            inputFolder.register(service, ENTRY_CREATE);
            WatchKey key;
            do {
                key = service.take();
                for (WatchEvent<?> watchEvent : key.pollEvents()) {
                    if (watchEvent.kind() == ENTRY_CREATE) {
                        Path newPath = ((WatchEvent<Path>) watchEvent).context();
                        onCreate.accept(newPath);
                    }
                }

            } while (key.reset());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
