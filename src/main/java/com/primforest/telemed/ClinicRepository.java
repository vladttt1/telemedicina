package com.primforest.telemed;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClinicRepository extends MongoRepository <Doctor,Integer> {




}

