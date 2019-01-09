package person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import person.models.Person;
import person.models.PersonRepository;

@Slf4j
@Controller
@RequestMapping("/person")
public class PersonController {
	
	private PersonRepository personRepo;
	
	@Autowired
	public PersonController(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	@GetMapping
	public String showForm(Model model) {
		Iterable<Person> people = personRepo.findAll();
		
		model.addAttribute("people", people);
		model.addAttribute("person", new Person());
		
		return "person";
	}
	
	@PostMapping
	public String createPerson(Person form) {
		Person saved = personRepo.save(form);
		return "redirect:/person";
	}

}
