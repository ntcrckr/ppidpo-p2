package org.ntcrckr.ppidpo2.file.impl

import org.ntcrckr.ppidpo2.file.FileWriter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Service
import java.io.File

@Service
@PropertySource("classpath:fileWriter.properties")
class FileWriterImpl(
    @Value("\${file.writer.path}") private val folderPath: String,
) : FileWriter {
    override fun writeNewFile(fileName: String, content: String) {
        println("Creating file $fileName")
        File("$folderPath/$fileName").writeText(content)
        println("Created file $fileName")
    }
}