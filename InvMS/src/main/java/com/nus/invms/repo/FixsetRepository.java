package com.nus.invms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nus.invms.domain.Fixset;

@RepositoryRestResource
public interface FixsetRepository extends CrudRepository<Fixset, Integer> {

}
