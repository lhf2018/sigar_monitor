package pojo;

public class Memory {
    // 内存总量
    private long MemTotal=1;
    // 当前内存使用量
    private long MemUsed;
    // 当前内存剩余量
    private long MemFree;
    // 当前内存使用率
    private double MemUsed_p;
    // 当前内存剩余率
    private double MemFree_p;

    public double getMemUsed_p() {
        return MemUsed_p;
    }

    public void setMemUsed_p(double memUsed_p) {
        MemUsed_p = memUsed_p;
    }

    public double getMemFree_p() {
        return MemFree_p;
    }

    public void setMemFree_p(double memFree_p) {
        MemFree_p = memFree_p;
    }

    public long getMemTotal() {
        return MemTotal;
    }

    public void setMemTotal(long memTotal) {
        MemTotal = memTotal;
    }

    public long getMemUsed() {
        return MemUsed;
    }

    public void setMemUsed(long memUsed) {
        MemUsed = memUsed;
    }

    public long getMemFree() {
        return MemFree;
    }

    public void setMemFree(long memFree) {
        MemFree = memFree;
    }

    public void getPercent(){
        MemUsed_p=(double)(MemUsed)/(double)MemTotal*100;
        MemFree_p=(double)(MemFree)/(double)MemTotal*100;
    }
}
