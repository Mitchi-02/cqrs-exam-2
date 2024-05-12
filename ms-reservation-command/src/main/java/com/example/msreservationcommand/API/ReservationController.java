package com.example.msreservationcommand.API;

import com.example.coreapi.DTO.ReservationDTO;
import com.example.coreapi.commands.AddReservationCommand;
import com.example.coreapi.commands.DeleteReservationCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("command")
public class ReservationController {

    private final CommandGateway commandGateway;

    public ReservationController (CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("reservation")
    public CompletableFuture<String> createHotel(@RequestBody ReservationDTO r){
        CompletableFuture<String> response= commandGateway.send(
                new AddReservationCommand(r.getIdRes(),r.getDateDebut(),r.getDateFin(),r.getIdCh()));

        return  response;
    }

    @DeleteMapping("reservation/{id}")
    public CompletableFuture<String> createHotel(@PathVariable("id") String  id){
        CompletableFuture<String> response= commandGateway.send(
                new DeleteReservationCommand(id));

        return  response;
    }
}
