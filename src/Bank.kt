import java.util.concurrent.Executor
import kotlin.math.log
import kotlin.math.round
//fun zweiDezimalStellenrunden(input: Double):Double{
    //val inputGerundetString: String = "2.%f".format(input)
   // val inputGerundet: Double = inputGerundetString.replace(',','.').toDouble()
    //return inputGerundet
//} geht nicht.
val bankMap: MutableMap<String,Double> = mutableMapOf(//Aufgabe 1
    "Klaus" to 200.30,
    "Siegfried" to 100000.00,
    "Friedrich" to 34553.00,
    "Konstantin" to 452223.00,
    "Kevin" to 647.33
)//Aufgabe 1
fun aktuellerBeitragKonto(konto: String): Double? {//Aufgabe 2
    if (konto in bankMap) {
        println("Der Benutzer $konto besitzt ${bankMap[konto]}€")
        return bankMap[konto]
    }else {
        println("Der Benutzer $konto ist nicht in unserer Bank.")
        println("Bitte gib ein vorhandenes Konto ein")
        return aktuellerBeitragKonto(konto= readln())//falls falsche Eingabe wird nochmal abgefragt.
        //throw Exception("Der Benutzer $konto ist nicht in unserer Bank.")//ein else der ein Exception als Rückgabewert throwt !
    }
}//Aufgabe 2
fun kontoHinzufügen(kontoInhaberNeu: String,kontoStandNeu: Double){//Aufgabe 3

    if (kontoInhaberNeu in bankMap){
        println("Das Konto kann nicht hinzugefügt werden,es ist bereits in unserer Datenbank")
    }else{
        bankMap[kontoInhaberNeu]=kontoStandNeu
        println("Das Konto $kontoInhaberNeu mit dem Betrag:$kontoStandNeu wurde hinzugefügt.Das ist die neue bankMap")
        println(bankMap)
    }
}//Aufgabe 3
fun kontoLöschen(kontoName: String){//Aufgabe 4
    println("Möchtest du Konto $kontoName entfernen?JA/NEIN")
    var input: String= readln().uppercase()
    if (input=="JA"&&kontoName in bankMap){
        bankMap.remove(kontoName)
        println("Du hast Konto $kontoName entfernt.Hier ist die aktuelle BankMap")
        println(bankMap)
    }else if (kontoName !in bankMap){
        println("Das Konto existiert nicht")
    }
    else{
       println("Du hast Konto $kontoName nicht entfernt.")
    }
}//Aufgabe 4
fun auszahlungSimulation(kontoName: String, geldAuszahlung: Double) {//Aufgabe 5
    if (kontoName in bankMap) {
        println("Der Benutzer $kontoName besitzt ${bankMap.getValue(kontoName)}€")
        println("möchtest du den Betrag: $geldAuszahlung€ abheben?JA/NEIN")
    } else {
        println("Der Benutzer ist nicht in unserer Bank")
    }
    val input: String = readln().uppercase()
    if (input == "JA" && bankMap.getValue(kontoName) >= geldAuszahlung && geldAuszahlung <= 500.00) {
        println("Der Betrag $geldAuszahlung€ wird von Konto $kontoName entfernt...")
        var aktuellerKontostand: Double = bankMap.getValue(kontoName)
        var reduzierterKontostand: Double = aktuellerKontostand - geldAuszahlung
        bankMap[kontoName] = reduzierterKontostand
        println("reduzierter Kontostand von $kontoName beträgt ${bankMap[kontoName]}€")
    } else if (input == "NEIN"){
        println("Sie haben abgebrochen")
    } else if (bankMap.getValue(kontoName) < geldAuszahlung) {
        println("Der Betrag wurde nicht abgehoben, weil nicht genug Geld auf dem Konto existiert.")
    } else if (geldAuszahlung >= 500.00) {// bei 500€ abheben wenn ich nein drücke kommt die meldung anstannt die untere
        println("Es kann maximal 500€ pro Tag abgehoben werden.")
    } else {
        println("Sie haben abgebrochen")//bei 499€ geld abheben nein drück kommt richgig sie haben abgebrochen.
    }
}//Aufgabe 5
fun einzahlungSimulation(kontoName: String,geldEinzahlung: Double){//Aufgabe 6
    val input: String
    if(kontoName in bankMap){
        println("Der Benutzer $kontoName besitzt noch ${bankMap.getValue(kontoName)}€")
        println("Möchtest du Geld einzahlen,$geldEinzahlung€?JA/NEIN")
    }else{
        println("Das Konto $kontoName ist nicht in unserer Bank")
        println("Das Konto $kontoName wird angelegt...")
        bankMap[kontoName]=0.00
        println("Hier ist die aktualisierte bankMap: $bankMap")
        println("Möchtest du Geld einzahlen,die $geldEinzahlung€? JA/NEIN")
    }
    input= readln().uppercase()
    if (input=="JA") {
        println("Es werden $geldEinzahlung€ auf das Konto $kontoName eingezahlt...")
        var alterKontostand: Double = bankMap.getValue(kontoName)
        var neuerKontostand: Double = alterKontostand+geldEinzahlung
        bankMap[kontoName]=neuerKontostand
        println("Auf dem Konto $kontoName sind ${bankMap[kontoName]}€.")
        println("Aktualisierte bankMap: $bankMap")
    }else{
        println("Der Vorgang wurde abgebrochen.")
    }
    }//Aufgabe 6
