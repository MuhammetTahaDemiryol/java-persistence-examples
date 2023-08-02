package taha.demiryol.springjdbc.Dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import taha.demiryol.springjdbc.entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJDBCDao {

    JdbcTemplate jdbcTemplate;

    private final static BeanPropertyRowMapper<Person> personRowMapper = new BeanPropertyRowMapper<>(Person.class);

    public PersonJDBCDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person",
                new PersonRowMapper());
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?",personRowMapper,
                id);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?", id);
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date ) "
                        + "VALUES(?,?,?,?)",
                person.getId(), person.getName(),
                person.getLocation(), new Timestamp(person.getBirthDate().getTime()));
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person "
                        + " set name = ?, location = ?, birth_date = ? "
                        + " where id = ?",
                person.getName(),
                person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
                person.getId());
    }

    static class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {

            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;
        }

    }

}
