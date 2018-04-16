package edu.ap.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ap.spring.model.InhaalExamen;
import edu.ap.spring.repository.InhaalExamenRepository;

@RestController
public class WebController {
	@Autowired
	private InhaalExamenRepository inhaalExamenRepository;

	@RequestMapping("/save")
	public String save() {
		// 1 inhaalexamen opslaan
		inhaalExamenRepository.save(new InhaalExamen((long) 1, "Daan Kennes", "Webtech4", "blabla"));
		inhaalExamenRepository.save(new InhaalExamen((long) 2, "Dirk Wuyts", "Webtech3", "examen gemist"));
		inhaalExamenRepository.save(new InhaalExamen((long) 1, "Mohamed Peeters", "Java advanced", "lessen gemist"));

		return "Done";
	}

	@RequestMapping("/findall")
	public String findAll() {
		String result = "";
		Map<Long, InhaalExamen> inhaalexamens = inhaalExamenRepository.findAll();

		for (InhaalExamen inhaalexamen : inhaalexamens.values()) {
			result += inhaalexamen.toString() + "<br>";
		}

		return result;
	}

	/*@RequestMapping("/find")
	public String findById(@RequestParam("id") Long id) {
		String result = "";
		result = customerRepository.find(id).toString();
		return result;
	}

	@RequestMapping(value = "/uppercase")
	public String postCustomer(@RequestParam("id") Long id) {
		Customer customer = customerRepository.find(id);
		customer.setFirstName(customer.getFirstName().toUpperCase());
		customer.setLastName(customer.getLastName().toUpperCase());

		customerRepository.update(customer);

		return "Done";
	}

	@RequestMapping("/delete")
	public String deleteById(@RequestParam("id") Long id) {
		customerRepository.delete(id);

		return "Done";
	}*/
}