fun überweisungSimulation(kontoSender: String,kontoEmpfänger: String,geldÜberweisung: Double){//Aufgabe 7
    val input: String
    if (kontoSender in bankMap&&kontoEmpfänger in bankMap&&bankMap.getValue(kontoSender)>=geldÜberweisung){
        println("Das Überweisende Konto $kontoSender besitzt genug Geld ${bankMap.getValue(kontoSender)}€.")
        println("Möchtest du $geldÜberweisung€ auf das Konto $kontoEmpfänger üerweisen?JA/NEIN")
    }else if(kontoSender !in bankMap){
        println("Das Konto $kontoSender existiert nicht.")
    }else if (kontoEmpfänger !in bankMap){
        println("Das Konto $kontoSender existiert nicht.")

    }else if (bankMap.getValue(kontoSender)<=geldÜberweisung){
        println("Es existiert nicht genug Geld auf dem Konto...")
        print("Auf dem Konto sind noch ${bankMap.getValue(kontoSender)}€")
        println("Der Vorgang wurde abgebrochen.")
    }else{
        println("Falche eingabe.")
    }
    input= readln().uppercase()
    if (input=="JA"){
        println("Der Betrag $geldÜberweisung€ wird von Konto $kontoSender auf das Konto $kontoEmpfänger überwiesen")
        var aktuellerKontostandEmpfänger: Double = bankMap.getValue(kontoEmpfänger)
        var neuerKontostandEmpfänger: Double = aktuellerKontostandEmpfänger+geldÜberweisung
        bankMap[kontoEmpfänger]= neuerKontostandEmpfänger
        var aktuellerKontostandSender: Double = bankMap.getValue(kontoSender)
        var neuerKontostandSender: Double = aktuellerKontostandSender-geldÜberweisung
        bankMap[kontoSender]= neuerKontostandSender
        println("Kontostand des überweisenden Kontos$kontoSender: ${bankMap.getValue(kontoSender)}€ also -$geldÜberweisung€")// also es geht bankMap.getvalue()
        println("Kontostand des empfänger Konto $kontoEmpfänger: ${bankMap[kontoEmpfänger]}€ also +$geldÜberweisung€")// und es geht bankMap[]
        println("aktualisierte bankMap: $bankMap ")
    }else {
        println("Die Überweisung wurde abgebrochen.")
    }
}//Aufgabe 7

