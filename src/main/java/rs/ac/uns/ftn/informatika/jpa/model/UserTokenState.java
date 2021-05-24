package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.List;

public class UserTokenState {
    private String accessToken;
    private Long expiresIn;
    private List<String> role;
    private String username;
    private Long id;


    public UserTokenState() {
        this.accessToken = null;
        this.expiresIn = null;
        this.role=null;
        this.username=null;
        this.id=null;

    }
    public UserTokenState(String accessToken, long expiresIn,List<String> role,String username,Long id) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.role=role;
        this.username=username;
        this.id=id;
    }
    public UserTokenState(String accessToken, long expiresIn,List<String> role,String username) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.role=role;
        this.username=username;
    }
    public UserTokenState(String accessToken, long expiresIn,List<String> role) {
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

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    
}