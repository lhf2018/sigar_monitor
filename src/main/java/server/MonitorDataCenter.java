package server;

import service.Impl.SystemStatusServiceImpl;
import service.SystemStatusService;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebServlet;


@WebServlet(name="MonitorDataCenter",urlPatterns = "/MonitorDataCenter",loadOnStartup=1)
//标记为Servlet不是为了其被访问，而是为了便于伴随Tomcat一起启动
public class MonitorDataCenter {

    private SystemStatusService systemStatusService=new SystemStatusServiceImpl();

    @PostConstruct
    public void init(){
        System.out.println("++++++systemStatusService+++++++  "+systemStatusService);
        new Thread(new MonitorThread(systemStatusService)).start();
    }

}
