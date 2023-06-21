package Utilities;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Utils {

    public String findFilesWithExt(Path path, String fileExtension)
            throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<String> result;

        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> f.endsWith(fileExtension))
                    .collect(Collectors.toList());
        }catch (Exception ex){
            System.out.println(ex.toString());
            result = null;
        }
        System.out.println("file name is" + result.get(0).toString());
        return result.get(0);
    }

    public String getFileNameFromPath(String strpath){
        Path path = Paths.get(strpath);
        Path fileName = path.getFileName();
        return fileName.toString();
    }

}
