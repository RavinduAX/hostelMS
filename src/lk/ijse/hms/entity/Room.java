package lk.ijse.hms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
    @Id
    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Reservation> reserveList;

}