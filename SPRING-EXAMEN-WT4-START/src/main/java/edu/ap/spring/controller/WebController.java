package edu.ap.spring.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ap.spring.model.InhaalExamen;
import edu.ap.spring.repository.InhaalExamenRepository;

@RestController
public class WebController {
	@Autowired
	private InhaalExamenRepository inhaalExamenRepository;

	@RequestMapping("/testdata")
	public String saveTestData() {
		inhaalExamenRepository.save(new InhaalExamen("Daan Kennes", "Webtech4", "blabla"));
		inhaalExamenRepository.save(new InhaalExamen("Dirk Wuyts", "Webtech3", "examen gemist"));
		inhaalExamenRepository.save(new InhaalExamen("Mohamed Peeters", "Java advanced", "lessen gemist"));

		return "Testdata opgeslagen";
	}
	
	// ex http://localhost:8080/new?student=test&exam=textexamen&reason=telaat
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String saveInhaalexamen(@RequestParam("student") String student, @RequestParam("exam") String examen, @RequestParam("reason") String reden) {
		
		boolean alreadyinredis = false;
		
		Map<Long, InhaalExamen> inhaalexamens = inhaalExamenRepository.findAll();

		for (InhaalExamen inhaalexamen : inhaalexamens.values()) {
			if (inhaalexamen.getStudent().equals(student) && inhaalexamen.getReason().equals(reden) && inhaalexamen.getExam().equals(examen)) alreadyinredis = true;
		}
		
		if (!alreadyinredis) {
			inhaalExamenRepository.save(new InhaalExamen(student, examen, reden));
			return "Student opgeslagen";
		}
		else return "Student al in redis";
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
	
	@RequestMapping("/list")
	public String findByName(@RequestParam("student") String student) {
		String result = "";
		Map<Long, InhaalExamen> inhaalexamens = inhaalExamenRepository.findAll();
		
		ArrayList<InhaalExamen> alfabetisch = new ArrayList<InhaalExamen>();

		for (InhaalExamen inhaalexamen : inhaalexamens.values()) {
			if (inhaalexamen.getStudent().equals(student)) alfabetisch.add(inhaalexamen);
		}
		
		Collections.sort(alfabetisch, (o1, o2) -> o1.getReason().compareTo(o2.getReason()));
		
		for (InhaalExamen inhaalexamen : alfabetisch) {
			result += inhaalexamen.toString() + "<br>";
		}

		return result;
	}

}
