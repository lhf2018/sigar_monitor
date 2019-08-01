package pojo;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;

public class Cpu {
    // CPU数量（单位：个）
    private int cpuLength;
    // CPU的总量（单位：HZ）及CPU的相关信息
    private CpuInfo[] infos;
    //CPU的总量MHz
    private double frequency;
    //CPU的卖主
    private String vendor;
    // 获得CPU的类别，如：Celeron
    private String model;
    // 缓冲存储器数量
    private long cacheSize;
    // 用户使用率
    private double UserUsed;
    // 系统使用率
    private double SysUsed;
    // 当前等待率
    private double wait;
    //当前错误率
    private double Nice;
    // 当前空闲率
    private double Idle;
    // 总的使用率
    private double Combined;

    public double getUserUsed() {
        return UserUsed;
    }

    public void setUserUsed(double userUsed) {
        UserUsed = userUsed;
    }

    public double getSysUsed() {
        return SysUsed;
    }

    public void setSysUsed(double sysUsed) {
        SysUsed = sysUsed;
    }

    public double getWait() {
        return wait;
    }

    public void setWait(double wait) {
        this.wait = wait;
    }

    public double getNice() {
        return Nice;
    }

    public void setNice(double nice) {
        Nice = nice;
    }

    public double getIdle() {
        return Idle;
    }

    public void setIdle(double idle) {
        Idle = idle;
    }

    public double getCombined() {
        return Combined;
    }

    public void setCombined(double combined) {
        Combined = combined;
    }

    public int getCpuLength() {
        return cpuLength;
    }

    public void setCpuLength(int cpuLength) {
        this.cpuLength = cpuLength;
    }

    public CpuInfo[] getInfos() {
        return infos;
    }

    public void setInfos(CpuInfo[] infos) {
        this.infos = infos;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(long cacheSize) {
        this.cacheSize = cacheSize;
    }
}
