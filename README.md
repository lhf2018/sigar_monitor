#  使用sigar和websocket实现主机实时参数的网页展示
### 使用sigar.jar来检测主机的内存、cpu、系统等参数，websocket实现在不更新网页的情况下实时显示服务器发来的数据
### 效果图
<div align=center>
![效果图](https://github.com/lhf2018/system_monitor-ING/blob/master/src/main/resources/images/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20190801201529.png?raw=true)
</div>

### 备注
* #### demo目前能够显示CPU总使用率、当前内存使用率、当前内存空闲率、当前时间，本demo目前只是实现基本功能的展示，后续会更新其他功能
* #### 本例目前提供windows系统的相应dll文件

* #### 运行代码
```System.out.println(System.getProperty("java.class.path"));```
* #### 把resources/sigar-amd64-winnt/X64/1.6.4.104/sigar-amd64-winnt.dll中放到刚才代码显示的一个classpath中
