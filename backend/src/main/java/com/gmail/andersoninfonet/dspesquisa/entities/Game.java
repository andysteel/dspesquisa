package com.gmail.andersoninfonet.dspesquisa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gmail.andersoninfonet.dspesquisa.entities.enums.Platform;

@Entity
@Table(name = "tb_game")
public class Game implements Serializable {
    
    private static final long serialVersionUID = -4468150576297079529L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "platform")
    private Platform platform;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    private List<Record> records = new ArrayList<>();

    public Game() {

    }

    /**
     * @param id
     * @param title
     * @param platform
     * @param genre
     */
    public Game(Long id, String title, Platform platform, Genre genre) {
        this.id = id;
        this.title = title;
        this.platform = platform;
        this.genre = genre;
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

    /**
     * @return the genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * @return the records
     */
    public List<Record> getRecords() {
        return records;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}