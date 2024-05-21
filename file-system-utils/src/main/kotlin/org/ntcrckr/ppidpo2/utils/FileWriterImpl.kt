package org.ntcrckr.ppidpo2.utils

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Service
import kotlin.io.path.Path

@Service
@PropertySource("classpath:fileWriter.properties")
class FileWriterImpl(
    @Value("\${file.writer.path}") private val folderPath: String,
) : FileWriter {
    override fun writeNewFile(fileName: String, content: String) {
        println("Creating file $fileName")
        Path(folderPath, fileName).toFile().writeText(content)
//        File("$folderPath/$fileName").writeText(content)
        println("Created file $fileName")
    }
}