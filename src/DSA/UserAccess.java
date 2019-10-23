package DSA;

import java.util.Hashtable;

public class UserAccess {
	static Hashtable<String, User> users = new Hashtable();
	public static void main(String args[]) {
		UserAccess obj = new UserAccess();
		User user1 = obj.createUser();
		addUser(user1);
		User getUser1 = getUser("komal@gmail.com", "1234");
		getUser1.printUser();
	}
	
	public User createUser() {
		User user = this.new User();
		user.firstName = "Komal";
		user.lastName = "Vohra";
		user.email = "komal@gmail.com";
		user.password = "1234";
		return user;
	}
	
	static void addUser(User user1) {
		if (users.containsKey(user1.email)) {
			System.out.println("User already exists");
		} else {
			users.put(user1.email, user1);
			System.out.println("User added");
		}
	}
	
	static User getUser(String email, String password) {
		if (users.containsKey(email) && users.get(email).password == password) {
			System.out.println("User found");
			return users.get(email);
		} else {
			System.out.println("Password mismatch of user not found");
			return null;
		}
	}
	
	public class User {
		String firstName,lastName, email, password;
		
		public void printUser() {
			System.out.println(this.email+">>"+this.firstName);
		}
	}
}


