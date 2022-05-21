package me.dio.gof.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    private String title;

    @JsonProperty("episode_id")
    private long episodeId;

    @JsonProperty("opening_crawl")
    @Column(columnDefinition = "text")
    private String openingCrawl;

    private String director;

    private String producer;

    @JsonProperty("release_date")
    private String releaseDate;

    private String url;

    @JsonIgnore
    public int getUrlId() {
        return Integer.parseInt(url.replaceAll("\\D", ""));
    }
}
