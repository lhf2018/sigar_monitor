package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.SystemStatusService;

import javax.annotation.PostConstruct;

//@WebServlet(name="MonitorDataCenter",urlPatterns = "/MonitorDataCenter",loadOnStartup=1)
//标记为Servlet不是为了其被访问，而是为了便于伴随Tomcat一起启动
@Component
public class MonitorDataCenter {
    @Autowired
    SystemStatusService systemStatusService;

    @PostConstruct
    public void init() {
        new Thread(new MonitorThread(systemStatusService)).start();
    }

}
