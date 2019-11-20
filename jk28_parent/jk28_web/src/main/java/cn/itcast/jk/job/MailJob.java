package cn.itcast.jk.job;

import java.util.Date;

/**
 * 定义了一个任务类
 * @author Administrator
 *
 */
public class MailJob {

	public void send() throws Exception{
		System.out.println("任务执行完成了："+new Date());
	}
}
