package it.at.cms.repo;

import static it.at.cms.repo.FileSystemBlueprintStorage.TMP_CMS;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileSystemAssetStorage implements AssetRepository {

	private final ObjectMapper mapper;
	
	@Autowired
	public FileSystemAssetStorage() {
		this.mapper = new ObjectMapper();
	}
	
	@Override
	public <S extends Asset> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Asset> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Asset> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Asset> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Asset> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Asset entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Asset> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<Asset> findAllByBlueprint(Blueprint b) {
		final File assets = new File(TMP_CMS + File.separator + b.getId() + File.separator + "assets.json");
		final List<Asset> result = new ArrayList<>();
		
		if (assets.exists()) {
			//XXX complete please !!?
		}
		
		return result;
	}

	@Override
	@SneakyThrows
	public void createToBlueprint(Blueprint b, Asset asset) {
		log.info("{}", ReflectionToStringBuilder.toString(b));
		final File assets = new File(TMP_CMS + File.separator + b.getId() + File.separator + "assets.json");
		
		if (! assets.exists()) {
			Files.createFile(assets.toPath());
		}
		
		mapper.writeValue(assets, asset);		
	}

}
