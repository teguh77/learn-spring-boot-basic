package io.tamcorp.basic.service;

import io.tamcorp.basic.dao.PersonDao;
import io.tamcorp.basic.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    public int updatePersonById(UUID id, Person person) {
        return personDao.updatePersonById(id, person);
    }

    public int deletePersonById(UUID id) {
        return personDao.deletePersonById(id);
    }
}
