package com.niit.hiberconfig;

	
	import java.util.Properties;


	import javax.sql.DataSource;

	import org.hibernate.SessionFactory;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.jdbc.datasource.DriverManagerDataSource;
	import org.springframework.orm.hibernate5.HibernateTransactionManager;
	import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
	import org.springframework.transaction.annotation.EnableTransactionManagement;
	import com.niit.model.Billing;
	import com.niit.model.Cart;
	import com.niit.model.Category;
	import com.niit.model.ContactUs;
	import com.niit.model.HomeProducts;
	import com.niit.model.OrderDetails;
	import com.niit.model.Product;
	import com.niit.model.Shipping;
	import com.niit.model.Supplier;
	import com.niit.model.UserDetails;

	@Configuration
	@ComponentScan("com.niit.ApnagharBackend")
	@EnableTransactionManagement
	public class HiberConfig {		
		@Bean(name="dataSource")
		public DataSource getDataSource(){
			DriverManagerDataSource datasource=new DriverManagerDataSource();
			datasource.setDriverClassName("org.h2.Driver");
			datasource.setUrl("jdbc:h2:tcp://localhost/~/Apnaghar");
			datasource.setUsername("sa");
			datasource.setPassword("");
			return datasource;
		}
		
		@Bean(name="sessionfact")
		public SessionFactory getSessionFactory(){
			Properties prop = new Properties();
			prop.put("hibernate.hbm2ddl.auto","update");
			prop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
			prop.put("hibernate.show_sql","true");
			LocalSessionFactoryBuilder sessionFactBuilder = new LocalSessionFactoryBuilder(getDataSource());
			sessionFactBuilder.addProperties(prop);
			sessionFactBuilder.addAnnotatedClass(UserDetails.class);
			sessionFactBuilder.addAnnotatedClass(Category.class);
			sessionFactBuilder.addAnnotatedClass(Product.class);
			sessionFactBuilder.addAnnotatedClass(Supplier.class);
			sessionFactBuilder.addAnnotatedClass(Cart.class);
			sessionFactBuilder.addAnnotatedClass(HomeProducts.class);
			sessionFactBuilder.addAnnotatedClass(OrderDetails.class);
			sessionFactBuilder.addAnnotatedClass(Billing.class);
			sessionFactBuilder.addAnnotatedClass(Shipping.class);
			sessionFactBuilder.addAnnotatedClass(ContactUs.class);
			return sessionFactBuilder.buildSessionFactory();
		}

		@Bean(name="txManager")
		public HibernateTransactionManager getTransactionManager(){
			HibernateTransactionManager txm = new HibernateTransactionManager(getSessionFactory());
			return txm;	
		
		
		

	}

	
	



}


