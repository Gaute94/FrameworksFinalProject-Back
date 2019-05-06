package me.gaute.redditcloneback.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String imageName;
    @ManyToOne(fetch = FetchType.EAGER)
    private User owner;
    @Lob
    @Column(length = 52428800)
    private byte[] bytes;
}
