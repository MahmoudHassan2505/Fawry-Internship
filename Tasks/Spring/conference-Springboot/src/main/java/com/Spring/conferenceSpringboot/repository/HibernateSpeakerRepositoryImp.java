package com.Spring.conferenceSpringboot.repository;
import com.Spring.conferenceSpringboot.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.lang.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository("speakerRepository")
public class HibernateSpeakerRepositoryImp implements SpeakerRepository {

    @Value("#{ T(java.lang.Math).random() * 100}")
    private double seedNum;
    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setFirstname("Mahmoud");
        speaker.setLastname("Ghania");
        speaker.setSeedNum(seedNum);

        speakers.add(speaker);

        return speakers;
    }
}
