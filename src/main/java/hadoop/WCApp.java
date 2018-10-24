package hadoop;


import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by BONC on 2018/10/24.
 */
public class WCApp {
    public static void main(String[] args) throws Exception{
/*        Configuration conf =new Configuration();
        conf.set("fs.defaultFS", "file:///");*/
        Job job=Job.getInstance(tools.configuration);
        //设置job的各种属性
        job.setJobName("WCApp");                        //作业名称
        job.setJarByClass(WCApp.class);                 //搜索类
        job.setInputFormatClass(TextInputFormat.class); //设置输入格式

        //设置输出格式类
        //job.setOutputFormatClass(SequenceFileOutputFormat.class);

        //添加输入路径
        FileInputFormat.addInputPath(job,new Path(args[0]));
        //设置输出路径
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        //设置最大切片数
        //FileInputFormat.setMaxInputSplitSize(job,13);
        //最小切片数
        //FileInputFormat.setMinInputSplitSize(job,1L);

        job.setMapperClass(WCMapper.class);             //mapper类
        job.setReducerClass(WCReducer.class);           //reducer类

        job.setNumReduceTasks(1);                       //reduce个数

        job.setMapOutputKeyClass(Text.class);           //
        job.setMapOutputValueClass(IntWritable.class);  //

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);     //

        job.waitForCompletion(true);     //Job运行是通过job.waitForCompletion(true)，true表示将运行进度等信息及时输出给用户，false的话只是等待作业结束

    }
}
