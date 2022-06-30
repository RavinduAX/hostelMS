package lk.ijse.hms.view.tdm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTM {
    private String uId;
    private String user_name;
    private String password;

    public UserTM(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }
}
