package ie.atu.jpaweek7;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public Person create(Person p) {

        return repo.save(p);
    }

    public List<Person> findAll() {

        return repo.findAll();
    }

    public Person findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
    }

   public Person update(Person p) {
        Person maybe = findById(p.getId());
        if (maybe != null) {
            maybe.setName(p.getName());
            maybe.setDepartment(p.getDepartment());
            maybe.setPosition(p.getPosition());
            maybe.setEmail(p.getEmail());
            return repo.save(maybe);
        }
        return repo.save(p);
    }

    public void deleteById(Long id) {
        if(repo.findById(id).isPresent()) {

            Person forDeletion = findById(id);

          repo.delete(forDeletion);
        }
        else  throw new IllegalArgumentException("Person not found");


    }
}

