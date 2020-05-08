package it.at.cms.controller;

import it.at.cms.repo.Blueprint;

public class NotValidBlueprint extends RuntimeException {
	private static final long serialVersionUID = -2952753916676327891L;
	
	public NotValidBlueprint(Blueprint b) {
		super("Cannot build blueprint");
	}

}
