package io.data.ltbook;

import io.data.ltbook.domain.*;
import io.data.ltbook.service.DatabaseService;
import io.data.ltbook.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class LtbookApplication {
	public static void main(String[] args) {
		SpringApplication.run(LtbookApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(DatabaseService databaseService){
		return args -> {
//			databaseService.initBill(new Bill(null, 6L,"Phạm Thành Trung","0344153437","Hóc Môn","B001",500000.0,"payment"));
//			databaseService.initProductCart(new ProductCart(null,"B001",10L,"Conan - thám tử lừng danh","avtBook",10,5,50000.0,500000.0));
//			databaseService.initProductCart(new ProductCart(null,"B001",10L,"Conan - thám tử lừng danh","avtBook",2,5,50000.0,100000.0));
//
//			databaseService.initBook(new Book(null,"Conan - thám tử lừng danh",25.000,5,100,"Tập 100","avtArtist","Oda","21/11/1989","KinhDi","avaiable","Trung","21/11/2021","Trung","21/11/2021"));
//			databaseService.initBlog(new Blog(null,"newBlog","đây là blog mới","#new","new","Trung","21/11/2021 10:28:00","Trung","21/11/2021"));
//			userService.saveRole(new Role(null,"ROLE_USER"));
//			userService.saveRole(new Role(null,"ROLE_MANAGER"));
//			userService.saveRole(new Role(null,"ROLE_ADMIN"));
//			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
//
//			userService.saveUser(new User(null,"Thái Duy Linh","linhmk@gmail.com","123456"));
//			userService.saveUser(new User(null,"Bùi Minh Chiến","chienml@gmail.com","123456",));
//			userService.saveUser(new User(null,"Trần Trung Hiếu","hieutt@gmail.com","123456"));
//			userService.saveUser(new User(null,"Nguyễn Xuân Sang","sangxn@gmail.com","123456"));
//
//
//
//			userService.addRoleToUser("linhmk@gmail.com","ROLE_SUPER_ADMIN");
//			userService.addRoleToUser("trungpt@gmail.com","ROLE_SUPER_ADMIN");
//			userService.addRoleToUser("hieutt@gmail.com","ROLE_USER");
//			userService.addRoleToUser("sangxn@gmail.com","ROLE_USER");
		};
	}
}
