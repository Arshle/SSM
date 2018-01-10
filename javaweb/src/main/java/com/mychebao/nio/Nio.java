/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: Nio.java
 * Author:   zhangdanji
 * Date:     2017年10月08日
 * Description:   
 */
package com.mychebao.nio;

import junit.framework.TestCase;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;

/**
 * @author zhangdanji
 */
public class Nio extends TestCase{
    public void testNio() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel readChannel = null;
        FileChannel writeChannel = null;
        try {
            fis = new FileInputStream("/Users/zhangdanji/Desktop/nio.txt");
            fos = new FileOutputStream("/Users/zhangdanji/Desktop/copy/nio.txt");
            readChannel = fis.getChannel();
            writeChannel = fos.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while(true){
                byteBuffer.clear();
                int len = readChannel.read(byteBuffer);
                if(len < 0){
                    break;
                }
                byteBuffer.flip();
                writeChannel.write(byteBuffer);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (writeChannel != null) {
                    writeChannel.close();
                }
                if (readChannel != null) {
                    readChannel.close();
                }
                if (fos != null) {
                    fos.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testBuffer(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);
        System.out.println("limit=" + byteBuffer.limit() + ",capacity=" + byteBuffer.capacity() + ",position=" + byteBuffer.position());
        for(int i = 0; i < 10; i ++){
            byteBuffer.put((byte)i);
        }
        System.out.println("limit=" + byteBuffer.limit() + ",capacity=" + byteBuffer.capacity() + ",position=" + byteBuffer.position());
        byteBuffer.flip();
        System.out.println("limit=" + byteBuffer.limit() + ",capacity=" + byteBuffer.capacity() + ",position=" + byteBuffer.position());
        for(int i = 0; i < 5; i++){
            System.out.println(byteBuffer.get());
        }
        System.out.println("limit=" + byteBuffer.limit() + ",capacity=" + byteBuffer.capacity() + ",position=" + byteBuffer.position());
        byteBuffer.flip();
        System.out.println("limit=" + byteBuffer.limit() + ",capacity=" + byteBuffer.capacity() + ",position=" + byteBuffer.position());
    }

    public void testSelector(){
        try {
            Selector selector = SelectorProvider.provider().openSelector();
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            InetSocketAddress isa = new InetSocketAddress(8000);
            ssc.socket().bind(isa);
            SelectionKey acceptKey = ssc.register(selector,SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
