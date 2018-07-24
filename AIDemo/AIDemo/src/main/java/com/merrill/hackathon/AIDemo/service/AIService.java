package com.merrill.hackathon.AIDemo.service;


import com.merrill.hackathon.AIDemo.entity.ObjectDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AIService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AIService.class);

    @Autowired
    private com.merrill.hackathon.AIDemo.repository.AIRepository aiRepository;

    public List<ObjectDetails> getObjectDetails(String tag) {
        LOGGER.info("AIService::Inside getObjectDetails:::");
        return aiRepository.findObjectTag(tag);
    }
}
