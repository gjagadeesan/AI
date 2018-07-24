package com.merrill.hackathon.AIDemo.entity;

/**
 * Created by 109757 on 7/16/2018.
 */

import org.springframework.data.mongodb.core.mapping.Document;

        import java.util.List;

@Document(collection = "ObjectDetails")
public class ObjectDetails {

    private String imageId;
    private List<String> objecttag;
    //private String[] objecttag;

    public String getImageId() {
        return imageId;
    }

    public ObjectDetails setImageId(String imageId) {
        this.imageId = imageId;
        return this;
    }

    public List<String> getObjecttag() {
        return objecttag;
    }

    public ObjectDetails setObjecttag(List<String> objecttag) {
        this.objecttag = objecttag;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ObjectDetails{");
        sb.append("imageId='").append(imageId).append('\'');
        sb.append(", objecttag=").append(objecttag);
        sb.append('}');
        return sb.toString();
    }
}