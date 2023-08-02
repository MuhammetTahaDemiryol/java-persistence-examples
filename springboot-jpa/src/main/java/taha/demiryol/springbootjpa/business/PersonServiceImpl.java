package taha.demiryol.springbootjpa.business;

import org.springframework.stereotype.Service;
import taha.demiryol.springbootjpa.entity.Person;
import taha.demiryol.springbootjpa.repository.PersonJpaRepository;


import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonJpaRepository personJpaRepository;

    public PersonServiceImpl(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @Override
    public List<Person> findAll() {
        return personJpaRepository.findAll();
    }

    @Override
    public Person add(Person person) {
        return personJpaRepository.insert(person);
    }

    @Override
    public Person update(Person person) {
        return personJpaRepository.update(person);
    }

    @Override
    public Person findById(int id) {
        return personJpaRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        personJpaRepository.deleteById(id);
    }
}
