package MicroBloggingApp;

import java.util.Scanner;

/**
 * Created by smita on 3/13/17.
 */
public class Menu {

    Scanner scanner = new Scanner(System.in);
    static String currentUser;

    public void getMenu(){
        System.out.println("Menu:");
        System.out.println("1. Create a new User");
        System.out.println("2. Become an existing user");
        System.out.println("3. Write a post as current user");
        System.out.println("4. Print all posts");
        System.out.println("5. Print all users");
        System.out.println("9. Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: createUser();
                break;
            case 2: getExistingUser();
                break;
            case 3: CreatePost();
                break;
            case 4: printAllPosts();
                break;
            case 5: printAllUsers();
                break;
            case 9: break;

            default: break;
        }
    }

    public void createUser(){
        System.out.println("Enter the following information:");
        System.out.print("Username: ");
        scanner.skip("\n");
        String userName = scanner.nextLine();
        System.out.print("Web address for picture: ");
        String url = scanner.nextLine();
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Email address: ");
        String email = scanner.nextLine();

        UserDetails userDetails = new UserDetails(userName, url, firstName, lastName, email);
        BlogService blogService = new BlogService();
        blogService.newUser(userDetails);
        currentUser = userName;
        //userDetails.add(new UserDetails(userName, url, firstName, lastName, email));
    }

    public void getExistingUser(){
        System.out.println("Below is the list of existing user:");
        printAllUsers();
        System.out.print("Please select a username:  ");
        scanner.skip("\n");
        currentUser = scanner.nextLine();
        System.out.println("You selected username: " + currentUser);
    }

    public void CreatePost(){
        BlogService blogService = new BlogService();

        blogService.getLastPostMadeByUser(currentUser);

        System.out.print("Enter the content for post: ");
        scanner.skip("\n");
        String postContent = scanner.nextLine();
        System.out.print("Enter refrence link for the post: ");
        String referenceLink = scanner.nextLine();

        UserDetails userDetails = blogService.getUserbyUsername(currentUser);
        Post post = new Post(userDetails, postContent, referenceLink);
        blogService.addPost(post);
    }

    public void printAllUsers(){
        BlogService blogService = new BlogService();
        blogService.displayAllUsers();

    }

    public void printAllPosts(){
        BlogService blogService = new BlogService();
        blogService.displayAllPosts();
    }
}
