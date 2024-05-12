package com.example.mshotelcommand.API;

import com.example.coreapi.DTO.ChambreDTO;
import com.example.coreapi.DTO.HotelDTO;
import com.example.coreapi.commands.AddChambreCommand;
import com.example.coreapi.commands.AddHotelCommand;
import com.example.coreapi.commands.DeleteChambreCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("command")
public class HotelController {
    private final CommandGateway commandGateway;

    public HotelController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("hotel")
    public CompletableFuture<String> createHotel(@RequestBody HotelDTO hotelDTO){
        CompletableFuture<String> response= commandGateway.send(
                new AddHotelCommand(hotelDTO.getIdH(), hotelDTO.getNom(), hotelDTO.getNbEtoiles()));

        return  response;
    }

    @PostMapping("/hotel/{idh}/chambre")
    public CompletableFuture<String> addChambre(@PathVariable String idh,
                                                @RequestBody ChambreDTO chambreDTO) {
        CompletableFuture<String> response= commandGateway.send(new AddChambreCommand(
                chambreDTO.getIdCh(), chambreDTO.getType(), chambreDTO.getEtage(), idh));
        return response;
    }

    @DeleteMapping("/hotel/{idh}/{idch}")
    public CompletableFuture<String> removeChambre(@PathVariable String idh,
                                                @PathVariable String idch) {
        CompletableFuture<String> response= commandGateway.send(
                new DeleteChambreCommand(idch,idh));
        return response;
    }
}
