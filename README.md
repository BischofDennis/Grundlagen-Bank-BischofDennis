<h1 align="center">Grundlagen der Programmierung</h1>
<h3 align="center">Bank</h3>
<br>

### Beschreibung
In dieser Aufgabe geht es darum, eine Bank-Software zu entwickeln. Die Software soll folgende Funktionen haben:
- Hinzufügen von Kundenkonten
- Löschen von Kundenkonten
- Einzahlen von Geld auf Kundenkonten
- Abheben von Geld von Kundenkonten
- Überweisen von Geld zwischen Kundenkonten

> #### Hinweise zur Bearbeitung
> - Achte darauf, dass dein Quellcode sauber ist. Besonders die Einrückungen sind wichtig!
> - Verwende Dokumentationskommentare, um deinen Code zu erklären und zu dokumentieren.
> - Teste deinen Code. Er sollte nicht nur kompilieren und ausführbar sein, sondern auch das gewünschte Ergebnis liefern.
> - `Commit & Push` dein Ergebnis am Ende des Tages
<br>

<details>
<summary><b>Aufgabe 1 - Die Bank initialisieren</b></summary>

Erstelle eine globale Konstante (außerhalb der main()-Funktion) vom Typ MutableMap<String, Double>. Diese MutableMap soll alle Konten in der Bank repräsentieren. Jedes Konto setzt sich aus dem Namen des Kontoinhabers und dem Kontostand zusammen. Verwende den Namen des Kontoinhabers als Schlüssel (Key) und den Kontostand als Wert (Value). Lege mindestens fünf verschiedene Konten in dieser MutableMap an. Du kannst die Namen der Kontoinhaber und ihre Kontostände frei wählen.

</details>

 --- 

<details>
<summary><b>Aufgabe 2 - Kontostand Abfragen</b></summary>


- Schreibe eine Funktion, die den aktuellen Betrag eines Kontos zurückgibt.
- Nutze einen Parameter, um der Funktion zu sagen, wessen Kontostand zurückgegeben werden soll. 
Wenn es das Konto in unserer Bank nicht gibt, soll eine entsprechende Meldung in der Konsole ausgegeben werden! 
Der Rückgabewert der Funktion sollte der aktuelle Kontostand sein.

</details>

---

<details>
<summary><b>Aufgabe 3 - Konto hinzufügen</b></summary>


- Schreibe eine Funktion, die ein neues Konto zur Bank hinzufügt. 
Diese Funktion sollte sowohl den neuen Kontoinhaber, als auch den Kontostand als Parameter erhalten.
- Wenn ein Konto mit dem neuen Namen bereits existiert, sollte das alte Konto nicht überschrieben werden.
Überlegt euch also eine Lösung für dieses Problem. 
Zeige dem Benutzer an, ob das neue Konto erfolgreich angelegt wurde (D.h. gib eine entsprechende Nachricht in der Konsole aus.).

</details>

--- 

<details>
<summary><b>Aufgabe 4 - Konto löschen</b></summary>


- Schreibe eine Funktion, die ein bestehendes Konto entfernt. 
Nutze als Parameter einen Namen, um ein bestimmtes Konto auszuwählen. 
Dieses soll aus der Map mit unseren Konten entfernt werden.
- Überprüfe zuerst, ob ein Konto mit dem angegebenen Namen existiert.
Gibt es das Konto nicht, soll eine Meldung in der Konsole ausgegeben werden.
- Zeige dem Benutzer an, ob das Konto erfolgreich gelöscht wurde.

</details>

---

<details>
<summary><b>Aufgabe 5 - Auszahlung</b></summary>


- Schreibe eine Funktion, die eine Auszahlung am Geldautomaten simuliert. 
Nutze einen Parameter, um das richtige Konto auszuwählen und einen weiteren für den Geldbetrag, der ausgezahlt werden soll.
- Berechne dann den neuen Kontostand und speichert ihn auf dem Konto ab.
- Überprüfe zuerst, ob ein Konto mit dem angegebenen Namen existiert. 
Gibt es das Konto nicht, soll eine Meldung in der Konsole ausgegeben werden.
- Überprüfe ebenfalls, ob das Konto über einen ausreichenden Kontostand verfügt, um den Geldbetrag auszahlen zu können. 
Schreibe die Funktion so, dass maximal 500 Euro pro Transaktion abgehoben werden können. 
Wenn die Transaktion mehr als 500 Euro beträgt, soll eine Meldung ausgegeben und die Transaktion abgebrochen werden.

</details>

--- 

<details>
<summary><b>Aufgabe 6 - Einzahlung</b></summary>


