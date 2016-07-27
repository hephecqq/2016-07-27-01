package com.net;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("testJob")
public class TestJob {

	//每隔5秒执行一次
	@Scheduled(cron="0/5 * * * * ?")
	public void tset1(){
		System.err.println("job1 开始执行了...");
	}
	@Scheduled(cron="0/5 * * * * ?")
	public void test2(){
		System.out.println("job2 开始执行了...");
	}
	
}
