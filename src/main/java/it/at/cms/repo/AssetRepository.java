package it.at.cms.repo;

public interface AssetRepository extends CrudRepository<Asset, String> {
	
	Iterable<Asset> findAllByBlueprint(Blueprint blueprint);
	
	void createToBlueprint(Blueprint blueprint, Asset asset);
	
}
