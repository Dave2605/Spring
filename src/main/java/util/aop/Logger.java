//package util.aop;
//
//import org.aspectj.lang.annotation.Before;
//
////@Aspect
//public class Logger {
//
//
//   // private org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Logger.class);
//
//        @Before("execution(* rest.SubjectController(..)) && @annotation(Loggable)")
//        public void around() {
//
//            System.out.println("jkjkjkj");
//
//
//
////            long start = System.currentTimeMillis();
////            Object result = point.proceed();
////            Logger.info(
////                    "#%s(%s): %s in %[msec]s",
////                    MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
////                    point.getArgs(),
////                    result,
////                    System.currentTimeMillis() - start
////            );
////            return result;
//    }
//}
//
//
