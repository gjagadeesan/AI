package com.merrill.hackathon.AIDemo.repository;



import com.merrill.hackathon.AIDemo.entity.ObjectDetails;

import java.util.List;

public interface AIRepositoryCustom {

    public List<ObjectDetails> findObjectTag(String imageId);
}
