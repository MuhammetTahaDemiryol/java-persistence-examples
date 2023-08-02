package taha.demiryol.springbootjpa.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import taha.demiryol.springbootjpa.business.PersonServiceImpl;
import taha.demiryol.springbootjpa.entity.Person;


import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonsController {

    private final PersonServiceImpl personService;

    public PersonsController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAll(){
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable int id){
        return personService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person add(@RequestBody Person person){
        return personService.add(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person){
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        personService.deleteById(id);
    }
}
