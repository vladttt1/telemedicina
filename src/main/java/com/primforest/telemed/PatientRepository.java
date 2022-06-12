package com.primforest.telemed;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.support.QuerydslMongoPredicateExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;


public interface PatientRepository extends MongoRepository<Patient,Integer>{



}

