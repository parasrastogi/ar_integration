package com.app.homeViewer.util

import java.io.File

object HomeViewerFileUtil {

    private const val RENDERABLE_FILE_EXTENSION = ".sfb"
    private const val MAC_OS_ZIP_FILE_FOLDER = "__MACOSX"

    fun isRenderableFilesExist(currentModelDirectory: File): Boolean {
        val roofFile = getRoofRenderableFile(currentModelDirectory)
        val structureFile = getStructureRenderableFile(currentModelDirectory)

        return !(roofFile == null || !roofFile.exists() || roofFile.length() == 0L
                || structureFile == null || !structureFile.exists() || structureFile.length() == 0L)
    }


    fun getRoofRenderableFile(currentModelDirectory: File): File? {
        val roofFileName = "roof$RENDERABLE_FILE_EXTENSION"
        val unzippedFolderFiles = File(currentModelDirectory.path).listFiles()?.firstOrNull {
            it.isDirectory && !it.name.startsWith(MAC_OS_ZIP_FILE_FOLDER, true)
        }?.listFiles()

        var roofFile: File? = null

        unzippedFolderFiles?.let {
            for (file in it) {
                if (file.path.endsWith(roofFileName, true)) {
                    roofFile = file
                    break
                }
            }
        }

        return roofFile
    }


    fun getStructureRenderableFile(currentModelDirectory: File): File? {
        val structureFileName = "structure$RENDERABLE_FILE_EXTENSION"
        val unzippedFolderFiles = File(currentModelDirectory.path).listFiles()?.firstOrNull {
            it.isDirectory && !it.name.startsWith(MAC_OS_ZIP_FILE_FOLDER, true)
        }?.listFiles()

        var structureFile: File? = null

        unzippedFolderFiles?.let {
            for (file in it) {
                if (file.path.endsWith(structureFileName, true)) {
                    structureFile = file
                    break
                }
            }
        }

        return structureFile
    }


}