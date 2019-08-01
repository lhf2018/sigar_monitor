package service;


import org.hyperic.sigar.SigarException;
import pojo.Cpu;
import pojo.Memory;
import pojo.Swap;

public interface SystemStatusService {
    String getTime();
    Cpu getCpu() throws SigarException;
    Memory getMemory();
    Swap getSwap();

}
