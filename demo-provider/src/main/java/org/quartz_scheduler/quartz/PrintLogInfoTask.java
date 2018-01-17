package org.quartz_scheduler.quartz;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("printLogInfoTask")
public class PrintLogInfoTask {

	private static Logger log = Logger.getLogger(PrintLogInfoTask.class);

	public void exec() {
		log.debug("【对账系统】开始执行[取农商前置流水数据]任务!");
		
		log.debug("【对账系统】结束执行[取农商前置流水数据]任务!");
	}
}