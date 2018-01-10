/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: ServerConnect.java
 * Author:   zhangdanji
 * Date:     2017年10月08日
 * Description:   
 */
package com.mychebao.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;

/**
 * @author zhangdanji
 */
public class ServerConnect {
    private static final int BUF_SIZE = 1024;
    private static final int PORT = 8080;
    private static final int TIMEOUT = 3000;

    public static void startServer(){
        Selector selector = null;
        ServerSocketChannel serverSocketChannel = null;
        try {
            selector = SelectorProvider.provider().openSelector();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT,SocketChannel.open());
            while(true){
                if(selector.select(TIMEOUT) == 0){
                    System.out.println("服务器等待中...");
                    continue;
                }
                Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
                while (selectionKeyIterator.hasNext()){
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    if(selectionKey.isAcceptable()){
                        handleAccept(selectionKey);
                    }
                    if(selectionKey.isReadable()){
                        handleRead(selectionKey);
                    }
                    if(selectionKey.isWritable() && selectionKey.isValid()){
                        handleWrite(selectionKey);
                    }
                    if(selectionKey.isConnectable()){
                        System.out.println("new connection++");
                    }
                    selectionKeyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(selector != null){
                    selector.close();
                }
                if(serverSocketChannel != null){
                    serverSocketChannel.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void handleAccept(SelectionKey key) throws IOException{
        ServerSocketChannel ssChannel = (ServerSocketChannel)key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);
        System.out.println("accept");
        sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
    }

    private static void handleRead(SelectionKey key) throws IOException{
        SocketChannel sc = (SocketChannel)key.channel();
        ByteBuffer buf = (ByteBuffer)key.attachment();
        long bytesRead = sc.read(buf);
        while(bytesRead>0){
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char)buf.get());
            }
            System.out.println();
            buf.clear();
            bytesRead = sc.read(buf);
        }
        if(bytesRead == -1){
            sc.close();
        }
    }

    private static void handleWrite(SelectionKey key) throws IOException{
        ByteBuffer buf = (ByteBuffer)key.attachment();
        buf.flip();
        SocketChannel sc = (SocketChannel) key.channel();
        while(buf.hasRemaining()){
            sc.write(buf);
        }
        buf.compact();
    }

    public static void main(String[] args) {
        startServer();
    }
}
