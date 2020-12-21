package com.nus.invms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nus.invms.domain.Part;

@RepositoryRestResource
public interface PartRepository extends CrudRepository<Part, Integer> {

}
