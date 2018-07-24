# -*- coding: utf-8 -*-
"""
Created on Wed Jun  6 15:40:36 2018

@author: 109757
"""


from imageai.Detection import ObjectDetection
import os
import uuid
from pymongo import MongoClient
import shutil

#execution_path = os.getcwd()
execution_path = "C:\\Jagadeesan\\wamp\\www\\upload"
image_input_path = execution_path + "\imageinput"
image_output_path = execution_path + "\imageoutput"
image_arch_path = execution_path + "\imagearch"

images = os.listdir(image_input_path)


detector = ObjectDetection()
detector.setModelTypeAsRetinaNet()
detector.setModelPath( os.path.join(execution_path , "resnet50_coco_best_v2.0.1.h5"))
detector.loadModel(detection_speed="normal")
client = MongoClient()
client = MongoClient('localhost', 27017)
db = client.AI


for image in images:
    UUID = str(uuid.uuid4())
    detections, objects_path = detector.detectObjectsFromImage(input_image=os.path.join(image_input_path , image), output_image_path=os.path.join(image_output_path , UUID + ".jpg"), extract_detected_objects=True)    
    lst = [] 
    
    for eachObject,eachObjectPath in zip(detections, objects_path):
        print(eachObject["name"] + " : " + eachObject["percentage_probability"] )
        print("--------------------------------") 
        if eachObject["name"] not in lst:
            lst.append(eachObject["name"]);        
        
    posts = db.ObjectDetails
    post_data = {
        'imageId': UUID,
        'objecttag': lst   
    }
    result = posts.insert_one(post_data)
    print('One post: {0}'.format(result.inserted_id))  
    #input_image_path = os.path.join(image_input_path , image)    
    shutil.copy2(os.path.join(image_input_path , image), os.path.join(image_output_path , UUID + "_orginal.jpg"))
    shutil.move(os.path.join(image_input_path , image), image_arch_path)