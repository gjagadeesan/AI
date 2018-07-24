package com.merrill.hackathon.AIDemo.controller;

import com.merrill.hackathon.AIDemo.entity.ObjectDetails;
import com.merrill.hackathon.AIDemo.service.AIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/AIService")
public class AIController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AIController.class);

    private AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping(value = "/getObjectDetails/{tag}")
    @ResponseStatus(HttpStatus.OK)
    public List<ObjectDetails> getObjectDetails(@PathVariable String tag) {
        LOGGER.info("Inside AIController::getObjectDetails:::");
        List<ObjectDetails> objectDetails = aiService.getObjectDetails(tag);
        LOGGER.info("Inside AIController::objectDetails:::{}", objectDetails);
        return  objectDetails;
    }
}

