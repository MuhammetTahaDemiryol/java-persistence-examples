package taha.demiryol.springbootspringdatajpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import taha.demiryol.springbootspringdatajpa.entity.Person;

public interface PersonSpringDataJpaRepository extends JpaRepository<Person,Integer> {



}
