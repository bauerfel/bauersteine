# Testing

In diesem Abschnitt werden die verschiedenen Stufen der Qualitätssicherung behandelt. Es umfasst eine Beschreibung der durchgeführten Modul- und Integrationstests, die sicherstellen, dass einzelne Komponenten sowie deren Zusammenspiel innerhalb der Anwendung korrekt funktionieren. Falls vorhanden, wird auch auf End-to-End Tests eingegangen, die den Ablauf von der Benutzerinteraktion bis zum erwarteten Ergebnis prüfen. Zudem wird über Erkenntnisse aus der Analyse mit SonarQube berichtet, einem Werkzeug zur statischen Code-Analyse, das hilft, die Codequalität zu verbessern und sicherheitskritische Probleme zu identifizieren.

# Beschreibung der Modul- und Integrationstests 

## UrneServiceTest
>Urne nicht gefunden: Testet, ob die Methode korrekt mit einer nicht vorhandenen Urne umgeht.
>Urne nicht verkauft: Überprüft, dass die Methode keine Änderungen vornimmt, wenn die Urne noch verfügbar ist.
>Urne verkauft: Testet, ob die Methode den Status der Urne auf "DELIVERED" setzt und die zugehörige Bestellung aktualisiert.
>Bestellung nicht vollständig geliefert: Überprüft, dass die Bestellung nicht auf "DELIVERED" gesetzt wird, wenn nicht alle Urnen geliefert wurde

## OrderServiceTest
>Order nicht gefunden: Testet, ob die Methode korrekt mit einer nicht vorhandenen Order umgeht.
>Order nicht zugewiesen: Überprüft, dass die Methode keine Änderungen vornimmt, wenn die Order nicht im Zustand "ASSIGNED" ist.
>Urne nicht gefunden: Testet, ob die Methode korrekt mit einer nicht vorhandenen Urne umgeht.
>Urne nicht verfügbar: Überprüft, dass die Methode keine Änderungen vornimmt, wenn die Urne nicht im Zustand "AVAILABLE" ist.
>Erfolgreiche Zuweisung: Testet, ob die Urne erfolgreich der Order zugewiesen wird und die Zustände korrekt aktualisiert werden.

>Order nicht gefunden: Testet, ob die Methode korrekt mit einer nicht vorhandenen Order umgeht.
>Order nicht zugewiesen: Überprüft, dass die Methode keine Änderungen vornimmt, wenn die Order nicht im Zustand "ASSIGNED" ist.
>Erfolgreiche Zahlung: Testet, ob die Order erfolgreich auf "PAYED" gesetzt wird und die zugehörigen Urnen auf "SOLD" gesetzt werden.
>Urne nicht gefunden: Überprüft, dass die Methode korrekt weiterarbeitet, auch wenn eine der Urnen nicht gefunden wird.

>testSetOrderToDelivered_OrderNotFound: Testet, ob die Methode korrekt mit einer nicht vorhandenen Order umgeht.
>testSetOrderToDelivered_OrderNotPayed: Überprüft, dass die Methode keine Änderungen vornimmt, wenn die Order nicht im Zustand "PAYED" ist.
>testSetOrderToDelivered_Success: Testet, ob die Order erfolgreich auf "DELIVERED" gesetzt wird, wenn die Order im Zustand "PAYED" ist.

## UrneControllerTest
>testCreateUrne: Simuliert die Erstellung einer Urne durch einen Benutzer mit der Rolle prod. Überprüft, ob die Antwort den Status 201 Created zurückgibt und ob das JSON-Antwortobjekt die erwarteten Felder und Werte enthält.
>testCreateUrneForbidden: Simuliert den Versuch, eine Urne zu erstellen, durch einen Benutzer mit der Rolle user.Überprüft, ob die Antwort den Status 403 Forbidden zurückgibt, da der Benutzer nicht die erforderliche Rolle prod besitzt.

>testGetAllUrne: Testet den Endpunkt /api/urne, um alle Urnen abzurufen.Überprüft, ob die Antwort den Status 200 OK zurückgibt und ob das JSON-Antwortobjekt die erwarteten Felder und Werte enthält.
>testGetAllUrneWithInhaltsmenge:Testet den Endpunkt /api/urne mit dem Parameter is, um Urnen mit einer bestimmten Inhaltsmenge abzurufen.
Überprüft, ob die Antwort den Status 200 OK zurückgibt und ob das JSON-Antwortobjekt die erwarteten Felder und Werte enthält.

>testGetUrneById: Testet den Endpunkt /api/urne/{id}, um eine spezifische Urne anhand der ID abzurufen.
Überprüft, ob die Antwort den Status 200 OK zurückgibt und ob das JSON-Antwortobjekt die erwarteten Felder und Werte enthält.
>testGetUrneByIdNotFound:Testet den Endpunkt /api/urne/{id}, um sicherzustellen, dass eine 404 Not Found-Antwort zurückgegeben wird, wenn die Urne mit der angegebenen ID nicht existiert.

>testGetUrneStateAggregation: Simuliert einen GET-Request an den Endpunkt /api/urne/aggregation/state. Überprüft, ob die Antwort den Status 200 OK zurückgibt. Überprüft die Struktur und die Werte der zurückgegebenen JSON-Daten.

>testDeleteUrneByIdForbidden: Testet den Endpunkt /api/urne/{id}, um sicherzustellen, dass eine Löschanfrage abgelehnt wird, wenn der Benutzer nicht die erforderliche Rolle hat, die Urne nicht im Status AVAILABLE ist oder die E-Mail-Adresse nicht übereinstimmt. Überprüft, ob die Antwort den Status 403 Forbidden zurückgibt.

