package org.ntcrckr.ppidpo2.file

import org.ntcrckr.ppidpo2.utils.FileWriter
import org.ntcrckr.ppidpo2.utils.FolderWatcher
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class FilePoller(
    private val folderWatcher: FolderWatcher,
    private val fileWriter: FileWriter,
) {
    private val fileNameFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd-HH-mm-ss")

    @Scheduled(fixedRate = 10000)
    fun poll() {
        val fileName = LocalDateTime.now().format(fileNameFormatter)
        fileWriter.writeNewFile(fileName, "getRate")
    }

    @EventListener(ApplicationReadyEvent::class)
    fun watchForAnswers() {
        folderWatcher.watchNewFiles {
            val rate = readText().toFloat()
            println("Received $rate in response to file-based request at $name timestamp")
            delete()
        }
    }
}