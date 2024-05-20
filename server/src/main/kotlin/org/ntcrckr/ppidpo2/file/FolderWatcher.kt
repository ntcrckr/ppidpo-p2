package org.ntcrckr.ppidpo2.file

import java.io.File

interface FolderWatcher {
    fun watchNewFiles(onNewFile: File.() -> Unit)
}