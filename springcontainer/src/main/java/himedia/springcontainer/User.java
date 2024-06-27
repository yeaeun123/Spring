package himedia.springcontainer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	// 필드
	private Long no;
	private String name;
	
	// 참조필드
	private Friend friend;
	
	// 집합 객체 필드
	private List<String> friends;
	private Set<String> hobbies;
	private Map<String, String> address;
	
	


	// 생성자
	public User() {
	}
	
	public User(String name) {
		this.name = name;
	}

	public User(Long no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	
	
	

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	
	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public Set<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<String> hobbies) {
		this.hobbies = hobbies;
	}

	public Map<String, String> getAddress() {
		return address;
	}

	public void setAddress(Map<String, String> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friend=" + friend + ", friends=" + friends + ", hobbies="
				+ hobbies + ", address=" + address + "]";
	}

	

	
	

}
