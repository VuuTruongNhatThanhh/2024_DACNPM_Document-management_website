package com.boot.music.service;

import com.boot.music.entity.Status;
import com.boot.music.repositories.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusRepo statusRepository;
    public List<Status> getAllStatuses() {return statusRepository.findAll();}
}
