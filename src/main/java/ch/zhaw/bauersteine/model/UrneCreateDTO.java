package ch.zhaw.bauersteine.model;

//Definiert Daten, die für das Erstellen einer Urne benötigt werden
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UrneCreateDTO {

    private String beschreibung;
    private String material;
    private double preis;

}
