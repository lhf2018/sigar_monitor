package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ServerManager {
    private static Collection<MonitorServer> servers = Collections.synchronizedCollection(
            new ArrayList<MonitorServer>());
    public static void broadCast(String message){
        for(MonitorServer server:servers){
            try {
                server.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static int getTotal(){
        return servers.size();
    }
    public static void add(MonitorServer server){
        System.out.println("有新连接加入！ 当前总连接数是："+ servers.size());
        servers.add(server);
    }
    public static void remove(MonitorServer server){
        System.out.println("有连接退出！ 当前总连接数是："+ servers.size());
        servers.remove(server);
    }
}
