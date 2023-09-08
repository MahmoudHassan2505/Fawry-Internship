package com.test.service;

import com.test.model.Speaker;
import com.test.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service("speakerService")
@Profile("dev")
@Scope(value = BeanDefinition.SCOPE_SINGLETON) // default is Singleton
public class SpeakerServiceImpl implements SpeakerService {


    private SpeakerRepository repository;

    public SpeakerServiceImpl(){
        System.out.println("SpeakerServiceImpl no args constructor");
    }

    public SpeakerServiceImpl(SpeakerRepository speakerRepository){
        System.out.println("SpeakerServiceImpl repository constructor");
        this.repository=speakerRepository;
    }

    @PostConstruct
    private void initialize(){
        System.out.println("We're called after the constructor");
    }

    @Override
    public List<Speaker> findAll(){
        return repository.findAll();
    }


    @Autowired
    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl setter");
        this.repository = repository;
    }
}
