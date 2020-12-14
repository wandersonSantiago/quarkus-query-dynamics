package org.acme.service;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.model.Person;
import org.acme.repository.PersonRepository;
import org.acme.utils.QueryBuilder;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class PersonService {

	
	@Inject
	private PersonRepository repository;
	
	public List<Person> findByParams(Map<String, Object> params, Sort sort, Page page){	
		return repository.find(QueryBuilder.builderOperatorAnd(params), sort).page(page).list();		
	}	
	
}
