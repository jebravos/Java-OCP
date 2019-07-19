package com.bravo.ocp.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.bravo.ocp.nio2.NIO2.HOME;
import static com.bravo.ocp.nio2.NIO2.RESOURCES;
import static com.bravo.ocp.utils.FilesUtils.copy;

public class UsingFiles {

    public static void main(String[] args) throws IOException {

        Path newPath = Files.createDirectories(Paths.get(HOME, "copied"));
        Path resources = Paths.get(RESOURCES);
        copy(resources, newPath, false);

    }

}