var zinsSatz: Double = 1.0
var kontoFuehrungskosten: Double = 0.99
var loggedInUser: String? = null
fun jahresAbschlussBerechnen(konto: String, kontoFuehrungskosten:Double, zinsSatz:Double){//Bonusaufgabe - Jahreszins auszahlen
    //var kontostand: Double = bankMap[konto]?:0.0
    if (konto in bankMap && (bankMap[konto] ?: 0.0) >= kontoFuehrungskosten){
        var kontostandMinusFuehrungskosten: Double = bankMap.getValue(konto)-kontoFuehrungskosten
        println("Zuerst werden die Kontoführungskosten $kontoFuehrungskosten€ von Konto $konto ${bankMap.getValue(konto)}€ abgezogen")
        bankMap[konto]=kontostandMinusFuehrungskosten//kontostand minus 0,99€
        println("Das Konto $konto hat den Kontostand: ${bankMap[konto]}€")
        println("Der Zinssatz beträgt $zinsSatz%")
        var jahresabschlussZinsen: Double = kontostandMinusFuehrungskosten*(zinsSatz/100)// wie kann ich 2 nachkommstellen runden ohne mit dem String auf Double umzuwandeln?
        //var jahresabschlussZinsengerundet = zweiDezimalStellenrunden(jahresabschlussZinsen)//geht nicht.ich hab eine eigene FUnktion zum runden erstellt.
        var jahresabschlussZinsengerundetString = "%.2f".format(jahresabschlussZinsen)
        var jahresabschlussZinsengerundet= jahresabschlussZinsengerundetString.replace(',', '.').toDouble()// wegen string %2.f wird auf , umgewandelt. das muss man ersetzen mit . sonst error
        println("Die Zinsen von ${bankMap[konto]}€ * $zinsSatz% sind $jahresabschlussZinsengerundet€ Zinsen")
        var jahresabschlussKontomitZinsen: Double = bankMap.getValue(konto)+jahresabschlussZinsengerundet//plus zinsen
        println("${bankMap.getValue(konto)}€+$jahresabschlussZinsengerundet€=$jahresabschlussKontomitZinsen€")
        bankMap[konto]=jahresabschlussKontomitZinsen//aktualisiertes Konto mit Zinsen
        println("Nach dem Jahresabschluss beträgt das Konto von $konto ${bankMap.getValue(konto)}€")
        println("Die aktualiserte bankMap:$bankMap")
    }
    else if (bankMap.getValue(konto)<=kontoFuehrungskosten){
        bankMap.remove(konto)
        println("Das Konto $konto wurde aufgrund unzureichender Deckung gelöscht.")
        println("Aktuelle bankMap: $bankMap")
    }
    else{
        println("Das Konto $konto existiert nicht.")
    }
}//Bonusaufgabe - Jahreszins auszahlen
fun sparKonto(kontoName: String,geldEinzahlung: Double){//Bonusaufgabe - Sparkonto
    if (kontoName in bankMap){
        println("Der Benutzer ist in unserer Bank es wird ein Sparkonto angelegt")
        println("Es werden auf das Sparkonto $kontoName $geldEinzahlung€ eingezahlt.")
        sparMap[kontoName]=geldEinzahlung
        println(sparMap)
    }else {
        println("Der Benutzer ist nicht in unserer Bank")
    }
}//Bonusaufgabe - Sparkonto
val sparMap: MutableMap<String,Double> = mutableMapOf()//Bonusaufgabe - Sparkonto
fun jahresAbschlussBerechnenSparkonto(kontoName: String, kontoFuehrungskosten:Double, zinsSatz:Double){//Bonusaufgabe - Sparkonto
    if (kontoName in sparMap && (sparMap[kontoName] ?: 0.0) >= kontoFuehrungskosten){
        var kontostandMinusFuehrungskosten: Double = sparMap.getValue(kontoName)-kontoFuehrungskosten
        println("Zuerst werden die Kontoführungskosten $kontoFuehrungskosten€ von Sparkonto $kontoName ${sparMap.getValue(kontoName)}€ abgezogen")
        sparMap[kontoName]=kontostandMinusFuehrungskosten//kontostand minus 0,99€
        println("Das Sparkonto $kontoName hat den Kontostand: ${sparMap[kontoName]}€")
        println("Der Zinssatz beträgt $zinsSatz%")
        var jahresabschlussZinsen: Double = kontostandMinusFuehrungskosten*(zinsSatz/100)// wie kann ich 2 nachkommstellen runden ohne mit dem String auf Double umzuwandeln?
        //var jahresabschlussZinsengerundet = zweiDezimalStellenrunden(jahresabschlussZinsen)//geht nicht.ich hab eine eigene FUnktion zum runden erstellt.
        var jahresabschlussZinsengerundetString = "%.2f".format(jahresabschlussZinsen)
        var jahresabschlussZinsengerundet= jahresabschlussZinsengerundetString.replace(',', '.').toDouble()// wegen string %2.f wird auf , umgewandelt. das muss man ersetzen mit . sonst error
        println("Die Zinsen von ${sparMap[kontoName]}€ * $zinsSatz% sind $jahresabschlussZinsengerundet€ Zinsen")
        var jahresabschlussKontomitZinsen: Double = sparMap.getValue(kontoName)+jahresabschlussZinsengerundet//plus zinsen
        println("${sparMap.getValue(kontoName)}€+$jahresabschlussZinsengerundet€=$jahresabschlussKontomitZinsen€")
        sparMap[kontoName]=jahresabschlussKontomitZinsen//aktualisiertes Konto mit Zinsen
        println("Nach dem Jahresabschluss beträgt das Sparkonto von $kontoName ${sparMap.getValue(kontoName)}€")
        println("Die aktualiserte SparMap:$sparMap")
    }
    else if (sparMap.getValue(kontoName)<=kontoFuehrungskosten){
        sparMap.remove(kontoName)
        println("Das Sparkonto $kontoName wurde aufgrund unzureichender Deckung gelöscht.")
        println("Aktuelle sparMap: $sparMap")
    }
    else{
        println("Das Sparkonto $kontoName existiert nicht.")
    }
    }//Bonusaufgabe - Sparkonto
