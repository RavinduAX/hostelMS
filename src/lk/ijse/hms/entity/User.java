package lk.ijse.hms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    private String uId;
    private String user_name;
    private String password;

    public User(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }
}
