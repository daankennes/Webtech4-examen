package edu.ap.spring.repository;
import java.util.Map;

import edu.ap.spring.model.InhaalExamen;

public interface InhaalExamenRepository {
	//void save(Customer customer);
	void save(InhaalExamen inhaalexamen);
	InhaalExamen find(Long id);
	Map<Long, InhaalExamen> findAll();
	void update(InhaalExamen inhaalexamen);
	void delete(Long id);
}