val accountManagementMap: MutableMap<String,Int> = mutableMapOf(//Bonusaufgabe - Accountmanagement
    "Klaus" to 1234,
    "Siegfried" to 5678,
    "Friedrich" to 91011,
    "Konstantin" to 1213,
    "Kevin" to 1415
)//Bonusaufgabe - Accountmanagement
fun logIn(accountName:String,accountPasswort:Int):Boolean{//Bonusaufgabe - Accountmanagement LogIn
    if(accountPasswort==0){ //Überprüft ob ein Passwort eingeben wurde
        return false
    }
    // Überprüfe, ob bereits ein Benutzer eingeloggt ist
    if (loggedInUser != null) {
        return false // Wenn bereits eingeloggt, kann keine erneute Anmeldung erfolgen
    }
    val savedPasswort: Int =accountManagementMap[accountName]?:0 //ruft das gespeicherte Passwort aus der Map ab
    if (savedPasswort==accountPasswort){//gespeichertes passwort muss mit der eingabe Übereinstimmen
        loggedInUser=accountName
        return true
    }
    return false
}//Bonusaufgabe - Accountmanagement LogIn
fun logOut(){//Bonusaufgabe - Accountmanagement LogOut
    loggedInUser=null
    println("Erfolgreich abgemeldet.")
}//Bonusaufgabe - Accountmanagement LogOut
fun main() { //Aufgabe 8 alle Funktionen zusammen
    var kontoName: String//Benutzereingabe kontoName
    var geldAuszahlung: Double//Benutzereingabe Auszahlungsbetrag
    var accountName: String//Benutzereingabe Account Name
    var accountPasswort: Int//Benutzereingabe Account Passwort


    println("Bitte gib ein Name ein:")//Aufgabe 2
    val konto: String
//try-catch
    try {
        konto = readln()//Benutzereingabe konto
        aktuellerBeitragKonto(konto)
    } catch (e: Exception) {
        println("error")
    }//Aufgabe 2

    //Aufgabe 3
    println("Möchtest du ein Konto hinzufügen?JA/NEIN")//Aufgabe 3
    val input: String
//try-catch
    try {//Aufgabe 3
        input = readln().uppercase()//falls eingabe falsch mit try catch//Benutzereingabe input
        if (input == "JA") { //eingabe ja gleich true
            println("Bitte gib ein neuen Kontoinhaber ein der eingezahlt werden soll: ")
            val kontoInhaberNeu: String = readln()//Benutzereingabe kontoInhaber
            println("Bitte gib ein neuen Kontostand ein der zu $kontoInhaberNeu eingezahlt werden soll: ")
            val kontoStandNeu: Double = readln().toDouble()//Benutzereingabe Kontostand neu
            kontoHinzufügen(kontoInhaberNeu, kontoStandNeu)
        } else {//ansonsten bei nein
            println("Es wird kein Konto hinzugefügt")
        }
    } catch (e: Exception) {
        println("falsche Eingabe")
    }//Aufgabe 3

    //Aufgabe 4
    println("Bitte gib ein Kontoname ein der entfernt werden soll:")//Aufgabe 4
//try-catch
    try {//Aufgabe 4
        kontoName = readln()//Benutzereingabe Konto Name
        kontoLöschen(kontoName)
    } catch (e: Exception) {
        println("Fehler")
    }//Aufgabe 4

    //ab Aufgabe 5 sind meine Funktionen mit vorgegebenen Parametern und nicht mehr eine abfrage in der Main funktion.
//try-catch
    try {//Aufgabe 5
        auszahlungSimulation("Klaus", 50.30)
        auszahlungSimulation("Siegfried", 400.70)
        auszahlungSimulation("Friedrich", 450.00)//Aufgabe 8 5 Testtransaktionen "auszahlen"
        auszahlungSimulation("Konstantin", 20.00)
        auszahlungSimulation("Kevin", 499.00)
    } catch (e: Exception) {
        println("Der Betrag kann nicht abgehoben werden, weil der Benutzer nicht existiert.")
    }//Aufgabe 5
//try-catch
    try {//Aufgabe 6
        einzahlungSimulation("Klaus", 5000.00)
        einzahlungSimulation("Siegfried", 2000000.00)
        einzahlungSimulation("Friedrich", 350000.00)//Aufgabe 8 5 Testtransaktionen "einzahlen"
        einzahlungSimulation("Konstantin", 250000.00)
        einzahlungSimulation("Kevin", 450000.00)
    } catch (e: Exception) {
        println("Error falsche eingabe")
    }//Aufgabe 6
//try-catch
    try {//Aufgabe 7
        überweisungSimulation("Siegfried", "Klaus", 34000.00)
        überweisungSimulation("Friedrich", "Konstantin", 14432.00)//Aufgabe 8 3 Testtransaktionen "überweisen"
        überweisungSimulation("Konstantin", "Friedrich", 14432.00)
    } catch (e: Exception) {
        println("Error falsche eingabe")
    }//Aufgabe 7
//try-catch
    try {//Bonusaufgabe - Jahreszins auszahlen
        jahresAbschlussBerechnen("Klaus",kontoFuehrungskosten, zinsSatz)
        jahresAbschlussBerechnen("Siegfried",kontoFuehrungskosten, zinsSatz)
        jahresAbschlussBerechnen("Friedrich",kontoFuehrungskosten, zinsSatz)
        jahresAbschlussBerechnen("Konstantin",kontoFuehrungskosten, zinsSatz)
        jahresAbschlussBerechnen("Kevin",kontoFuehrungskosten, zinsSatz)
    }catch (e:Exception){
        println("Falsche eingabe")
    }//Bonusaufgabe - Jahreszins auszahlen
//try-catch
    try {//Bonusaufgabe - Sparkonto anlegen
        sparKonto("Klaus",200.0)
    }catch (e:Exception){
        println("Falsche Eingabe")
    }//Bonusaufgabe - Sparkonto anlegen
//try-catch
    try {//Bonusaufgabe - Sparkonto jahresAbschluss
        jahresAbschlussBerechnenSparkonto("Klaus",kontoFuehrungskosten, zinsSatz=3.0)
    }catch (e:Exception){
        println("Falsche Eingabe")
    }//Bonusaufgabe - Sparkonto jahresAbschluss
//try-catch
    try {//Bonusaufgabe - Accountmanagement LogIN
        println("Bitte gib dein Benutzername ein zum Geldabheben:")
        accountName = readln()//Benutzereingabe Account Name
        println("Bitte gib den Pin für $accountName ein:")
        accountPasswort = readln().toInt()//Benutzereingabe Account Passwort
        if (logIn(accountName,accountPasswort)){ //Bonusaufgabe - LogIn
            println("Erfolgreich angemeldet.")
            println("Eingeloggter Benutzer: $loggedInUser")
            try {//Aufgabe 5
                kontoName=accountName
                println("Wie viel möchtest du abheben?Eingabe:")
                geldAuszahlung = readln().toDouble()//Benutzereingabe Auszahlungsbetrag
                println("Es werden gleich $geldAuszahlung€ von Konto $kontoName abgehoben")
                auszahlungSimulation(kontoName, geldAuszahlung)
            } catch (e: Exception) {
                println("Der Betrag kann nicht abgehoben werden, weil der Benutzer nicht existiert.")
            }//Aufgabe 5
            logOut()//Bonusaufgabe - Accountmanagement LogOut
            println("Eingeloggter Benutzer: $loggedInUser")
        }else{
            println("Falsche Pin oder Benutzer existiert nicht.")//kann ich noch mit throw IllegalArgumentException("Passwort darf nicht leer sein") machen
        }
    }catch (e:Exception){
        println("Falsche Eingabe.")
    }//Bonusaufgabe - Accountmanagement
}//Aufgabe 8 alle Funktionen zusammen