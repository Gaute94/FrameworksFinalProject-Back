package me.gaute.redditcloneback.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaveUserResponse {

    private String message;
    private User user;
    private boolean ok;


}
