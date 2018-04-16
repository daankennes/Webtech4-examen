package edu.ap.spring.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import edu.ap.spring.model.InhaalExamen;

@Repository
public class InhaalExamenRepositoryImpl implements InhaalExamenRepository {
	private static final String KEY = "InhaalExamen";

	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, Long, InhaalExamen> hashOperations;

	@Autowired
	public InhaalExamenRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(InhaalExamen inhaalexamen) {
		hashOperations.put(KEY, inhaalexamen.getId(), inhaalexamen);
	}

	@Override
	public InhaalExamen find(Long id) {
		return hashOperations.get(KEY, id);
	}

	@Override
	public Map<Long, InhaalExamen> findAll() {
		return hashOperations.entries(KEY);
	}

	@Override
	public void update(InhaalExamen inhaalexamen) {
		hashOperations.put(KEY, inhaalexamen.getId(), inhaalexamen);
	}

	@Override
	public void delete(Long id) {
		hashOperations.delete(KEY, id);
	}
	
	
}
