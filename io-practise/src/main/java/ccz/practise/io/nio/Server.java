package ccz.practise.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by 46043 on 2017/6/20.
 */
public class Server {
    public static void main(String[] args) {
        ServerSocketChannel server = null;
        try {
            server = ServerSocketChannel.open();
            Selector selector = Selector.open();
            server.configureBlocking(false);
            server.register(selector, SelectionKey.OP_ACCEPT);
            server.socket().bind(new InetSocketAddress("127.0.0.1", 8080));
            System.out.println("server start");

            while(true) {
                int selectNum = selector.select();
                if(selectNum > 0) {
                    Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
                    while(selectionKeyIterator.hasNext()) {
                        SelectionKey selectionKey = selectionKeyIterator.next();
                        if(selectionKey.isValid()) {
                            if(selectionKey.isAcceptable()) {
                                System.out.println("acceptable");
                                ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
                                SocketChannel socketChannel = serverSocketChannel.accept();
                                socketChannel.configureBlocking(false);
                                socketChannel.register(selector, SelectionKey.OP_READ);
                            } else if(selectionKey.isReadable()) {
                                System.out.println("readable");
                                SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                                socketChannel.read(readBuffer);
                                byte[] bytes = new byte[readBuffer.remaining()];
                                readBuffer.get(bytes);
                                System.out.println(new String(bytes, "UTF-8"));
                            }
                        }
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
