package taha.demiryol.springbootjpa.business;

import taha.demiryol.springbootjpa.entity.Person;


import java.util.List;

public interface PersonService {
    public List<Person> findAll();
    public Person add(Person person);
    public Person update(Person person);
    public Person findById(int id);
    public void deleteById(int id);

}
