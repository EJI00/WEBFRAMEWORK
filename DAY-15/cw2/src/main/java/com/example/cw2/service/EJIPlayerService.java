package com.example.cw2.service;

import com.example.cw2.model.EJIPlayer;
import com.example.cw2.repository.EJIPlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EJIPlayerService {

    @Autowired
    private EJIPlayerRepo playerRepo;

    public List<EJIPlayer> getAllPlayers() {
        return playerRepo.findAll();
    }

    public EJIPlayer getPlayerById(int id) {
        return playerRepo.findById(id).orElse(null);
    }

    public EJIPlayer addPlayer(EJIPlayer player) {
        return playerRepo.save(player);
    }
}
