package edu.ap.spring.repository;
import java.util.Map;

import edu.ap.spring.model.InhaalExamen;

public interface InhaalExamenRepository {
	void save(InhaalExamen inhaalexamen);
	InhaalExamen find(Long id);
	// InhaalExamen findByStudent(String student);
	Map<Long, InhaalExamen> findAll();
	void update(InhaalExamen inhaalexamen);
	void delete(Long id);
}
