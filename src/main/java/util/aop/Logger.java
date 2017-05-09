package util.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    private org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Logger.class);
    private long start, end;

//    @Before("execution(* *(..)) && @annotation(util.annotations.Loggable)")
//    public void before(JoinPoint joinPoint) {
//        start = System.nanoTime();
//        log.info(joinPoint.getSignature() + " AOP log: Started...");
//    }
//
//    @After("execution(* *(..)) && @annotation(util.annotations.Loggable)")
//    public void after(JoinPoint joinPoint) {
//        end = System.nanoTime();
//        log.info(joinPoint.getSignature() + " AOP log: Finished. Execution time = " + (end-start));
//    }
}


