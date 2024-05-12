package com.example.msqueryjoin.projection;

import com.example.coreapi.events.ChambreAddedEvent;
import com.example.coreapi.events.ChambreRemovedEvent;
import com.example.coreapi.events.ReservationAddedEvent;
import com.example.coreapi.events.ReservationRemovedEvent;
import com.example.msqueryjoin.entities.StatusTable;
import com.example.msqueryjoin.repository.StatusTableRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StatusProjection {

    @Autowired
    private StatusTableRepository statusTableRepository;


    @EventHandler
    public void AddChambre(ChambreAddedEvent event)
    {
        StatusTable data = new StatusTable(event.getIdCh(), event.getIdH(), 0);
        statusTableRepository.save(data);
    }

    @EventHandler
    public void DeleteChambre(ChambreRemovedEvent event)
    {
        statusTableRepository.deleteById(event.getIdCh());
    }

    @EventHandler
    public void AddReservation(ReservationAddedEvent event)
    {
        Optional<StatusTable> data = statusTableRepository.findById(event.getIdCh());
        if(data.isEmpty())
        {
            return;
        }
        StatusTable statusTable = data.get();

        statusTable.setNbReservations(statusTable.getNbReservations() + 1);
        statusTableRepository.save(statusTable);
    }

    @EventHandler
    public void DeleteReservation(ReservationRemovedEvent event)
    {
        Optional<StatusTable> data = statusTableRepository.findById(event.getIdCh());
        if(data.isEmpty())
        {
            return;
        }
        StatusTable statusTable = data.get();

        statusTable.setNbReservations(statusTable.getNbReservations() - 1);
        statusTableRepository.save(statusTable);
    }
}
