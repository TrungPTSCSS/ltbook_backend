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
//			databaseService.initBook(new Book(null,"The Nun",25000.00,5,100,"The Nun with ....","avtArtist","Minch","21/11/1989","Thriller","avaiable","Trung","26/11/2021","Trung","21/11/2021","https://images.squarespace-cdn.com/content/v1/511eea22e4b06642027a9a99/1546391763171-OE9IKNM9KVD699QDIUAK/The+Nun.jpg"));
//			databaseService.initBook(new Book(null,"Hạt giống tâm hồn",25.000,5,100,"notebook","avtArtist","unknow","21/11/1989","Novel","avaiable","Trung","21/11/2021","Trung","21/11/2021","https://cdn.chanhtuoi.com/viectainha/2021/02/w800/w400/hat-giong-tam-hon.jpg.webp"));
//			databaseService.initBook(new Book(null,"Đi qua hoa cúc",25.000,5,100,"notebook","avtArtist","Nguyễn Nhật Ánh","21/11/1989","Poem","avaiable","Trung","21/11/2021","Trung","21/11/2021","https://sachxua.vn/wp-content/uploads/2020/01/toi-thay-hoa-vang-tren-co-xanh-nta.jpg"));
//			databaseService.initBook(new Book(null,"The Father",25.000,5,100,"notebook","avtArtist","Leonardo Dicaprio","21/11/1989","Thriller","avaiable","Trung","21/11/2021","Trung","21/11/2021","https://vnwriter.net/wp-content/uploads/2016/11/sach-bo-gia-737x1024.gif"));
//			databaseService.initBook(new Book(null,"Nhà giả kim",25.000,5,100,"notebook","avtArtist","Paulo Coelho","21/11/1989","Short","avaiable","Trung","21/11/2021","Trung","21/11/2021","https://cdn.chanhtuoi.com/uploads/2018/05/w400/nhung-cuon-sach-hay-10.jpg.webp"));


//			databaseService.initBlog(new Blog(null,"Conan - thám tử lừng danh sắp kết thúc?","Vừa rồi vào ngày 25/11/2021, tác giả bộ truyện nổi tiếng One Piece vừa cho ra đời ấn phẩm mới có tên là Red Note. Câu chuyện kể về hành trình của nhóm Luffy sau đảo bánh ... ","#new","new","Trung","21/11/2021 10:28:00","Trung","21/11/2021","https://content.fun-japan.jp/renewal-prod/cms/articles/content/01jpg_2019-10-07-08-22-25.jpg"));
//			databaseService.initBlog(new Blog(null,"Doraemon được xuất bản nhiều tập","Vừa rồi vào ngày 25/11/2021, tác giả bộ truyện nổi tiếng One Piece vừa cho ra đời ấn phẩm mới có tên là Red Note. Câu chuyện kể về hành trình của nhóm Luffy sau đảo bánh ... ","#new","new","Trung","21/11/2021 10:28:00","Trung","21/11/2021","https://phunugioi.com/wp-content/uploads/2020/03/hinh-anh-doremon-cute.jpg"));
//			databaseService.initBlog(new Blog(null,"Naruto sẽ gặp lại tộc Otosuki?","Vừa rồi vào ngày 25/11/2021, tác giả bộ truyện nổi tiếng One Piece vừa cho ra đời ấn phẩm mới có tên là Red Note. Câu chuyện kể về hành trình của nhóm Luffy sau đảo bánh ... ","#new","new","Trung","21/11/2021 10:28:00","Trung","21/11/2021","https://hoachinhangia.vn/uploads/posts/2021/10/tien-nhan-coc-1635306310.jpg"));
//			databaseService.initBlog(new Blog(null,"One Piece vừa ra mắt ấn phẩm mới","Vừa rồi vào ngày 25/11/2021, tác giả bộ truyện nổi tiếng One Piece vừa cho ra đời ấn phẩm mới có tên là Red Note. Câu chuyện kể về hành trình của nhóm Luffy sau đảo bánh ... ","#new","new","Trung","21/11/2021 10:28:00","Trung","21/11/2021","https://content.fun-japan.jp/renewal-prod/cms/articles/content/01jpg_2019-10-07-08-22-25.jpg"));
////			userService.saveRole(new Role(null,"ROLE_USER"));
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
