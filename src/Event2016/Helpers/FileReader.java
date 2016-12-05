package Event2016.Helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This is a simple helper class that can read a given file (name + full path) and return it as
 * a List of Strings.
 */
public class FileReader
{
    public static List<String> readFile(String fileNameWithPath)
    {
        List<String> readLines = new ArrayList<>();

        try(Stream<String> stream = Files.lines(Paths.get(fileNameWithPath))) {
            readLines = stream
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return readLines;
    }
}
