package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.StudentDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface StudentBO extends SuperBO {
    public List<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException;

    public boolean deleteStudent(String sId) throws SQLException, ClassNotFoundException;

    boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;
}
