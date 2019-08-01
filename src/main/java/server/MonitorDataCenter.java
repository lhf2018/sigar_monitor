package server;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.junit.Test;
import pojo.Cpu;
import pojo.Memory;
import service.Impl.SystemStatusServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Random;

@WebServlet(name="MonitorDataCenter",urlPatterns = "/MonitorDataCenter",loadOnStartup=1)
//标记为Servlet不是为了其被访问，而是为了便于伴随Tomcat一起启动
public class MonitorDataCenter extends HttpServlet implements Runnable {
    private SystemStatusServiceImpl systemStatusService=new SystemStatusServiceImpl();
    Sigar sigar=new Sigar();
    @Override
    public void init() throws ServletException {
        startup();
    }
    public void startup() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double combined=0;
            double MemUsed_p=0;
            double MemFree_p=0;
            String time="";
            try {
                Cpu cpu=systemStatusService.getCpu();
                Memory memory=systemStatusService.getMemory();
                combined=cpu.getCombined()*100;
                MemUsed_p=memory.getMemUsed_p();
                MemFree_p=memory.getMemFree_p();
                time=systemStatusService.getTime();
            } catch (SigarException e) {
                e.printStackTrace();
            }
            String messageFormat = "{\"combined\":\"%f\",\"MemUsed_p\":\"%f\",\"MemFree_p\":\"%f\"," +
                    "\"time\":\"%s\"}";
            String message = String.format(messageFormat,combined,MemUsed_p
                    ,MemFree_p,time);
            ServerManager.broadCast(message);
        }
    }
}
