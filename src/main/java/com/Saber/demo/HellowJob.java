package com.Saber.demo;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HellowJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //编写业务逻辑
        Date date =new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("hellow Word! "+simpleDateFormat.format(date));

        JobKey key= jobExecutionContext.getJobDetail().getKey();
        System.out.println("JobDetail  " +key.getName()+key.getGroup());

        TriggerKey triggerKey  = jobExecutionContext.getTrigger().getKey();
        System.out.println("trigger "+triggerKey.getName()+" " +triggerKey.getGroup());

        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap jobDataMap =jobExecutionContext.getTrigger().getJobDataMap();
        System.out.println("DemoJob "+dataMap.getString("message") +" "+dataMap.getFloat("f"));
        System.out.println("trigger" +jobDataMap.getString("message")+" " +jobDataMap.getFloat("f"));

    }
}
