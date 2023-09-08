package com.Spring.conferenceSpringboot.repository;


import com.Spring.conferenceSpringboot.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
    List<Speaker> findAll();
}
