package MicroBloggingApp;

/**
 * Created by smita on 3/10/17.
 */

public class UserDetails {
    private String userName;
    private String profilePicture;
    private String firstName;
    private String lastName;
    private String emailAddress;

    public UserDetails(String userName, String profilePicture, String firstName, String lastName, String emailAddress) {
        this.userName = userName;
        this.profilePicture = profilePicture;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
