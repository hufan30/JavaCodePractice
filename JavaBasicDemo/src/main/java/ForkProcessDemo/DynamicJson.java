package ForkProcessDemo;

import org.apache.tomcat.jni.File;

import java.io.*;

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
        //此时测试fileinputStream
        InputStream inputStream1 = new FileInputStream("./pom.xml");
        //此时拿到InputStream,是命令行执行的返回stream，下一步是bufferreader
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream1));
        BufferedReader reader = new BufferedReader(new FileReader("pom.xml"));

        StringBuffer sb = new StringBuffer();
        String line = null;
        //下面应该是常用模式，reader的基本模版
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        System.out.println(sb.toString());

        /**
         * 下面演示filereader，确实相比于buffered要低效率很多
         */
        FileReader reader1 = new FileReader("pom.xml");
        char[] a = new char[50];
        reader1.read(a);
        for(char c:a){
            System.out.print(c);
        }
        reader1.close();
    }
}
