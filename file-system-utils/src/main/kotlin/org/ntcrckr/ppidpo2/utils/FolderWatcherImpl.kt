package org.ntcrckr.ppidpo2.utils

import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.*
import java.nio.file.StandardWatchEventKinds.ENTRY_CREATE

@Service
class FolderWatcherImpl : FolderWatcher {
    override fun watchNewFiles(onNewFile: File.() -> Unit) {
        val watchService = FileSystems.getDefault().newWatchService()

        val folderPath = Paths.get("./fileExchange/")

        folderPath.register(
            watchService,
            ENTRY_CREATE
        )

        var key: WatchKey
        while ((watchService.take().also { key = it }) != null) {
            for (event: WatchEvent<*> in key.pollEvents()) {
                if (event.kind() != ENTRY_CREATE) continue

                val eventPath = event.context()
                val file = File(folderPath.toString(), eventPath.toString())
                onNewFile(file)
            }
            key.reset()
        }
    }
}