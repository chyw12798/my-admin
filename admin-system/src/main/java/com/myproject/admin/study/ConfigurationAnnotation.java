package com.myproject.admin.study;

/**
 * 对@Configuration的doc文档的解读
 */
public class ConfigurationAnnotation {
    /**
     Indicates that a class declares one or more @Bean methods and may be processed by the Spring container
     to generate bean definitions and service requests for those beans at runtime, for example:
     指示一个类声明了一个或多个@Bean方法，并且由spring容器处理，为这些@Bean在运行时生成bean定义和服务请求，例如
         @Configuration
         public class AppConfig {

             @Bean
             public MyBean myBean() {
             // instantiate, configure and return bean ...
             }
         }

     Bootstrapping @Configuration classes
     启动 @Configuration类

     Via AnnotationConfigApplicationContext
     通过AnnotationConfigApplicationContext

     @Configuration classes are typically bootstrapped using either AnnotationConfigApplicationContext or
     its web-capable variant, AnnotationConfigWebApplicationContext. A simple example with the former follows:
     @Configuration的类通常使用AnnotationConfigApplicationContext或者其支持的web-capple变体的AnnotationConfigWebApplicationContext，
     示例如下：

         AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
         ctx.register(AppConfig.class);
         ctx.refresh();
         MyBean myBean = ctx.getBean(MyBean.class);
         // use myBean ...

     Via component scanning
     通过组件扫描
     @Configuration is meta-annotated with @Component,
     therefore @Configuration classes are candidates for component scanning
     (typically using Spring XML's <context:component-scan/> element) and therefore may also take advantage of
     @Autowired/@Inject like any regular @Component. In particular, if a single constructor is present autowiring
     semantics will be applied transparently for that constructor:
     @Configuation是@Component的元注解，因此@Configuration是组件扫描的候选人，也可以充分利用@Atuwired/@Inject，和常规@Component注解一样。
     特别的，如果存在单个构造方法，则自动为该构造方法自动应用语义。

     @Configuration
     public class AppConfig {

         private final SomeBean someBean;

         public AppConfig(SomeBean someBean) {
         this.someBean = someBean;
         }

         // @Bean definition using "SomeBean"

     }
     @Configuration classes may not only be bootstrapped using component scanning,
     but may also themselves configure component scanning using the @ComponentScan annotation:
     @Configuratin类不仅可以使用组建扫描启动，还可以使用@Component配置组件扫描：

     @Configuration
     @ComponentScan("com.acme.app.services")
     public class AppConfig {
        // various @Bean definitions ...
     }
     See the @ComponentScan javadocs for details.

     Working with externalized values
     使用外在值
     Using the Environment API
     使用Enviroment API
     Externalized values may be looked up by injecting the Spring org.springframework.core.env.Environment
     into a @Configuration class — for example, using the @Autowired annotation:
     外在值可以通过将Spring org.springframework.core.env.Environment注入到@Configuation类中使用(例如使用@Autowired注解进行注入)：
     @Configuration
     public class AppConfig {

         @Autowired Environment env;

         @Bean
         public MyBean myBean() {
             MyBean myBean = new MyBean();
             myBean.setName(env.getProperty("bean.name"));
             return myBean;
         }
     }

     Properties resolved through the Environment reside in one or more "property source" objects,
     and @Configuration classes may contribute property sources to the Environment object using the @PropertySource annotation:
     通过Enviroment解析的Properties(属性),位于一个或多个"property source"对象里，并且@Configuration类可以
     使用@PropertySource注解将property sources(属性资源)构造到Enviroment对象里
     自己的话：Environment有很多属性，位于资源文件里，通过@PropertySource注解将资源文件注入进来，然后Environment对象就可以直接拿到资源文件里
     的属性了

     @Configuration
     @PropertySource("classpath:/com/acme/app.properties")
     public class AppConfig {

     @Inject Environment env;

     @Bean
     public MyBean myBean() {
     return new MyBean(env.getProperty("bean.name"));
     }
     }
     See the Environment and @PropertySource javadocs for further details.

     Using the @Value annotation
     使用@Value注解
     Externalized values may be injected into @Configuration classes using the @Value annotation:
     可以使用@Value注解将外在值注入到@Configuration类中：
     @Configuration
     @PropertySource("classpath:/com/acme/app.properties")
     public class AppConfig {

         @Value("${bean.name}") String beanName;

         @Bean
         public MyBean myBean() {
            return new MyBean(beanName);
         }
     }
     This approach is often used in conjunction with Spring's PropertySourcesPlaceholderConfigurer that can be enabled
     automatically in XML configuration via <context:property-placeholder/> or explicitly in a @Configuration class via
     a dedicated static @Bean method (see "a note on BeanFactoryPostProcessor-returning @Bean methods" of @Bean's javadocs
     for details). Note, however, that explicit registration of a PropertySourcesPlaceholderConfigurer via a static @Bean
     method is typically only required if you need to customize configuration such as the placeholder syntax, etc.
     Specifically, if no bean post-processor (such as a PropertySourcesPlaceholderConfigurer) has registered an embedded
     value resolver for the ApplicationContext, Spring will register a default embedded value resolver which resolves
     placeholders against property sources registered in the Environment. See the section below on composing @Configuration
     classes with Spring XML using @ImportResource; see the @Value javadocs; and see the @Bean javadocs for details on
     working with BeanFactoryPostProcessor types such as PropertySourcesPlaceholderConfigurer.
     这种方法通常与Spring的PropertySourcesPlaceholderConfigurer结合使用，可以通过<context：property-placeholder />在XML配置中自动启用它，
     或者通过专用的静态@Bean方法在@Configuration类中显式启用该方法(参见@Bean的javadocs的“关于BeanFactoryPostProcessor-returning @Bean方法的说明)。
     注意，然而，通过一个静态@Bean方法可以进行PropertySourcesPlaceholderConfigurer的显式注册，这个方式通常只在你需要去自动配置的时候(
     例如占位符语法等)才需要。特别的，如果没有bean post-processor()已经为ApplicationContext注册了一个嵌入的值解析器，Spring会注册一个
     默认内嵌值解析器，用来解决占位符和注册在Enviroment的资源文件之间的冲突。参考....

     */



}
