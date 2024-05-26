# Implementation

Dieser Abschnitt widmet sich der praktischen Umsetzung der zuvor definierten Anforderungen. Es wird eine ausführliche Beschreibung des Frontends gegeben, inklusive Screenshots der fertigen Applikation, um die tatsächliche Realisierung zu dokumentieren. Ausserdem wird ein Klassendiagramm des technischen Datenmodells präsentiert, das die verwendeten Data Transfer Objects (DTOs) und Data Access Objects (DAOs) umfasst und ihren Verwendungszweck erläutert. Zusätzlich werden die Aufgaben und Funktionen der eingebundenen Drittsysteme beschrieben, die für die Erweiterung der Funktionalität der Hauptanwendung kritisch sind.

# Beschreibung des Frontends mit Screenshots der fertigen Applikation
![Home](figures\shotHome.PNG)

Oben links befindet sich das Logo der Website "bauersteine".
Navigationsleiste:

Direkt neben dem Logo gibt es eine Navigationsleiste mit den folgenden Menüpunkten:
Urnen
Urnen erstellen
Einkaufswagen
Account
Benutzerinformationen:

Oben rechts wird die E-Mail-Adresse des angemeldeten Benutzers angezeigt (prod@a.ch).
Ein blauer "Log Out"-Button befindet sich neben der E-Mail-Adresse.

Im Hauptbereich ist die Willkommensnachricht

![Home](figures\shoUrnen.PNG)
Kopfbereich
Logo und Navigationsleiste mit den Punkten: Urnen, Urnen erstellen, Einkaufswagen, Account.
E-Mail des Benutzers (prod@a.ch) und ein "Log Out"-Button.
Hauptbereich
Überschrift: "Alle Urnen".
Auflistung der Urnen: Jede Urne wird mit einem Bild und den folgenden Details angezeigt:
Beschreibung
Material
Preis
Inhaltsmenge in Liter
Status: "Ausverkauft"-Button

![Home](figures\shotUrnenErstellen.PNG)
Kopfbereich
Logo und Navigationsleiste mit den Punkten: Urnen, Urnen erstellen, Einkaufswagen, Account.
E-Mail des Benutzers (prod@a.ch) und ein "Log Out"-Button.
Hauptbereich
Formular zum Erstellen einer Urne:

Felder: Beschreibung, Material, Preis, Inhaltsmenge in Liter.
Ein blauer "Submit"-Button zum Absenden der Eingaben.
Liste aller Urnen:

Überschrift: "Alle Urnen".
Tabelle mit den Spalten: Beschreibung, Material, Preis, Inhaltsmenge, State, UrnId.
Jede Zeile enthält eine Urne mit Informationen und zwei Aktionen (Deliver, Delete) mit roten "X"-Buttons.

Der Produzent Kann den Button für Geliefert Drücken wenn Die Urne Bezahlt wurde.
![Home](figures\shotEinkaufswagen.PNG)
Kopfbereich
Logo und Navigationsleiste mit den Punkten: Urnen, Urnen erstellen, Einkaufswagen, Account.
E-Mail des Benutzers (prod@a.ch) und ein "Log Out"-Button.
Hauptbereich
Überschrift: "Deine Bestellungen".
Tabelle mit den Spalten: Bestellnummer, State (Zustand), UrnIds (ID der Urnen), Bezahlen.
Eine Bestellung mit der Bestellnummer 664cfd2cdf9b051e44068b75 und dem Zustand "PAYED".
Auflistung der Urnen mit ID und Bild zu dieser Bestellung.

Die Orders die noch nicht bezahlt sind kann man noch bearbeiten und Urnen heraus Löschen mit dem jeweiligen Butten der In der Card angezeigt wird.

Wenn die Order Noch nicht bezahlt ist Findet man den Butten Dafür in der Spalte ganz rechts.




![Home](figures\shotAccount.PNG)
Hier werden die Account Details Angezeigt
# Klassendiagramm mit dem technischen Datenmodell  
![Home](figures\UML.drawio.svg)


# Aufgaben und Funktionen eingebundener Drittsysteme 
![Home](figures\email.PNG)

Email wurde eingebunden um eine Zahlungsbestätigung zu senden wenn ein nutzer auf den Button zum bezahlen drückt.