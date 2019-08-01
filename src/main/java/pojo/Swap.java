package pojo;

public class Swap {
    // 交换区总量
    private long SwapTotal;
    // 当前交换区使用量
    private long SwapUsed;
    // 当前交换区剩余量
    private long SwapFree;

    public long getSwapTotal() {
        return SwapTotal;
    }

    public void setSwapTotal(long swapTotal) {
        SwapTotal = swapTotal;
    }

    public long getSwapUsed() {
        return SwapUsed;
    }

    public void setSwapUsed(long swapUsed) {
        SwapUsed = swapUsed;
    }

    public long getSwapFree() {
        return SwapFree;
    }

    public void setSwapFree(long swapFree) {
        SwapFree = swapFree;
    }
}
