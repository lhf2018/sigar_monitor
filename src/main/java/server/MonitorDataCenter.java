package server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.SystemStatusService;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name="MonitorDataCenter",urlPatterns = "/MonitorDataCenter",loadOnStartup=1)
//标记为Servlet不是为了其被访问，而是为了便于伴随Tomcat一起启动
public class MonitorDataCenter {

    @PostConstruct
    public void init() {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        SystemStatusService systemStatusService = (SystemStatusService) context.getBean("systemStatusService");
        new Thread(new MonitorThread(systemStatusService)).start();
    }

}