- Schreibe eine Funktion, die eine Einzahlung am Geldautomaten simuliert. 
Nutze einen Parameter, um das richtige Konto auszuwählen und einen weiteren für den Geldbetrag, der eingezahlt werden soll.
- Berechne den neuen Kontostand und speicher ihn in dem Konto ab. 
- Existiert das Konto nicht, soll ein neues Konto angelegt werden. 
In diesem Fall teile es dem Nutzer des Programms mit, dass ein neues Konto angelegt wurde. 
Der Kontostand des neuen Kontos ist der Geldbetrag, der eingezahlt werden sollte.

</details>

--- 

<details>
<summary><b>Aufgabe 7 - Überweisung</b></summary>


- Schreibe eine Funktion, die eine Überweisung simuliert. Diese Funktion besitzt 3 Parameter:
  - Das überweisende Konto
  - Das Konto auf welches überwiesen werden soll
  - Der zu überweisende Betrag 
- Stelle vorher sicher, dass die beiden Konten existieren und genügend Geld beim Überweiser vorliegt. 
Berechne die neuen Kontostände der beiden Konten und speicher die neuen Kontostände in den entsprechenden Konten in der MutableMap ab.

</details>

 --- 

<details>
<summary><b>Aufgabe 8 - Test deiner Bank-Funktionen</b></summary>


- Nachdem du nun alle Funktionen erstellt hast, ist die Bank Software grundsätzlich startklar.  
Bis jetzt wurde aber die Funktionalität noch nicht getestet.
- Formuliere deshalb innerhalb der main()-Funktion ein Testprogramm.
- Dieses Testprogramm sollte folgende Funktionalitäten deiner Bank austesten:
  - Kontostand eines bestehenden Kontos ausgeben.
  - Fehlermeldung, wenn versucht wird, den Kontostand eines nicht existierenden Kontos auszugeben.
  - Ein neues Konto erstellen.
  - Fehlermeldung, wenn versucht wird, ein neues Konto zu erstellen, obwohl der Name bereits vergeben ist.
  - Ein bestehendes Konto löschen.
  - Fehlermeldung, wenn versucht wird, ein nicht existierendes Konto zu löschen.
  - Mindestens 10 Test-Transaktionen am Geldautomaten (ein- und auszahlen).
    Teste möglichst viele verschiedene Szenarien.
  - Mindestens 3 Test-Überweisungen. Gebe nach jeder Überweisung die entsprechenden
    Kontostände der beteiligten Konten aus.

</details>
  

---

<details>
<summary><b>Bonusaufgabe - Jahreszins auszahlen</b></summary>


- Speichere zunächst in globalen Variablen den Zinssatz (z.B. 1%) und die Kontoführungskosten (z.B. 0.99 €) unserer Bank ab.
- Schreibe nun eine Funktion, die für ein gegebenes Konto den Jahresabschluss berechnet. 
D.h. explizit, dass zuerst die Kontoführungskosten abgezogen werden, und danach der Kontostand um den Zinssatz der Bank erhöht wird.
- Prüfe wie bereits zuvor, ob das angegebene Konto überhaupt existiert. 
Sollte ein Kunde nicht genügend Geld haben, um die Kosten zu zahlen, wird sein Konto geschlossen. 
D.h. das Konto wird aus der MutableMap gelöscht und es wird eine Nachricht in der Konsole ausgegeben.

</details>

 --- 

<details>
<summary><b>Bonusaufgabe - Ideen zum Ausbau des Projekts</b></summary>


Dieses Projekt soll dir als Inspiration für zusätzliche Übungsaufgaben dienen. Anstelle von Bonusaufgaben gibt es Vorschläge für weitere Funktionen, die du freiwillig in das Projekt integrieren kannst.

- Sparkontos: Implementiere eine 2. Art von Konto. 
Dieses Konto erlaubt den Kunden zwar nicht, Geld abzuheben, aber dafür erhalten sie am Jahresende einen größeren Zins auf ihr Erspartes.
- Benutzereingaben: Programmiere an verschiedenen Schnittpunkten der Bank, die Möglichkeit via *readln()` Eingaben zu machen: Account Name, Account Passwort, initialer Kontostand, Ein- oder Auszahlungsbetrag, Überweisungsempfänger und -betrag, etc..
  Stelle mithilfe von _try-catch_ sicher, dass fehlerhafte Eingaben nicht das Programm zum Abstürzen bringen.
- Accountmanagement: Implementiere eine MutableMap, in der du Accountdaten speichern kannst (also Benutzername und Passwort). Dann kannst du innerhalb deiner Main-Funktion immer zuerst einen Login starten. 
Implementiere dafür also die 2 Funktionen `logIn()` und `logOut()`.
  
 </details>

 --- 
