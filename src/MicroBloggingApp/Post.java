package MicroBloggingApp;

/**
 * Created by smita on 3/10/17.
 */
public class Post {
    private UserDetails username;
    private String postContent;
    private String referenceLink;

    public Post(UserDetails username, String postContent, String referenceLink) {
        this.username = username;
        this.postContent = postContent;
        this.referenceLink = referenceLink;
    }

    public UserDetails getUsername() {
        return username;
    }

    public void setUsername(UserDetails username) {
        this.username = username;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getReferenceLink() {
        return referenceLink;
    }

    public void setReferenceLink(String referenceLink) {
        this.referenceLink = referenceLink;
    }
}

