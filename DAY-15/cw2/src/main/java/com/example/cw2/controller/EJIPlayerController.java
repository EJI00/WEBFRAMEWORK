
package com.example.cw2.controller;

import com.example.cw2.model.EJIPlayer;
import com.example.cw2.service.EJIPlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/players")
public class EJIPlayerController {

    private static final Logger logger = LoggerFactory.getLogger(EJIPlayerController.class);

    @Autowired
    private EJIPlayerService playerService;

    @GetMapping
    public ResponseEntity<List<EJIPlayer>> getAllPlayers() {
        logger.info("FINISHED PROCESSING : METHOD=GET; REQUESTURI=/players; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                "N/A", HttpStatus.OK.value(), "List of players", "N/A");
        List<EJIPlayer> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EJIPlayer> getPlayerById(@PathVariable("id") int id) {
        logger.info("FINISHED PROCESSING : METHOD=GET; REQUESTURI=/players/{}; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                id, HttpStatus.OK.value(), "Player details", "N/A");
        EJIPlayer player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }

    @PostMapping
    public ResponseEntity<EJIPlayer> addPlayer(@RequestBody EJIPlayer player) {
        logger.info("FINISHED PROCESSING : METHOD=POST; REQUESTURI=/players; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                player, HttpStatus.CREATED.value(), "Player added successfully", "N/A");
        EJIPlayer savedPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }
}