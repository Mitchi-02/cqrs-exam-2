package com.example.msreservationcommand.Aggregate;

import com.example.coreapi.commands.AddReservationCommand;
import com.example.coreapi.commands.DeleteReservationCommand;
import com.example.coreapi.events.ReservationAddedEvent;
import com.example.coreapi.events.ReservationRemovedEvent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ReservationAggregate {
    @AggregateIdentifier
    @Id
    private String idRes;

    private Date dateDebut;
    private Date dateFin;

    private String idCh;

    @CommandHandler
    public ReservationAggregate (AddReservationCommand cmd){
        AggregateLifecycle.apply(new ReservationAddedEvent(cmd.getIdRes(),cmd.getDateDebut(),
                                                           cmd.getDateFin(), cmd.getIdCh()));
    }

    @EventSourcingHandler
    public void on(ReservationAddedEvent event){
        this.idRes= event.getIdRes();
        this.dateDebut=event.getDateDebut();
        this.dateFin=event.getDateFin();
        this.idCh=event.getIdCh();
    }

    @CommandHandler
    public void Handle(DeleteReservationCommand cmd)
    {
        //event has idRes and idCh
        AggregateLifecycle.apply(new ReservationRemovedEvent(cmd.getIdRes(), this.idCh));
    }

    @EventSourcingHandler
    public void on(ReservationRemovedEvent event){
        AggregateLifecycle.markDeleted();
    }
}
