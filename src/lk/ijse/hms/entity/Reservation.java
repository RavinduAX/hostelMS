package lk.ijse.hms.entity;

import lk.ijse.hms.dto.ReservationDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    private String res_id;
    private LocalDate date;
    @ManyToOne
    @JoinColumn
    private Student student;
    @ManyToOne
    @JoinColumn
    private Room room;

    private String status;

}
