package server;

import org.hyperic.sigar.SigarException;
import pojo.Cpu;
import pojo.Memory;
import service.SystemStatusService;



public class MonitorThread implements Runnable {
    
    private SystemStatusService systemStatusService;

    public MonitorThread(SystemStatusService systemStatusService) {
        this.systemStatusService = systemStatusService;
    }

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
