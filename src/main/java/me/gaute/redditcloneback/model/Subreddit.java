package me.gaute.redditcloneback.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Subreddit {
    @Id
    private String title;
    private String rules;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    private User owner;
}
