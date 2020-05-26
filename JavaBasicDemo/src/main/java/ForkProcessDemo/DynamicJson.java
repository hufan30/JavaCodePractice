package ForkProcessDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/5/2010:37 下午
 **/
public class DynamicJson {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("git", "log", "--oneline");
        //直接使用IO，在控制台打印出命令
//        pb.inheritIO().start();

        //使用io,buffer,reader的传统方式
        Process process = pb.start();
        InputStream inputStream = process.getInputStream();
        //此时拿到InputStream,是命令行执行的返回stream，下一步是bufferreader
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer sb = new StringBuffer();
        String line = null;
        //下面应该是常用模式，reader的基本模版
        while ((line = reader.readLine()) != null){
            sb.append(line).append("\n");
        }
        System.out.println(sb.toString());


    }
}
