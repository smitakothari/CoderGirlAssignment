package MicroBloggingApp;

import java.util.Scanner;

/**
 * Created by smita on 3/10/17.
 *
 * Problem statement - Create a Micro Blogging app
 *
 */

public class MicroBloggingMain {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean continueFlag = false;

        do {
            Menu menu = new Menu();
            menu.getMenu();
            System.out.println("Do you wish to continue?");
            String repeat = scanner.nextLine();
            if(repeat.equals("yes")){
                continueFlag = true;
            }
            else{
                continueFlag = false;
            }
        }while (continueFlag);

//        UserDetails userDetails[] = new UserDetails[5];
//        Post posts[] = new Post[10];
//
//        for(int i=0; i<5; i++) {
//            userDetails[i] = new UserDetails("Tom", "https://www.google.com/", "Tom", "Jordan", "tomjordan@gmail.com");
//            posts[i] = new Post(userDetails[i], "This is my first post", "https://www.google.com/");
//            posts[i].getPost();
//        }
    }
}