## OrderControllerTest
>testCreateOrder: Simuliert die Erstellung einer Bestellung durch einen authentifizierten Benutzer.
Überprüft, ob die Antwort den Status 201 Created zurückgibt und ob das JSON-Antwortobjekt die erwarteten Felder und Werte enthält.
>testCreateOrderUnauthorized: Simuliert den Versuch, eine Bestellung ohne Authentifizierung zu erstellen.
Überprüft, ob die Antwort den Status 403 FORBIDDEN zurückgibt

>testGetAllOrder: Testet den Endpunkt /api/order, um alle Bestellungen abzurufen.
Überprüft, ob die Antwort den Status 200 OK zurückgibt und ob das JSON-Antwortobjekt die erwarteten Felder und Werte enthält.
>testGetAllOrderByState:Testet den Endpunkt /api/order mit dem Parameter state, um Bestellungen mit einem bestimmten Zustand abzurufen.
Überprüft, ob die Antwort den Status 200 OK zurückgibt und ob das JSON-Antwortobjekt die erwarteten Felder und Werte enthält.

>testGetOrderById: Testet den Endpunkt /api/order/{id}, um eine spezifische Bestellung anhand der ID abzurufen.
Überprüft, ob die Antwort den Status 200 OK zurückgibt und ob das JSON-Antwortobjekt die erwarteten Felder und Werte enthält.
>testGetOrderByIdNotFound: Testet den Endpunkt /api/order/{id}, um sicherzustellen, dass eine 404 Not Found-Antwort zurückgegeben wird, wenn die Bestellung mit der angegebenen ID nicht existiert.

>testGetOrderByUserEmailAndState: Testet den Endpunkt /api/order mit den Parametern userEmail und state, um Bestellungen für einen bestimmten Benutzer und Zustand abzurufen.
Überprüft, ob die Antwort den Status 200 OK zurückgibt und ob das JSON-Antwortobjekt die erwarteten Felder und Werte enthält.

>testGetOrderByUserEmailAndState: Testet den Endpunkt /api/order/byEmailAndStatus, um Bestellungen für eine bestimmte E-Mail-Adresse und einen bestimmten Status abzurufen. Überprüft, ob die Antwort den Status 200 OK zurückgibt und ob das JSON-Antwortobjekt die erwarteten Felder und Werte enthält. Stellt sicher, dass die Bestellung mit der ID "1", den Urnen-IDs "urne1" und "urne2", der E-Mail-Adresse "user@example.com" und dem Status ASSIGNED korrekt zurückgegeben wird.

# Beschreibung der End-to-End Tests 
>Die end to end Tests wurden Manuell umgesetzt
# Erkenntnisse aus der Analyse mit SonarQube
Konsistenz (Consistency): 25 Probleme
Es gibt 25 Fälle, in denen der Code nicht konsistent ist. Dies könnte unterschiedliche Namenskonventionen, Formatierungsprobleme oder uneinheitliche Nutzung von Code-Stilen umfassen.
Intention (Intentionality): 19 Probleme
Es gibt 19 Probleme, bei denen der Code nicht klar ausdrückt, was er tun soll. Dies könnte durch unklare oder nicht aussagekräftige Benennungen oder durch zu komplexe Logik verursacht werden.
Anpassbarkeit (Adaptability): 6 Probleme
Der Code weist 6 Fälle auf, in denen er nicht leicht anpassbar ist. Dies könnte darauf hinweisen, dass der Code schwer zu ändern oder zu erweitern ist.
Verantwortlichkeit (Responsibility): 1 Problem
Es gibt 1 Problem, das die Verantwortung oder den Verantwortungsbereich des Codes betrifft. Dies könnte darauf hinweisen, dass eine Klasse oder Methode zu viel Verantwortung hat.
Software Qualität
Sicherheit (Security): 1 Problem
Ein Sicherheitsproblem wurde identifiziert. Dies ist besonders kritisch, da Sicherheitsprobleme oft zu Sicherheitslücken führen können.
Zuverlässigkeit (Reliability): 24 Probleme
Es gibt 24 Probleme, die die Zuverlässigkeit des Codes betreffen. Dies könnte bedeuten, dass der Code unter bestimmten Bedingungen fehlerhaft funktioniert oder abstürzt.
Wartbarkeit (Maintainability): 42 Probleme
Es wurden 42 Probleme in Bezug auf die Wartbarkeit des Codes festgestellt. Dies bedeutet, dass der Code schwer zu warten oder zu verbessern ist, was zu erhöhten Wartungskosten und -aufwand führen kann.
Schweregrad
Hohe Priorität (High): 11 Probleme
Es gibt 11 Probleme, die als hoch priorisiert eingestuft werden. Diese Probleme sollten sofort behoben werden, da sie gravierende Auswirkungen auf den Code haben können.
Mittlere Priorität (Medium): 33 Probleme
Es wurden 33 mittelpriorisierte Probleme identifiziert. Diese sollten ebenfalls zeitnah behoben werden, um die Qualität des Codes zu verbessern.
Niedrige Priorität (Low): 7 Probleme
Es gibt 7 Probleme mit niedriger Priorität, die langfristig behoben werden können.
Zusammenfassung
Die Analyse zeigt, dass es einige kritische Punkte in deinem Code gibt, insbesondere in Bezug auf Konsistenz, Zuverlässigkeit und Wartbarkeit. Es wird empfohlen, die hoch und mittel priorisierten Probleme zuerst anzugehen, um die allgemeine Codequalität zu verbessern und die Software sicherer und zuverlässiger zu machen.