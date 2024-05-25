package ch.zhaw.bauersteine.model;

import lombok.AllArgsConstructor;

//import java.time.LocalDateTime;

//Definiert Daten, die für das Erstellen einer Urne benötigt werden
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UrneCreateDTO {

    private String beschreibung;
    private String material;
    private double preis;
    private double inhaltsmenge;
    //private LocalDateTime createdDate; für NEW


}
