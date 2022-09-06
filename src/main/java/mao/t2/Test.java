package mao.t2;

import java.util.Date;

/**
 * Project name(项目名称)：java并发编程_Java内存模型_可见性
 * Package(包名): mao.t2
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 12:55
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    private static volatile boolean run = true;

    public static void main(String[] args) throws InterruptedException
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (run)
                {
                    //运行
                }
                System.out.println("运行结束");
            }
        }, "t1").start();

        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    System.out.println("------>" + new Date());
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }, "t2");
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(1500);
        System.out.println("开始停止");
        run = false;
    }
}
