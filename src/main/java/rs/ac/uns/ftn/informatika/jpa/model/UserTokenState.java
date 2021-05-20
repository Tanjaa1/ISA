package rs.ac.uns.ftn.informatika.jpa.model;

public class UserTokenState {
    private String accessToken;
    private Long expiresIn;
    private String role;
    private String username;


    public UserTokenState() {
        this.accessToken = null;
        this.expiresIn = null;
        this.role=null;
        this.username=null;

    }
    public UserTokenState(String accessToken, long expiresIn,String role,String username) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.role=role;
        this.username=username;
    }
    public UserTokenState(String accessToken, long expiresIn,String role) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.role=role;
    }
    public UserTokenState(String accessToken, long expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    
}