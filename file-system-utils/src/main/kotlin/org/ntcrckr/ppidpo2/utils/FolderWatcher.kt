package org.ntcrckr.ppidpo2.utils

import java.io.File

interface FolderWatcher {
    fun watchNewFiles(onNewFile: File.() -> Unit)
}