package hadoop;


import org.apache.hadoop.conf.Configuration;

/**
 * Created by BONC on 2018/10/12.
 */
public class tools {
   public static  final Configuration configuration = new Configuration();
   static{
       configuration.set("fs.defaultFS" , "hdfs://172.16.22.171:9000");
       System.setProperty("HADOOP_USER_NAME","Ha2");
   }

}
