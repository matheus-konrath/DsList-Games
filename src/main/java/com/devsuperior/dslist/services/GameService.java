package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.GameEntity;
import com.devsuperior.dslist.exception.ResourceNotFoundException;
import com.devsuperior.dslist.projection.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public List<GameMinDTO> findAll(){
        List<GameEntity> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional
    public GameDTO findById(Long id){
        Optional<GameEntity> obj = gameRepository.findById(id);
        GameEntity entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new GameDTO(entity);
    }

    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).toList();
    }

}
