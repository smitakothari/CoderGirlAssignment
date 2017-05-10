package MicroBloggingApp;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by smita on 3/29/17.
 */
public class BlogService {

    static ArrayList<UserDetails> usersList = new ArrayList<UserDetails>();
    static ArrayList<Post> posts = new ArrayList<Post>();

    public void newUser(UserDetails userDetails){
        usersList.add(userDetails);
    }

    public void addPost(Post post){ posts.add(post); }

    public void displayAllPosts(){
        Iterator iterator = posts.iterator();
        for(int i = 0 ; i< posts.size() ;i++){
            System.out.println("User Name : " + posts.get(i).getUsername().getUserName());
            System.out.println("Post Order : " + i);
            System.out.println("Post Content : " + posts.get(i).getPostContent());

            System.out.println("-------------------------------");
        }
    }

    public void displayAllUsers(){
        for (int i=0; i<usersList.size(); i++){
            System.out.println(usersList.get(i).getUserName());
        }
    }

    public UserDetails getUserbyUsername(String userName){
        int counter = -1 ;
        for (int i = 0; i < usersList.size(); i++) {
            if(userName.matches(usersList.get(i).getUserName())){
                counter = i;
                break;
            }
        }
        if (counter >= 0)
            return usersList.get(counter);
        else
            return null;
    }

    public void getLastPostMadeByUser(String userName){

        for(int i=0; i<posts.size(); i++){
            if(userName.matches(posts.get(i).getUsername().getUserName())){
                System.out.println("username: " + userName);
                System.out.println("Post content : " + posts.get(i).getPostContent());
            }
        }

    }
}
