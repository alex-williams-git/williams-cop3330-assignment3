package ex43;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test

    public void testDirectoryCreation() throws IOException
    {
        String[] filePath = {"awesomeco", "Max Power", "y", "y"};
        int result = App.makeDirectory(filePath);

        String websiteFolderPath = "src/main/java/ex43/website/awesomeco";
        String cssFolderPath = "src/main/java/ex43/website/awesomeco/css";
        String jsFolderPath = "src/main/java/ex43/website/awesomeco/js";
        String htmlPath = "src/main/java/ex43/website/awesomeco/index.html";

        checkFileExists(websiteFolderPath);
        checkFileExists(cssFolderPath);
        checkFileExists(jsFolderPath);
        checkFileExists(htmlPath);
    }

    public void checkFileExists(String path)
    {
        File tempFile = new File(path);
        Boolean bool = tempFile.exists();

        assertEquals(true, bool);
    }
}