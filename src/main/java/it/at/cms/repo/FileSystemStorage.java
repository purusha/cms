package it.at.cms.repo;

import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileSystemStorage implements BlueprintRepository {

	@Override
	public <S extends Blueprint> S save(S entity) {
		entity.setId(UUID.randomUUID().toString());
		
		log.info("{}", ReflectionToStringBuilder.toString(entity));
		
		return entity;
	}

	@Override
	public <S extends Blueprint> Iterable<S> saveAll(Iterable<S> entities) {
		return entities;
	}

	@Override
	public Optional<Blueprint> findById(String id) {
		return null;
	}

	@Override
	public boolean existsById(String id) {
		return false;
	}

	@Override
	public Iterable<Blueprint> findAll() {
		return null;
	}

	@Override
	public Iterable<Blueprint> findAllById(Iterable<String> ids) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(String id) {
	}

	@Override
	public void delete(Blueprint entity) {
	}

	@Override
	public void deleteAll(Iterable<? extends Blueprint> entities) {
	}

	@Override
	public void deleteAll() {
	}

}
