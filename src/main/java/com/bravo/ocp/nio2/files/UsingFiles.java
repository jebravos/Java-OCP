package com.bravo.ocp.nio2.files;

import static com.bravo.ocp.nio2.UsingPath.HOME;
import static com.bravo.ocp.nio2.UsingPath.RESOURCES;
import static com.bravo.ocp.utils.FilesUtils.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingFiles {

    public static void main(String[] args) throws IOException {

        Path newPath = Files.createDirectories(Paths.get(HOME, "copied"));
        Path resources = Paths.get(RESOURCES);
        copy(resources, newPath, false);

    }

}
