package person.models;

import org.springframework.data.repository.CrudRepository;

import person.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
