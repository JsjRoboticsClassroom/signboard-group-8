package nyc.c4q.ac21.signboard;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class TextFrameReader {
    public List<String> textFrames = new ArrayList<String>();

    public TextFrameReader (String fileName) throws IOException {
        readTextFile(fileName);

    }

    public void readTextFile (String fileName) throws IOException{
        Reader fr = null;
        try {
            fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String lineData = null;
            while( ( lineData = br.readLine() ) != null) {
                if (!lineData.equals("--"))
                    textFrames.add(lineData);
            }
        } finally {
            if (fr != null) fr.close();
        }

    }
}
