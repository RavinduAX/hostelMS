package lk.ijse.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomDTO {
    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private LocalDate dob;
    private String gender;

    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;

    private String res_id;
    private LocalDate date;
    private String status;

    public CustomDTO(String student_id, String name, String type, String status) {
        this.student_id = student_id;
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public CustomDTO(String student_id, String room_type_id, String status) {
        this.student_id = student_id;
        this.room_type_id = room_type_id;
        this.status = status;
    }
}
