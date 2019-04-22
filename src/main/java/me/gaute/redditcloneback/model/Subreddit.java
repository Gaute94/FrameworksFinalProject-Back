package me.gaute.redditcloneback.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @JsonBackReference
    private User owner;
    private int subscribers;
}
