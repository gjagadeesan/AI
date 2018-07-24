package com.merrill.hackathon.AIDemo.repository;

import com.merrill.hackathon.AIDemo.entity.ObjectDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AIRepositoryImpl implements AIRepositoryCustom{

    private static final Logger LOGGER = LoggerFactory.getLogger(AIRepositoryImpl.class);

    @Autowired
    MongoTemplate mongoTemplate;

    public List<ObjectDetails> findObjectTag(String tag){
        Query query = new Query();
        query.addCriteria(Criteria.where("objecttag").is(tag));
        LOGGER.info("AIService::query:::{}",query);
        List<ObjectDetails> objectDetailsList = mongoTemplate.find(query, ObjectDetails.class);
        LOGGER.info("AIService::Inside findObjectTag:::{}",objectDetailsList);
        return objectDetailsList;
    }

}
