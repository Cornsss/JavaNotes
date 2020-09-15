package Note.Thread.ThreadProject.SendMsg;

public class UserEntity {
    private String userId;
    private String userName;

    public UserEntity(String userId, String userName) {
        super();
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserEntity [userId=" + userId + ", userName=" + userName + "]";
    }

}

