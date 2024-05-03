package ch.zhaw.bauersteine.model;


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

    private UrneState state = UrneState.NEW;
}
