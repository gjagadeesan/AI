package com.merrill.hackathon.AIDemo.repository;

import com.merrill.hackathon.AIDemo.entity.ObjectDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AIRepository extends MongoRepository<ObjectDetails,String>, AIRepositoryCustom {

    @Query("{ 'imageId' : ?0 }")
    List<ObjectDetails> getObjectDetailsByImageId(String tag);
}
