# Anforderungen

In diesem Abschnitt geht es darum, die grundlegenden Anforderungen für das Projekt detailliert darzustellen. Es wird ein Use-Case Diagramm sowie eine dazugehörige Beschreibung erstellt, um die möglichen Interaktionen der Nutzer mit dem System zu verdeutlichen. Zusätzlich wird das fachliche Datenmodell mittels eines ER-Modells ausgearbeitet, das mit entsprechenden Erläuterungen versehen ist, um die Datenstruktur und die Beziehungen zwischen den Entitäten zu klären. Des Weiteren beinhaltet dieser Abschnitt ein Prozessmodell, das mit einem BPMN-Diagramm illustriert wird, um die Geschäftsprozesse zu visualisieren. Schliesslich wird ein Mockup oder eine Skizze des User Interfaces (UI) präsentiert, die einen ersten visuellen Eindruck der Anwendung bietet und zeigt, wie die Benutzerinteraktion gestaltet sein könnte.

# Use-Case Diagramm und Use-Case Beschreibung

![Use-Case Diagramm](figures/ucDiagramm.drawio.svg)

Diese Use Cases zeigen auf, wie die verschiedenen Benutzer mit der Plattform interagieren, von der einfachen Ansicht der Produkte bis hin zur Anpassung und dem Kauf. Der Prozess ist klar darauf ausgelegt, dass sowohl Gastbenutzer als auch registrierte Benutzer und Produzenten spezifische Rollen und Funktionen innerhalb der Applikation haben, die es ermöglichen, den Prozess des Kaufens und Personalisierens einer Urne effizient und benutzerfreundlich zu gestalten.

## Akteure

> Gast User: Ein nicht registrierter Benutzer, der die Plattform besucht.
> Angemeldeter User: Ein registrierter Benutzer mit zusätzlichen Rechten.
> Produzent: Ein Benutzer, der Urnen produziert und in die Plattform einspeist.

## Use Cases für Gast User

> Urnen Angebot einsehen: Der Gast kann das vorhandene Urnenangebot betrachten ohne registriert zu sein.
> Urnen suchen: Der Gast kann aktiv nach spezifischen Urnen suchen, um passende Optionen zu finden.
## Use Cases für angemeldete User

> Urne zu Warenkorb hinzufügen: Ermöglicht es dem angemeldeten User, eine ausgewählte Urne in den Warenkorb zu legen.
> Personalisierung anfragen: Der User kann spezifische Anpassungen für eine Urne anfragen, wie Gravuren oder spezielle Materialien.
> Bestellbestätigung senden: Nach dem Kaufprozess erhält der User eine Bestätigung seiner Bestellung.
> Einkauf tätigen: Der User kann seinen Einkauf abschliessen und die Bestellung aufgeben.
## Use Cases für den Produzenten

> Urne erfassen: Der Produzent kann neue Urnenmodelle in das System eintragen.
> Urne liefern: Nach der Bestellung kümmert sich der Produzent um die Lieferung der Urne an den Kunden.
## Zusätzliche Details

> Personalisierung: Dieser Use Case ist ein Teil der Use Cases „Urne zu Warenkorb hinzufügen“ und „Einkauf tätigen“, da Personalisierungsoptionen während des Kaufvorgangs angefordert und bestätigt werden müssen.

# Fachliches Datenmodell (ER-Modell) mit Erläuterungen
<!-- TODO: Implementieren -->
Aktueller stand im Lucidchart

# Prozessmodell (BPMN-Diagramm) mit Erläuterungen 
Dieses Diagramm bietet eine detaillierte Übersicht über die Abläufe und Entscheidungen, die innerhalb der Bauersteine Graburnen Applikation stattfinden. Es stellt sicher, dass sowohl die Interaktionen der Benutzer als auch die internen Systemprozesse klar definiert und nachvollziehbar sind.

![BPMN Bauersteine](figures\BPMNBauersteine.PNG)





# Mockup oder Skizze des UIs 
