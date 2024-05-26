# Fazit

Der abschliessende Abschnitt reflektiert den aktuellen Stand der Implementation und diskutiert die erzielten Ergebnisse. Es wird bewertet, inwiefern die gesteckten Projektziele erreicht wurden und welche Herausforderungen während der Umsetzung aufgetreten sind. Darüber hinaus werden die nächsten Schritte vorgeschlagen, die zur Weiterentwicklung und Verbesserung des Projekts notwendig sind. Abschliessend 

# Stand der Implementation, Diskussion der Ergebnisse 

ER-Diagramm
Das ER-Diagramm ist gut strukturiert und deckt die wesentlichen Beziehungen zwischen den Entitäten ab. Es zeigt klar die 1
zwischen "Urne" und "Order" sowie die m
zwischen "Order" und "User". Dies hilft bei der klaren Definition der Datenbankstruktur und stellt sicher, dass die Beziehungen zwischen den Datenelementen verständlich und gut organisiert sind.

>Seiten
Startseite: Die Begrüßungsnachricht ist klar und einladend. Die Navigation ist intuitiv und ermöglicht den Benutzern, schnell auf verschiedene Bereiche der Website zuzugreifen.
Bestellübersicht: Die Auflistung der Bestellungen und der dazugehörigen Urnen ist übersichtlich und informativ. Der Zustand der Bestellung ("PAYED") ist klar ersichtlich.
Urne Erstellen: Das Formular zur Erstellung neuer Urnen ist einfach und funktional. Die Auflistung aller Urnen ermöglicht eine einfache Verwaltung.
Urnen-Übersicht: Die Darstellung der Urnen mit Bildern und Details ist visuell ansprechend und informativ. Der "Ausverkauft"-Status ist deutlich gekennzeichnet.
SonarQube-Analyse
Die Code-Analyse mit SonarQube zeigt einige Bereiche, in denen Verbesserungen notwendig sind:

Konsistenz: Es gibt 25 Probleme, die auf inkonsistente Namenskonventionen oder Formatierungsprobleme hinweisen. Diese sollten behoben werden, um die Lesbarkeit und Wartbarkeit des Codes zu verbessern.
Zuverlässigkeit: 24 Probleme deuten auf potenzielle Fehlerquellen hin, die behoben werden sollten, um die Stabilität des Systems zu gewährleisten.
Wartbarkeit: 42 Probleme in der Wartbarkeit weisen darauf hin, dass der Code schwer zu verstehen oder zu modifizieren ist. Dies sollte adressiert werden, um langfristig eine effiziente Wartung zu ermöglichen.
Fazit und Empfehlungen
Verbesserung der Codequalität: Die identifizierten Probleme in der SonarQube-Analyse sollten priorisiert und behoben werden, um die Gesamtqualität und Wartbarkeit des Codes zu verbessern.
Benutzeroberfläche: Die Website ist funktional und benutzerfreundlich gestaltet. Es könnte jedoch sinnvoll sein, regelmäßiges Feedback von Benutzern einzuholen, um weitere Verbesserungen vorzunehmen.
Datenbankstruktur: Das ER-Diagramm sollte als Grundlage für die Implementierung der Datenbank verwendet werden. Es ist wichtig, sicherzustellen, dass die Beziehungen korrekt in der Datenbank abgebildet werden.
Insgesamt befindet sich die Implementation auf einem guten Weg, aber es gibt noch einige Bereiche, die verbessert werden müssen, um eine robuste und wartbare Anwendung bereitzustellen.
Dazu kommt, dass der Upload nicht geglückt ist was ein ein Wichtiger Punkt zum vertrieb von Einzelprodukten ist.

# Nächste Schritte 
- Upload Implementieren
- Tests ausweiten
- Frontend Detaillierter Gestalten mit mehr Bildern wenn der Upload funktioniert.
- Zahlungsdienste Implementieren wie Twint
- Emailing mit Personalisierungen ausweiten

# Persönliches Fazit 

## Projektfortschritt
Der aktuelle Stand der Implementation zeigt deutliche Fortschritte und eine solide Basis für das Projekt. Das ER-Diagramm und die bereitgestellten Screenshots der Website vermitteln einen klaren Überblick über die Struktur und Funktionalität des Systems. Besonders hervorzuheben sind die gut definierte Datenbankstruktur und die benutzerfreundliche Gestaltung der Website.

## Stärken
Klarheit und Struktur:
Das ER-Diagramm bietet eine klare und verständliche Darstellung der Datenbankbeziehungen, was für die weitere Entwicklung und Wartung von großem Vorteil ist.
Benutzerfreundlichkeit:
Die Website ist intuitiv und einfach zu navigieren, was die Benutzererfahrung positiv beeinflusst.
Funktionalität:
Die wesentlichen Funktionen wie das Erstellen von Urnen, die Bestellübersicht und die Verwaltung von Urnen sind implementiert und gut dargestellt.
Verbesserungsbedarf
Codequalität:

Die SonarQube-Analyse hat verschiedene Probleme identifiziert, insbesondere im Bereich Konsistenz, Zuverlässigkeit und Wartbarkeit. Diese sollten priorisiert behoben werden, um die langfristige Qualität und Stabilität des Codes zu gewährleisten.
Detailtiefe:

Einige Bereiche, wie die genaue Implementierung der Datenbankabfragen und die Behandlung spezieller Fehlerfälle, könnten weiter vertieft und detailliert dokumentiert werden.
Feedback-Schleifen:

Es wäre hilfreich, regelmäßiges Feedback von Endbenutzern und Stakeholdern einzuholen, um die Benutzeroberfläche und die Funktionalität kontinuierlich zu verbessern.