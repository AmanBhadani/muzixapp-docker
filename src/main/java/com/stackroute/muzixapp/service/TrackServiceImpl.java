package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){

        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack (Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExistsException("Track already Exists");
        }
        Track savedTrack = trackRepository.save(track);
        if(savedTrack==null){
            throw new TrackAlreadyExistsException("Track already Exists");
        }
        return savedTrack;

    }



    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        if(!trackRepository.existsById(id)){
            throw new TrackNotFoundException("track not found");
        }
        Track track = trackRepository.findById(id).get();

        return track;
    }



    @Override
    public void deleteTrack(int id) throws TrackNotFoundException
    {
        if(!trackRepository.existsById(id))
           throw new TrackNotFoundException("Track Not found");
        trackRepository.delete(getTrackById(id));
    }

    @Override
    public List<Track> getAllTracks()
    {
        return trackRepository.findAll();
    }

    public void deleteall(){
        trackRepository.deleteAll();
    }

    @Override
    public Track updateTrack(int id, String comment) throws TrackNotFoundException{
        if(!trackRepository.existsById(id))
            throw new TrackNotFoundException("Track Not Found");
        Track track1 = trackRepository.findById(id).get();
        track1.setComment(comment);
        Track savedTrack = trackRepository.save(track1);
        return savedTrack;
    }



    public List<Track> getTrackByName(String name) throws TrackNotFoundException {
        List<Track> tracks = trackRepository.findByname(name);
        if (tracks.toString().equals("[]"))
            throw new TrackNotFoundException("No Track Found With Name");
        return tracks;
    }
}
