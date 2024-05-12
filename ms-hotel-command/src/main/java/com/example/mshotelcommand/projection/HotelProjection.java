package com.example.mshotelcommand.projection;

import com.example.coreapi.events.ChambreAddedEvent;
import com.example.coreapi.events.ChambreRemovedEvent;
import com.example.coreapi.events.HotelAddedEvent;
import com.example.mshotelcommand.Aggregate.ChambreAggregate;
import com.example.mshotelcommand.Aggregate.HotelAggregate;
import com.example.mshotelcommand.repository.ChambreRepository;
import com.example.mshotelcommand.repository.HotelRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HotelProjection {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ChambreRepository chambreRepository;

    @EventHandler
    public void addHotel(HotelAddedEvent event){
        hotelRepository.save(
                new HotelAggregate(event.getIdH(), event.getNom(), event.getNbEtoiles(), null ));
    }

    @EventHandler
    public void addChambre(ChambreAddedEvent event){
        Optional<HotelAggregate> data=hotelRepository.findById(event.getIdH());
        if(data.isEmpty()){
            return;
        }
        chambreRepository.save(
                new ChambreAggregate(event.getIdCh(), event.getType(),  event.getEtage(),data.get()));
    }

    @EventHandler
    public void removeChambre(ChambreRemovedEvent event)
    {
        chambreRepository.deleteById(event.getIdCh());
    }
}
