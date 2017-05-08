package util.springConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"dao, service"})
@ImportResource("classpath:applicationContext.xml")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class RootConfig {}
