package taha.demiryol.springjdbc.business;

import taha.demiryol.springjdbc.entity.Person;

import java.util.List;

public interface PersonService {
    public List<Person> findAll();
    public int add(Person person);
    public int update(Person person);
    public Person findById(int id);
    public int deleteById(int id);

}
