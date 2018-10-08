package ru.otus;

import org.slf4j.*;

import java.lang.management.ManagementFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 java -Xmx512m -Xms512m -XX:+UseSerialGC -jar target/work_5.jar > SerialGCReport.txt
 java -Xmx512m -Xms512m -XX:+UseParallelGC -jar target/work_5.jar > ParallelGCReport.txt
 java -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC -jar target/work_5.jar > CMSGCReport.txt
 java -Xmx512m -Xms512m -XX:+UseG1GC -jar target/work_5.jar > G1Report.txt
 */
public class Main {
	
	private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) {
        log.info("Starting pid: {}", ManagementFactory.getRuntimeMXBean().getName());

        ExecutorService es = Executors.newFixedThreadPool(2);
        log.info("Submit memory consumption");
        es.submit(new MemoryConsumeTask());
        log.info("Submit GC statistic");
        es.submit(new GCStatisticTask());

        log.info("Submit dump creation");
        es.submit(new HeapDumpCauseTask(10));

    }
}
