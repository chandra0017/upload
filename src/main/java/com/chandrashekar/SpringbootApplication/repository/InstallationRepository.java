package com.chandrashekar.SpringbootApplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.chandrashekar.SpringbootApplication.model.InstallationDetails;

public interface InstallationRepository extends CrudRepository<InstallationDetails, Long>{
}
