package com.pluralsight.sneakerdrops.controllers;

import com.pluralsight.sneakerdrops.models.Sneaker;
import com.pluralsight.sneakerdrops.service.SneakerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Handles Http request and returns the results JSON
@RestController
//Common path for whole class(BASE URL)
@RequestMapping("/api/sneakers")
/*allows a web pag served from a different address to call this api from the browser
(This is CORS, a browser security rule, 1 annotation switches it on)*/
@CrossOrigin
public class SneakerController {

    private final SneakerService sneakerService;
    /*takes SneakerService and uses construtor injection @AUtowired not need for 1 constructor
    The SneakerController asks the SneakerService (Never touches the repository)*/
    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }
    //endpoint
    @GetMapping //helps access it through a get request
    public List<Sneaker> getAll(){
        return sneakerService.allSneakers();
    }
}
