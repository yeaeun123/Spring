package himedia.springcontainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// ClassPath의 XML을 기반으로 컨텍스트 만들기
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("config/applicationContext.xml");
	
		// 타입(Class)으로 찾기
//		User user = ac.getBean(User.class);
//		System.out.println(user);
		
		// id와 name으로 찾기
		User user1 = (User)ac.getBean("user");	// id로 찾기
		User user2 = (User)ac.getBean("member"); //name으로 찾기	
		System.out.println(user1 == user2); //true
		// 스프링 컨테이너는 기본적으로 Sigleton Factory	
		System.out.println(ac.isSingleton("user")); //true
		
		User user3 = (User)ac.getBean("user3");
		System.out.println(user1 == user3);	//false
		
		// 생성자 매개변수 전달
		User user4 = (User)ac.getBean("user4");
		System.out.println("user4:" + user4);	//user4:User [no=1, name=짱구]
		
		// Setter를 이용한 필드 설정
		User user5 = (User)ac.getBean("user5");
		System.out.println("user5:" + user5); //user5:User [no=2, name=맹구]
		
		// 참조 주입
		Friend friend6 = (Friend)ac.getBean("friend6");	//주입될 객체
		System.out.println("friend6:" + friend6); 
		//friend6:Friend [name=철수]
		
		User user6 = (User)ac.getBean("user6");
		System.out.println("user6:" + user6);
		//user6:User [no=6, name=영희, friend=Friend [name=철수]]
		
		
		// 집합 객체 주입
		User user7 = (User)ac.getBean("user7");
		System.out.println("user7" + user7);
		// [no=7, name=짱구, friend=Friend [name=철수], friends=[철수, 유리, 맹구], hobbies=[축구, 게임, 독서], address={country=일본, city=도쿄, village=떡잎마을}]

		
		
		
	}
}
