package com.Saber.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HellowScheduler {
    public static void main(String[] args) throws SchedulerException {
        //创建一个jobDetail实例，将该实例与HellowJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(DemoJob.class).withIdentity("myjob","group1").build();
        Date date =new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间  "+simpleDateFormat.format(date));

        date.setTime(date.getTime()+3000);
        Date endDate =new Date();
        endDate.setTime(endDate.getTime()+6000);


        //创建一个Trigger实例
        CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger().withIdentity("Trigger","group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("*******"))
                .build();

        //创建Scheduler实例
        SchedulerFactory schedulerFactory =new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        //编写业务逻辑

        scheduler.scheduleJob(jobDetail,trigger);
    }
}
