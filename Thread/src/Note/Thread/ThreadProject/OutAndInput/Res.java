package Note.Thread.ThreadProject.OutAndInput;

/**
 * 实体类
 */
public class Res {
    private String userName;
    private String password;
    private int age;
    private String gender;

    //start add 添加flag使得生产者生产完毕后消费者才能消费
    //    flag=true 生产者生产，消费者等待
    //    flag=false 生产者等待，消费者消费
    private boolean flag = true;
    //end add

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
