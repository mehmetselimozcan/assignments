package assignments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;


@Entity
@Table(name = "users", uniqueConstraints={@UniqueConstraint(columnNames={"username"})})
public class User {


    @Column(name = "username", length=50, nullable=false)
    @Id
    private String username;

    @Column(name="password", length=50, nullable=false)
    private String password;

    @Column(name = "email", length=50, nullable=false)
    private String email;

    @Column(name="birthday", nullable=true)
    private Date birthday;

    @Column(name = "sex", nullable=true)
    private int sex;

    @Column(name="enabled", nullable=true)
    private boolean enabled;

    public User() { }

    public User(String username) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", enabled=" + enabled +
                '}';
    }
}