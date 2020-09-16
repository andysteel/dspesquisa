package com.gmail.andersoninfonet.dspesquisa.dto;

import java.io.Serializable;

import com.gmail.andersoninfonet.dspesquisa.entities.Game;
import com.gmail.andersoninfonet.dspesquisa.entities.enums.Platform;

public class GameDTO implements Serializable {
    
    private static final long serialVersionUID = 2184110496819812876L;

    private Long id;
    private String title;
    private Platform platform;

    /**
     * 
     */
    public GameDTO() {
    }

    /**
     * @param entity Game 
     */
    public GameDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.platform = entity.getPlatform();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the platform
     */
    public Platform getPlatform() {
        return platform;
    }

    /**
     * @param platform the platform to set
     */
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

}