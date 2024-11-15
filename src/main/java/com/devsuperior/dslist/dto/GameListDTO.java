package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList entity){
        BeanUtils.copyProperties(entity,this);
    }
}
