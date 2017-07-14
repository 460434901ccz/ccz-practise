package ccz.practise.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by 46043 on 2017/6/20.
 */
public class Client {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);

            while (true) {
                int selectNum = selector.select();
                if(selectNum > 0) {
                    Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
                    while(selectionKeyIterator.hasNext()) {
                        SelectionKey selectionKey = selectionKeyIterator.next();
                        if(selectionKey.isValid()) {
                            if(selectionKey.isConnectable()) {
                                System.out.println("connectable");
                                SocketChannel sc = (SocketChannel)selectionKey.channel();
                                if(sc.finishConnect()) {
                                    System.out.println("finishConnect");
                                }
                                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                writeBuffer.put("hello".getBytes("UTF-8"));
                                sc.write(writeBuffer);
                            }else if(selectionKey.isAcceptable()) {
                                System.out.println("acceptable");
                            }else if(selectionKey.isReadable()) {
                                System.out.println("readable");

                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
