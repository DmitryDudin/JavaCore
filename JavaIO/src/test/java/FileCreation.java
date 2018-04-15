import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;

public class FileCreation {

    private static final Logger LOG = LoggerFactory.getLogger(FileCreation.class);


    @Test
    public void createFile() throws IOException {

        String fileName = "createdFile.txt";
        String destinationFolder = "destinationFolder";
        String separator = File.separator;

        String userDir = System.getProperty("user.dir");
        LOG.info("UserDir= {}", userDir);

//        String pathname = userDir + separator + destinationFolder + separator + fileName;
//        File file = new File(pathname);

        String workingDir = userDir + separator + destinationFolder;
        File file = new File(workingDir, fileName);

        file.getParentFile().mkdirs();//create folders
        try {
            boolean created = file.createNewFile();
            if (!created) {
                LOG.info("file already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
