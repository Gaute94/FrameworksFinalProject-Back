package me.gaute.redditcloneback.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String comment;
    @ManyToOne(fetch = FetchType.EAGER)
    private Subreddit subreddit;
    @ManyToOne(fetch = FetchType.EAGER)
    private User owner;
    private int likes;
}