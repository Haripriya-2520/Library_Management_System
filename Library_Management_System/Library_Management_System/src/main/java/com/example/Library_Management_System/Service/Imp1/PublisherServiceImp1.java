package com.example.Library_Management_System.Service.Imp1;

import com.example.Library_Management_System.Service.PublisherService;
import com.example.Library_Management_System.repository.PublisherRepo;
import com.example.Library_Management_System.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImp1 implements PublisherService {

    @Autowired
    private PublisherRepo publisherRepo;



    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepo.findAll();
    }

    @Override
    public Publisher getPublisherById(int id) {
        return publisherRepo.findById(id).orElseThrow(()->new RuntimeException("Given id is incorrect"));
    }

    @Override

    public Publisher saveOrUpdatePublisher(Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    @Override
    public void deletePublisherById(int id) {
        publisherRepo.findById(id).orElseThrow(()->new RuntimeException("Given id is incorrect"));
        publisherRepo.deleteById(id);
    }
}
