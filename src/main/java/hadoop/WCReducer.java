package hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by BONC on 2018/10/24.
 */
public class WCReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
    /**
     * reduce
     */
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0 ;
        for(IntWritable iw : values){
            count = count + iw.get() ;
        }
        String tno = Thread.currentThread().getName();
        System.out.println(tno + " : WCReducer :" + key.toString() + "=" + count);
        context.write(key,new IntWritable(count));
    }
}
