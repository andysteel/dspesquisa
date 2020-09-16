package com.gmail.andersoninfonet.dspesquisa.dto;

import java.io.Serializable;

public class RecordInsertDTO implements Serializable {
    
    private static final long serialVersionUID = -1122205060629216849L;
    
    private String name;
    private Integer age;
    private Long gameId;

    /**
     * 
     */
    public RecordInsertDTO() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the gameId
     */
    public Long getGameId() {
        return gameId;
    }

    /**
     * @param gameId the gameId to set
     */
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

}