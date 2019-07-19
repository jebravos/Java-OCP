package com.bravo.ocp.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static com.bravo.ocp.utils.FilesUtils.copy;
import static java.nio.file.Paths.get;

public class FilesUtilsTest {

    private Path filesDirectoryPath;
    private Path tmpFilesDirectoryPath;


    @Before
    public void init() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        filesDirectoryPath = get(classLoader.getResource("files/").getFile());
        tmpFilesDirectoryPath = filesDirectoryPath.resolve("tmp/");

        createTmpDirectoryIfNotExists();
        cleanTmpFiles();
    }

    private void createTmpDirectoryIfNotExists() throws IOException {
        if (!Files.exists(tmpFilesDirectoryPath)) {
            Files.createDirectories(tmpFilesDirectoryPath);
        }
    }

    @Test
    public void testCopyExistentFile() throws IOException {
        //given
        Path sourceFile = filesDirectoryPath.resolve("singleFile/singleFile.txt");
        Path targetFile = tmpFilesDirectoryPath.resolve(sourceFile.getFileName());
        //when
        copy(sourceFile, targetFile);
        //then
        Assert.assertTrue(Files.exists(targetFile));

        cleanTmpFiles();
    }

    @Test
    public void testCopyFilesFromDirectory() throws IOException {
        //given
        Path sourceFile = filesDirectoryPath.resolve("singleFile/");
        //when
        copy(sourceFile, tmpFilesDirectoryPath);
        //then
        Set<Path> copiedFiles = new HashSet<>();
        Files.newDirectoryStream(tmpFilesDirectoryPath).forEach(copiedFiles::add);

        Assert.assertEquals(1, copiedFiles.size());

        cleanTmpFiles();
    }

    @Test
    public void testCopyMultipleFilesFromDirectory() throws IOException {
        //given
        Path sourceFile = filesDirectoryPath.resolve("multipleFiles/");
        //when
        copy(sourceFile, tmpFilesDirectoryPath);
        //then
        Assert.assertTrue(Files.exists(tmpFilesDirectoryPath.resolve("File1.txt")));
        Assert.assertTrue(Files.exists(tmpFilesDirectoryPath.resolve("File2.txt")));

        cleanTmpFiles();
    }

    @Test
    public void testCopyFilesFromDirectoryRecursively() throws IOException {
        //Given
        Path sourceFile = filesDirectoryPath.resolve("recursively/");
        boolean recursively = true;
        //When
        copy(sourceFile, tmpFilesDirectoryPath, recursively);

        //Then
        Assert.assertTrue(Files.exists(tmpFilesDirectoryPath.resolve("inDirectory/")));
        Assert.assertTrue(Files.exists(tmpFilesDirectoryPath.resolve("inDirectory/fileInDirectory.txt")));

        cleanTmpFiles();
    }

    private void cleanTmpFiles() throws IOException {
        FilesUtils.emptyDirectory(tmpFilesDirectoryPath);
    }
}
