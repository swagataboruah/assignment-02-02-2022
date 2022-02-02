package com.zee.zee5_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.zee.zee5_app.utils.PasswordUtils;


//THE BELOW MENTIONED CAN BE AUTOMATED USING SPRING BOOT - WHY SPRINGBOOT OVER SPRING?
                 
//@Configuration 
//used to mark on config class(s) by informing spring that this class is used as config class
//here we hold all commonly required objects four our application 


//@ComponentScan("com.zee.zee5_app")
//to provide scope of search for singleton
//this has the base package and base package gives access to our main

//@PropertySource("classpath:application.properties") 
//responsible for reading properties file


public class Config {
	//provides configuration: db related like connection/disconnection of db, reading properties file, commonly required beans(like passwordEncoder) 
     
	//@Autowired 
	//whenever we need object we need to inject that already created object -> Dependency Injection (DI) or IoC
	// Autowired will bring the already created objects based on reference name/type
	//here it is brought in the basis of type
	
	Environment environment; //this object is prepared by spring
	//taking environment reference from spring to handle the reading of data
	
	
	//method responsible for bringing in datasource -> datasource is responsible for managing connections
	//this method will give how many objects? -> 1 object -> even if this method is call many times it will give only 1 object which is a problem
	//how to restrict the above given scenario -> using @Bean
	
	//@Bean //for providing singleton object -> so here even if the method is called multiple times it will give 1 singleton object
	//if we will not specify bean name then it will take/consider the method name as bean name
	
//	@Bean(name = "ds") //creates only 1 instance
//	//@Scope("prototype") //bean gives only 1 instance but scope gives multiple
//	                      //prototype scope -> when we call bean n number of times we will get n objects 
//	@Scope("singleton") //if we specify singleton then it will give only 1 instance/object
//	
//	
//	public DataSource dataSource() {
//		
//		BasicDataSource basicDataSource = new BasicDataSource();
//		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
//		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
//		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
//		basicDataSource.setDefaultAutoCommit(false);
//		return basicDataSource;
//		
//	}
	
	@Bean
    ////one method is mark to mark passwordutils as component other way is to mark bean to object of PasswordUtils
    public PasswordUtils passwordUtils() {
	          return new PasswordUtils();
    }
	//when to go for @Bean and @Component?
    //bean -> we can initialize as per requirement or we can customize it as in when required in the method we created
    //if we expect lot of customizations it will be better to use @Bean, otherwise in scenario where we dont need customizations we can go for @Component
    
    
	
	
	
	
	
	
	
	
	
	
	
	
}
