package it.at.cms.repo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileSystemStorage implements BlueprintRepository {
	
	private static final String TMP_CMS = "/tmp/cms";
	private final ObjectMapper mapper;
	
	@Autowired
	public FileSystemStorage() {
		this.mapper = new ObjectMapper();
	}

	@SneakyThrows
	@Override
	public <S extends Blueprint> S save(S entity) {
		
		//XXX do this id is null ... otherwise use what is contained !!!
		entity.setId(UUID.randomUUID().toString());
		
		log.info("{}", ReflectionToStringBuilder.toString(entity));
		
		final File b = new File(TMP_CMS + File.separator + "B-" + entity.getId());		
		mapper.writeValue(b, entity);
		
		final File bData = new File(TMP_CMS + File.separator + entity.getId());
		bData.mkdir();
		
		return entity;
	}

	@Override
	public <S extends Blueprint> Iterable<S> saveAll(Iterable<S> entities) {
		return entities;
	}

	@SneakyThrows
	@Override
	public Optional<Blueprint> findById(String id) {
		final File b = new File(TMP_CMS + File.separator + "B-" + id);
		
		return Optional.ofNullable(mapper.readValue(b, Blueprint.class));
	}

	@Override
	public boolean existsById(String id) {
		return false;
	}

	@SneakyThrows
	@Override
	public Iterable<Blueprint> findAll() {
		final Path source = Paths.get(TMP_CMS);
        
        try(Stream<Path> stream = Files.list(source)) {
            return stream
                .filter(Files::isDirectory)
                .map(folder -> folder.toFile().getName())
                .map(this::findById)
                .filter(Objects::nonNull)
                .flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty))
                .collect(Collectors.toList());
        }
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

	@SneakyThrows
	@Override
	public void delete(Blueprint entity) {
		final File b = new File(TMP_CMS + File.separator + "B-" + entity.getId());
		b.delete();
		
		final File bData = new File(TMP_CMS + File.separator + entity.getId());
		FileUtils.deleteDirectory(bData);
	}

	@Override
	public void deleteAll(Iterable<? extends Blueprint> entities) {
	}

	@Override
	public void deleteAll() {
	}

}
