package com.Saber.demo;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //编写业务逻辑
        Date date =new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("hellow Word! "+simpleDateFormat.format(date));

    }
}
