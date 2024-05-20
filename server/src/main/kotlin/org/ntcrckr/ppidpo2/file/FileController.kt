package org.ntcrckr.ppidpo2.file

import org.ntcrckr.ppidpo2.currencyRate.CurrencyRateProvider
import org.ntcrckr.ppidpo2.utils.FileWriter
import org.ntcrckr.ppidpo2.utils.FolderWatcher
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service


@Service
class FileController(
    private val folderWatcher: FolderWatcher,
    private val fileWriter: FileWriter,
    private val currencyRateProvider: CurrencyRateProvider,
) {
    @EventListener(ApplicationReadyEvent::class)
    fun run() {
        folderWatcher.watchNewFiles {
            when (readText()) {
                "getRate" -> {
                    val rate = currencyRateProvider.getCurrentRate()
                    fileWriter.writeNewFile(name, rate.toString())
                }
            }
            delete()
        }
    }
}