package com.stackroute.muzixapp.startup;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.boot.CommandLineRunner;

public class CommandLine implements CommandLineRunner {
    private TrackRepository trackRepository;

    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Track track= new Track();
        track.setId(12);
        track.setComment("Bhadani");
        track.setName("Aman");
        trackRepository.save(track);
    }
}
