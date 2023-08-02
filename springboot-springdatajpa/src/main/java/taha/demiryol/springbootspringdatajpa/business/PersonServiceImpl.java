package taha.demiryol.springbootspringdatajpa.business;

import org.springframework.stereotype.Service;
import taha.demiryol.springbootspringdatajpa.entity.Person;
import taha.demiryol.springbootspringdatajpa.repository.PersonSpringDataJpaRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonSpringDataJpaRepository springDataJpaRepository;

    public PersonServiceImpl(PersonSpringDataJpaRepository springDataJpaRepository) {
        this.springDataJpaRepository = springDataJpaRepository;
    }

    @Override
    public List<Person> findAll() {
        return springDataJpaRepository.findAll();
    }

    @Override
    public Person add(Person person) {
        return springDataJpaRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        return springDataJpaRepository.save(person);
    }

    @Override
    public Person findById(int id) {
        return springDataJpaRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(int id) {
        springDataJpaRepository.deleteById(id);
    }
}
