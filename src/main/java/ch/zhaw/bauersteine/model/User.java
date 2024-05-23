package ch.zhaw.bauersteine.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Document("user")
public class User {
    
    @Id
    private String id;
    @NonNull
    private String email;
    @NonNull
    private String name; 

}
