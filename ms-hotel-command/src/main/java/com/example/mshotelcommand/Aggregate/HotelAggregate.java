package com.example.mshotelcommand.Aggregate;

import com.example.coreapi.commands.AddChambreCommand;
import com.example.coreapi.commands.AddHotelCommand;
import com.example.coreapi.commands.DeleteChambreCommand;
import com.example.coreapi.events.ChambreAddedEvent;
import com.example.coreapi.events.ChambreRemovedEvent;
import com.example.coreapi.events.HotelAddedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Aggregate
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class HotelAggregate {

    @TargetAggregateIdentifier
    @AggregateIdentifier
    @Id
    private String idH;

    private String nom;
    private Integer nbEtoiles;

    @OneToMany(mappedBy = "hotel")
    @AggregateMember
    private List<ChambreAggregate> chambres;

    @CommandHandler
    public HotelAggregate(AddHotelCommand cmd)
    {
        AggregateLifecycle.apply(new HotelAddedEvent(cmd.getIdH(), cmd.getNom(), cmd.getNbEtoiles()));
    }

    @EventSourcingHandler
    public void on (HotelAddedEvent event){
        this.idH = event.getIdH();
        this.nom = event.getNom();
        this.nbEtoiles = event.getNbEtoiles();
        this.chambres = new ArrayList<>();
    }

    @CommandHandler
    public void handler(AddChambreCommand cmd){
        AggregateLifecycle.apply(new ChambreAddedEvent(cmd.getIdCh(),cmd.getType(), cmd.getEtage(), cmd.getIdH()));
    }

    @EventSourcingHandler
    public void on(ChambreAddedEvent event){
        this.chambres.add(new ChambreAggregate(event.getIdCh(), event.getType(), event.getEtage(), this));
    }

    @CommandHandler
    public void handler(DeleteChambreCommand cmd)
    {
        AggregateLifecycle.apply(new ChambreRemovedEvent(cmd.getIdCh(), cmd.getIdH() ));
    }

    @EventSourcingHandler
    public void on(ChambreRemovedEvent event){
        for (ChambreAggregate chambre: this.chambres){
            if(chambre.getIdCh().equals(event.getIdCh()))
            {
                this.chambres.remove(chambre);
                break;
            }
        }
    }
}
