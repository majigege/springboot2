package com.ucai;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.ucai.pojo.Person;
import com.ucai.pojo.Person2;

/**
 * 好像springboot 发布到tomcat容器必须要有一个入口才行，否则启动会失败 注意：如果用主方法来运行HelloController 的注解要加上 @RestController
 * 
 * @EnableAutoConfiguration 如果写成 @Controller会进行下载 如果放入TOMCATA中运行可以用 @Controller
 *                          可有不加@EnableAutoConfiguration 用主方法来运行，好像只能运行一个类
 * @author my
 * 
 */
@SpringBootApplication
// 如果使用自定义的配置文件给BEAN设置属性值 这个必须得加，
// 如果有多个@ConfigurationProperties加载多个就行了，如果只加载一个会报错的
@EnableConfigurationProperties({ Person2.class, Person.class })
public class Application extends SpringBootServletInitializer {

	@Autowired
	private Environment env;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	public Application() {
		// TODO Auto-generated constructor stub
	}

//	/**
//	 * spring boot 默认使用的是tomcat jdbc 但是也需要配置依赖  也可以换成其他的数据源更改依赖就行了
//	 * 获取数据库连接
//	 * //destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用
//	 * @return
//	 */
//	@Bean(destroyMethod="close")
//	public DataSource getDataSource() {
//		DataSource ds = new DataSource();
//		ds.setDriverClassName(env
//				.getProperty("spring.datasource.driver-class-name"));
//		ds.setUrl(env.getProperty("spring.datasource.url"));
//		ds.setUsername("spring.datasource.username");
//		ds.setPassword(env.getProperty("spring.datasource.password"));
//		// 最大连接池数量
//		ds.setMaxActive(20);
//		// 初始化时建立物理连接的个数
//		ds.setInitialSize(5);
//		// 最大等待时间
//		ds.setMaxWait(60000);
//
//		ds.setValidationQuery("SELECT 1");// 用来检测连接是否有效的sql
//		ds.setTestOnBorrow(false);// 申请连接时执行validationQuery检测连接是否有效
//		ds.setTestWhileIdle(true);// 建议配置为true，不影响性能，并且保证安全性。
//		
//		System.out.println("----------" + ds);
//
//		return ds;
//	}
	
	/**
	 * //	
	 * spring boot 默认使用的是tomcat jdbc 但是也需要配置依赖  也可以换成其他的数据源更改依赖就行了
	 * 获取数据库连接
	 * //destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用
	 * //DataSource配置,表示直接读取application.properties里spring.datasource开头的信息
	 * @return
	 */
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
    	DataSource ds = new DataSource();
    	// 最大连接池数量
		ds.setMaxActive(20);
		// 初始化时建立物理连接的个数
		ds.setInitialSize(5);
		// 最大等待时间
		ds.setMaxWait(60000);

		ds.setValidationQuery("SELECT 1");// 用来检测连接是否有效的sql
		ds.setTestOnBorrow(false);// 申请连接时执行validationQuery检测连接是否有效
		ds.setTestWhileIdle(true);// 建议配置为true，不影响性能，并且保证安全性。
		
        return ds;
    }
 
    //提供SqlSeesion
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
 
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
 
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
// 
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
 
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
