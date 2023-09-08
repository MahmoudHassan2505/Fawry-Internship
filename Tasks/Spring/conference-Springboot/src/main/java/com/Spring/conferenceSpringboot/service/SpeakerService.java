package com.Spring.conferenceSpringboot.service;


import com.Spring.conferenceSpringboot.model.Speaker;

import java.util.List;

public interface SpeakerService {
    List<Speaker> findAll();
}
