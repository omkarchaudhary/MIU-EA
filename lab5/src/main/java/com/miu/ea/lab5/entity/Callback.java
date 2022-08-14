package com.miu.ea.lab5.entity;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;

public class Callback {
    @PostPersist
    public void callBackWhenUpdated(Student student){
        System.out.println("Persisted Student "+ student);
    }


    @PostUpdate
    public static void callBackWhenPersisted(Student student){
        System.out.println("Updated Student "+ student);
    }

    @PostRemove
    public void callBackWhenRemoved(Student student){
        System.out.println("Removed Student "+ student);
    }

}
