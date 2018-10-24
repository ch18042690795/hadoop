import hadoop.tools;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;
import sun.nio.ch.IOUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by BONC on 2018/10/12.
 */
public class hadoopTest {
    @Test
    public void readFile(){
        try {
            FileSystem fs = FileSystem.get(tools.configuration);
            FSDataInputStream fis=fs.open(new Path("/aaa/a.txt"));
            byte[] buf =new byte[1024];
            int len =-1;
            ByteArrayOutputStream baos =new ByteArrayOutputStream();
            while((len=fis.read(buf))!= -1){
                baos.write(buf,0,len);
            }
            fis.close();
            baos.close();
            System.out.print(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void readIOFile(){
        try {
            FileSystem fs = FileSystem.get(tools.configuration);
            FSDataInputStream fis=fs.open(new Path("/aaa/a.txt"));
            byte[] buf =new byte[1024];
            int len =-1;
            ByteArrayOutputStream baos =new ByteArrayOutputStream();
           /* while((len=fis.read(buf))!= -1){
                baos.write(buf,0,len);
            }*/
            IOUtils.copyBytes(fis,baos,1024);
            fis.close();
            baos.close();
            System.out.print(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void putFile(){
        try {
            FileSystem fs = FileSystem.get(tools.configuration);
            FSDataOutputStream fos=fs.create(new Path("/aaa/a.txt"),true,1024,(short)1,1048576);
            fos.write("hello world".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void down(){
        try {
            FileSystem fs=FileSystem.get(tools.configuration);
            FSDataInputStream fis=fs.open(new Path("/aaa/a.txt"));
            File out=new File("F:/aaa.txt");
            FileOutputStream fous= new FileOutputStream(out);
            IOUtils.copyBytes(fis,fous,1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void remove(){
        FileSystem fs= null;
        try {
            fs = FileSystem.get(tools.configuration);

            fs.delete(new Path("/aaa/a.txt"),true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
