package ch.zhaw.bauersteine.model;


//import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Document("urne")

public class Urne {

    @Id
    private String id;
    @NonNull
    private String beschreibung;
    @NonNull
    private String material;
    @NonNull
    private double preis;
    @NonNull
    private double inhaltsmenge; // in Liter

    private UrneState state = UrneState.AVAILABLE;

    @NonNull
    private String userEmail;


    public void setState(UrneState state) {
        this.state = state;
    }
    
    //private LocalDateTime createdDate; für NEW

}
