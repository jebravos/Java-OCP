package com.bravo.ocp.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.bravo.ocp.utils.PrintUtils.err;
import static com.bravo.ocp.utils.PrintUtils.println;
import static java.util.Objects.requireNonNull;

public class FilesUtils {

    public static void copy(Path source, Path target) {
        copy(source, target, false);
    }

    public static void copy(Path source, Path target, boolean recursively) {
        if (Files.isDirectory(requireNonNull(source))) {
            copyFromDirectory(source, target, recursively);
        } else {
            copyFile(source, target);
        }

    }

    private static void copyFromDirectory(Path source, Path target, boolean recursively) {
        if (recursively) {
            copyFromDirectoryRecursively(source, target);
        } else {
            copyFromDirectoryNonRecursively(source, target);
        }
    }

    private static void copyFromDirectoryRecursively(Path source, Path target) {
        try {
            Files.newDirectoryStream(requireNonNull(source)).forEach(toCopy -> {
                if (Files.isDirectory(toCopy)) {
                    Path newDirectory = requireNonNull(target).resolve((toCopy).getFileName());
                    copyFile(toCopy, newDirectory);
                    copyFromDirectoryRecursively(toCopy, requireNonNull(newDirectory));
                } else {
                    Path newFile = requireNonNull(target).resolve((toCopy).getFileName());
                    copyFile(toCopy, newFile);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(StringUtils.format("Error copying {} to {} ", source.toAbsolutePath(), target.toAbsolutePath()), e);
        }
    }

    private static void copyFromDirectoryNonRecursively(Path source, Path target) {
        try {
            Files.newDirectoryStream(requireNonNull(source)).forEach(fileToCopy -> {
                copyFile(fileToCopy, requireNonNull(target).resolve((fileToCopy).getFileName()));
            });
        } catch (IOException e) {
            throw new RuntimeException(StringUtils.format("Error copying {} to {} ", source.toAbsolutePath(), target.toAbsolutePath()), e);
        }
    }

    private static void copyFile(Path source, Path target) {
        try {
            PrintUtils.println("copying {} to {}", requireNonNull(source), requireNonNull(target));
            Files.copy(requireNonNull(source), requireNonNull(target));
        } catch (IOException e) {
            throw new RuntimeException(StringUtils.format("Error copying {} to {} ", source.toAbsolutePath(), target.toAbsolutePath()), e);
        }
    }

    //

    public static void deleteForce(Path path) {
        if (Files.isDirectory(requireNonNull(path))) {
            emptyDirectory(path);
        }

        delete(path);
    }

    public static void emptyDirectory(Path directory){
        try {
            Files.newDirectoryStream(directory).forEach(FilesUtils::deleteForce);
        } catch (IOException e) {
            throw new RuntimeException(StringUtils.format("Error emptying {} ", directory, e));
        }
    }

//    private static void delete(Path path) {
//        if (Files.isDirectory(path)) {
//            try {
//                deleteForce(path);
//            } catch (IOException e) {
//                throw new RuntimeException(StringUtils.format("Error deleting {} ", path), e);
//            }
//        } else {
//            delete(path);
//        }
//    }

    public static void delete(Path path) {
        try {
            println("Deleting {}", path);
            if(!Files.exists(requireNonNull(path))){
                err("{} does not exist", path);
                return;
            }

            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException(StringUtils.format("Error deleting {} ", path, e));
        }
    }
}
