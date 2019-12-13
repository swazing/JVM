package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: chenlj
 * @CreateTime: 2019-12-13 10:05
 * @Description: 演示堆内存溢出,使用JPofiler查看内容溢出的原因
 */
public class Demo {

    /*
     * -Xms1m 设置初始化内存分配大小   默认1/164
     * -Xmx8m 设置最大分配的堆内容     默认 1/4
     * -X:+PrintGCDetails            打印GC垃圾回收信息
     * -XX:+HeapDumpOnOutOfMemoryError   生成文件  oom dump
     */
    public byte[] arry = new byte[1 * 1024 * 1024];

    public static void main(String[] args) {
        List<Demo> list = new ArrayList<Demo>();
        int count = 0;
        try {
            while (true) {
                list.add(new Demo());
                count++;
            }
        } catch (Error e) {
            System.out.println(count);
            e.printStackTrace();
        }
    }

}
