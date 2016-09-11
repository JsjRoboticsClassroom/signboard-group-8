package nyc.c4q.ac21.signboard;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Reads a text file and stores each line that is not marked with "--" into a list.
 *
 * Example of 2 frames in text separated by "--".
 * ()_()
 * (^_^)
 * --
 * ()_()
 * (-_-)
 * --
 */
public class FrameTextReader {

    public List<String> frameList = new ArrayList<String>();

    public FrameTextReader(String fileName) throws IOException {
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
                    frameList.add(lineData);
            }
        } finally {
            if (fr != null) fr.close();
        }

    }
}