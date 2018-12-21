import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class User {
    String firstName;
    String lastName;
    String email;
    String password;
    
    static Hashtable<String, String> users = new Hashtable();
    
    public User(String email, String password) {
        if (users.containsKey(email)) {
            //do nothing
        } else {
            users.put(email, password);
        }
    }
    
    public static int getUser(String email, String password) {
        if (users.containsKey(email) == true) {
            System.out.println(users.get(email)+" "+password);    
            return 1;
        }
        return 0;
    }
    
    public static void printUsers() {
        Set<String> keys = users.keySet();
        for (String key:keys) {
            System.out.print(key+">>"+users.get(key));
        }
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        User newUser = new User("komal@gmail.com","1234");
        if (newUser != null) {
            System.out.println("User created");
        } else {
            System.out.println("User already exitt, choose differernt email");
        }
        
        if (User.getUser("komal@gmail.com", "1234") == 1) {
            System.out.println("User found");
        } else {
            System.out.println("User not found");
        }
        //User.printUsers();
    }
    
    
}