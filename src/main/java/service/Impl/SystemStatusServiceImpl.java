package service.Impl;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.junit.Test;
import pojo.Cpu;
import pojo.Memory;
import pojo.Swap;
import service.SystemStatusService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemStatusServiceImpl implements SystemStatusService {
    private Sigar sigar=new Sigar();
    @Override
    public String getTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());
    }
    public Cpu getCpu() throws SigarException {

        Cpu cpu=new Cpu();
        CpuPerc cpuPerc=sigar.getCpuPerc();
        try {
            cpu.setCpuLength(sigar.getCpuInfoList().length);
            cpu.setInfos(sigar.getCpuInfoList());
            cpu.setFrequency(cpu.getInfos()[0].getMhz());
            cpu.setVendor(cpu.getInfos()[0].getVendor());
            cpu.setModel(cpu.getInfos()[0].getModel());
            cpu.setCacheSize(cpu.getInfos()[0].getCacheSize());
            cpu.setCombined(cpuPerc.getCombined());
            cpu.setIdle(cpuPerc.getIdle());
            cpu.setNice(cpuPerc.getNice());
            cpu.setSysUsed(cpuPerc.getSys());
            cpu.setWait(cpuPerc.getWait());
            cpu.setUserUsed(cpuPerc.getUser());
        } catch (SigarException e) {
            System.out.println("获取cpu信息失败");
        }
        return cpu;
    }

    @Override
    public Memory getMemory() {
        Memory memory=new Memory();
        try {
            Mem mem=sigar.getMem();
            memory.setMemTotal(mem.getTotal());
            memory.setMemFree(mem.getFree());
            memory.setMemUsed(mem.getUsed());
            memory.getPercent();
        } catch (SigarException e) {
            e.printStackTrace();
        }
        return memory;
    }

    @Override
    public Swap getSwap() {
        return null;
    }

}
