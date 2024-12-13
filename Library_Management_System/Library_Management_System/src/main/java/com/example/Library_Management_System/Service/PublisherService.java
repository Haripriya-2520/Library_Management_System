package com.example.Library_Management_System.Service;

import com.example.Library_Management_System.entity.Publisher;

import java.util.List;

public interface PublisherService {



    //get all
    List<Publisher> getAllPublishers();
    //get by id
    public Publisher getPublisherById(int id);

    //save authors
    public Publisher saveOrUpdatePublisher(Publisher publisher);



    //delete by id
    public void deletePublisherById(int id);

}
