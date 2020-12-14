package org.acme.repository;

import javax.enterprise.context.ApplicationScoped;

import org.acme.model.Person;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class PersonRepository implements PanacheRepositoryBase<Person, Long>{


}
