package util.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import util.annotations.Loggable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class LoggableAnnotationBeanPostProcessor implements BeanPostProcessor {

    private org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LoggableAnnotationBeanPostProcessor.class);
    private Map<String, Class> map = new HashMap<String, Class>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Loggable.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass =  map.get(beanName);
        if (null != beanClass) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    log.info(" PostProcessor log: Started...");
                    long start = System.nanoTime();
                    Object retVal = method.invoke(bean, args);
                    long end = System.nanoTime();
                    log.info(method.getName() + " PostProcessor log: Finished. Execution time = " + (end - start));
                    return retVal;
                }
            });
        }
        return bean;
    }
}
