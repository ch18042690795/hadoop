package hadoop;



import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

import static org.apache.hadoop.fs.FileSystem.*;

/**
 * Created by BONC on 2018/10/12.
 */
public class demo {

    public static void main(String[] args) {
        FileSystem fileSystem = null;
        try {

            fileSystem = FileSystem.get(tools.configuration);
            fileSystem.mkdirs(new Path("/hadoop"));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileSystem.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
