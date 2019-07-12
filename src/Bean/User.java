package Bean;

public class User {
    private Integer id;
    private String name;
    private String pwd;

    public User(){

    }

    public User(String uName, String pwd) {
        this.name = uName;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getuName() {
        return name;
    }

    public void setuName(String uName) {
        this.name = uName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uName='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
