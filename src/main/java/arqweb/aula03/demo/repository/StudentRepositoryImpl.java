package arqweb.aula03.demo.repository;

import org.springframework.stereotype.Repository;
import arqweb.aula03.demo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> findAll() {
        System.out.println("passei aqui");
        return jdbcTemplate.query("SELECT * FROM public.students", (resultSet, rowNum) ->
                new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("register"),
                        resultSet.getInt("age"),
                        resultSet.getString("course")
                )
        );
    }

    @Override
    public Student findById(Long id) {
        String query = "SELECT * FROM public.students WHERE id = ?";

        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet,  rowNum) ->
                new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("register"),
                        resultSet.getInt("age"),
                        resultSet.getString("course")

                )
        );
    }


    @Override
    public Student save(Long id, Student student) {
        if (id == null) {
            String insertQuery = "INSERT INTO public.students (name, register, age, course) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(insertQuery, student.getName(), student.getRegister(), student.getAge(), student.getCourse());
        } else {
            if (this.findById(id) != null) {
                String updateQuery = "UPDATE public.students SET name = ?, register = ?, age = ?, course = ? WHERE id = ?";
                jdbcTemplate.update(updateQuery, student.getName(), student.getRegister(), student.getAge(), student.getCourse(), student.getId());
            } else {
                throw new IllegalArgumentException("Não foi possível encontrar nenhum registro");
            }
        }
        return student;
    }

    @Override
    public Student delete(Long id){
        Student student = findById(id);
        String deleteQuery = "DELETE FROM public.students WHERE id = ?";
        jdbcTemplate.update(deleteQuery, new Object[]{id});
        return student;
    }

}