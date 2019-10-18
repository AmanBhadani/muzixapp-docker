package com.stackroute.muzixapp.startup;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationListen implements ApplicationListener<ContextRefreshedEvent> {
    private TrackRepository trackRepository;

    @Autowired
    public void SetTrackRepository(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Track track= new Track();
        track.setId(12);
        track.setComment("Bhadani");
        track.setName("Aman");
        trackRepository.save(track);

    }
}
