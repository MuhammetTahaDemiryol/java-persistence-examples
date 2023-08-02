package taha.demiryol.springjdbc.business;

import org.springframework.stereotype.Service;
import taha.demiryol.springjdbc.Dao.PersonJDBCDao;
import taha.demiryol.springjdbc.entity.Person;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonJDBCDao personJDBCDao;

    public PersonServiceImpl(PersonJDBCDao personJDBCDao) {
        this.personJDBCDao = personJDBCDao;
    }

    @Override
    public List<Person> findAll() {
        return personJDBCDao.findAll();
    }

    @Override
    public int add(Person person) {
        return personJDBCDao.insert(person);
    }

    @Override
    public int update(Person person) {
        return personJDBCDao.update(person);
    }

    @Override
    public Person findById(int id) {
        return personJDBCDao.findById(id);
    }

    @Override
    public int deleteById(int id) {
        return personJDBCDao.deleteById(id);
    }
}
