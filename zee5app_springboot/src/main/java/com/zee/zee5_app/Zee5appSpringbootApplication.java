package com.zee.zee5_app;

import java.math.BigDecimal;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5_app.Exception.InvalidEmailException;
import com.zee.zee5_app.Exception.InvalidIdLengthException;
import com.zee.zee5_app.Exception.InvalidNameException;
import com.zee.zee5_app.Exception.InvalidPasswordException;
import com.zee.zee5_app.dto.Episode;
import com.zee.zee5_app.dto.Login;
import com.zee.zee5_app.dto.Movie;
import com.zee.zee5_app.dto.ROLE;
import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.dto.Series;
import com.zee.zee5_app.dto.Subscription;
import com.zee.zee5_app.service.EpisodeService;
import com.zee.zee5_app.service.LoginService;
import com.zee.zee5_app.service.MovieService;
import com.zee.zee5_app.service.SeriesService;
import com.zee.zee5_app.service.SubscriptionService;
import com.zee.zee5_app.service.UserService;

@SpringBootApplication
public class Zee5appSpringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appSpringbootApplication.class, args);

		UserService userService = applicationContext.getBean(UserService.class);
		LoginService loginService = applicationContext.getBean(LoginService.class);
		SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
		MovieService movieService = applicationContext.getBean(MovieService.class);
		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
				
		//register
		Register register = new Register("0000001", "sangeeta", "boruah", "sangeetaboruah@gmail.com","sang1234", null);
		register.setContactNumber(new BigDecimal("9983720119"));
		Register register1 = new Register("0000002", "swagata", "boruah", "swagataboruah@gmail.com","swag1234", null);
		register.setContactNumber(new BigDecimal("6383720119"));
		Register register2 = new Register("0000003", "archana", "boruah", "archana@gmail.com","archana1234", null);
		register.setContactNumber(new BigDecimal("1234720119"));
		try {
			System.out.println(userService.addUser(register));
			System.out.println(userService.addUser(register1));
			System.out.println(userService.addUser(register2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			System.out.println(loginService.changeRole("sangeeta", ROLE.ROLE_ADMIN));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//subscription
		Subscription subscription = new Subscription("sub001", "annual" , "1499" , "active", "debitcard", "yes", "2019-01-04", "2025-01-01", "0000001");
		Subscription subscription1 = new Subscription("sub002", "annual" , "499" , "inactive", "upi", "no", "2017-01-04", "2023-01-01", "0000002");
		Subscription subscription2 = new Subscription("sub003", "monthly" , "499" , "active", "creditcard", "yes", "2020-01-04", "2027-01-01", "0000003");
		
		try {
			System.out.println(subscriptionService.addSubs(subscription));
			System.out.println(subscriptionService.addSubs(subscription1));
			System.out.println(subscriptionService.addSubs(subscription2));
		} catch (SQLException | InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	
		
		//movie
		Movie movie = new Movie("mov001", "inception", 15, "AB,BC","thriller","200","abcdef","2020-01-01","english","0000002");
		Movie movie1 = new Movie("mov002", "tennet", 18, "AB,BC,D","drama","160","abtrgf","2021-08-01","english","0000002");
		Movie movie2 = new Movie("mov003", "harry potter", 18, "BC","horror","240","awqwddef","2019-05-01","english","0000002");
		
		try {
			System.out.println(movieService.add(movie));
			System.out.println(movieService.add(movie1));
			System.out.println(movieService.add(movie2));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		//series
		Series series = new Series("ser001","efijki","you",18,"AB,CD","drama","2019-07-09","english",10,"0000002");
		Series series1 = new Series("ser002","gtjki","you2",18,"DF,CD","drama","2018-07-09","english",15,"0000001");
		Series series2 = new Series("ser003","ytri","squid game",15,"JI,CD","thriller","2020-09-09","english",10,"0000003");
		
		try {
			System.out.println(seriesService.add(series));
			System.out.println(seriesService.add(series1));
			System.out.println(seriesService.add(series2));
		} catch (SQLException | InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		//episode
		Episode epi = new Episode("ep001","30","ser001","episode 1","drsg","efyrergo");
		Episode epi1 = new Episode("ep002","40","ser001","episode 2","drgtrsg","efyro");
		Episode epi2 = new Episode("ep001","35","ser002","episode 1","drsgergt","et6fyro");
		
		try {
			System.out.println(episodeService.addEpi(epi));
			System.out.println(episodeService.addEpi(epi1));
			System.out.println(episodeService.addEpi(epi2));
		} catch (SQLException | InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		applicationContext.close();
		
	}

}
