package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.StudentBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.StudentDAO;
import lk.ijse.hms.dto.StudentDTO;
import lk.ijse.hms.entity.Student;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public List<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException {
        List<Student> studentList = studentDAO.getAll();
        List<StudentDTO> dtoList = new ArrayList<>();

        for (Student s : studentList) {
            dtoList.add(new StudentDTO(s.getStudent_id(),s.getName(),s.getAddress(),s.getContact_no(),s.getDob(),s.getGender()));
        }
        return dtoList;
    }

    @Override
    public boolean deleteStudent(String sId) throws SQLException, ClassNotFoundException {
        return studentDAO.delete(sId);
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentDAO.update(new Student(dto.getStudent_id(),dto.getName(), dto.getAddress(), dto.getContact_no(), dto.getDob(), dto.getGender()));
    }


}
