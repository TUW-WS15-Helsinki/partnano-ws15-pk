/**********************************************************************************************************************

 AUFGABENBLATT F1 für fortgeschrittene Übungsgruppen - Allgemeine Informationen

 Das Projekt AufgabenblattF1 besteht aus fünf Aufgaben in den Klassen Aufgabe1 bis Aufgabe5, die Sie erweitern und in
 den Übungen vom 16.11. bis 20.11. präsentieren können müssen.

 Achten Sie bei der Implementierung von Aufgabe1-Aufgabe5 auf folgende Punkte:

 - Ihr Programm sollte kompilierbar und ausführbar sein.
 - Testen und kommentieren Sie Ihre Programme ausführlich.
 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich thematisch auf das erstellte Programm.
   Sie müssen diese Zusatzfragen in der Übung beantworten können.

 Abgabe: Die Abgabe erfolgt in TUWEL indem Sie bis Montag, den 16.11.2015 um 06:00 Ihre Kreuzerl des aktuellen
 Aufgabenblattes eintragen. Nur durch Ankreuzen können Sie auch Punkte bekommen. Allerdings müssen Sie
 angekreuzte Aufgaben auch vorzeigen können.

***********************************************************************************************************************/
/*
    Aufgabe1) Mehrfache Rekursion versus einfache Iteration

    Implementieren Sie in Aufgabe1 je eine iterative (iter) und eine rekursive (rec) statische Methode, die für eine
    ganze nicht-negative Zahl n die Zahl L(n) berechnet. L(n) ist definiert durch:

        L(0) = 1
        L(1) = 1
        L(n) = L(n - 1) + L(n - 2) + 1  wenn  n > 1.

    Rufen Sie in main die Methoden iter und rec mit allen Zahlen von 0 bis 50 auf und geben Sie die Ergebnisse aus.
    Ein Programmaufruf soll in weniger als einer Sekunde terminieren.

    Hinweis: Eine simple, nahe an die Definition angelehnte rekursive Implementierung kann sehr ineffizient werden.
    Suchen Sie daher nach einer effizienteren Implementierungsmöglichkeit, die jedoch ohne Schleifen auskommen muss.
    Sie können z.B. Hilfsmethoden (ohne Schleifen) und/oder ein Array verwenden.

    Zusatzfragen:
    1. Welche Vor- und Nachteile hat iter im Vergleich zu rec?
    2. Welcher elementare Typ ist als Ergebnistyp dieser Methoden geeignet? Warum nur dieser?
    3. Welche elementaren Typen sind als Parametertypen geeignet? Warum?
    4. Welche alternativen Implementierungstechniken würde es geben?
       Aufgrund welcher Tatsachen haben Sie die von Ihnen verwendete(n) Implementierungstechnik(en) gewählt?
*/
public class Aufgabe1 {

    private static int m = 50;      // calculation depth

    private static long[] cache_rec = new long[m]; // recursion cache_rec
    private static long[] cache_iter = new long[m+1]; // iteration cache_rec

    // invokes iter as well as rec with all integers from 0 to 50 and prints the results
    // (without empty lines or other output)
    public static void main(String[] args) {
        // start time for calculation
        long start = System.currentTimeMillis();

        // loop for calculation depth
        for(int i = 0; i <= m; i++) {
            System.out.println(iter(i));
            System.out.println(rec(i));
        }

        // termination time in ms
        System.out.println("");
        System.out.println(System.currentTimeMillis()-start + "ms");

    }

    // calculation with iteration
    private static long iter( int n ) {

        // fill indices 0 and 1 with 1 (formula definition)
        cache_iter[0] = 1;
        cache_iter[1] = 1;

        // start loop with i of 2, since we know 0 and 1 already
        for(int i = 2; i <= n; i++) {
            cache_iter[i] = cache_iter[i -2] + cache_iter[i -1] + 1;
        }

        return cache_iter[n];
    }

    // calculation with recursion
    private static long rec( int n) {

        // if n > 1 calculate, else return 1
        if(n > 1) {

            // does a cache entry exist?
            // when not calculate it
            if (cache_rec[n -1] <= 0) {
                cache_rec[n -1] = rec(n - 1);
            }

            // same as above for the second term
            if (cache_rec[n -2] <= 0) {
                cache_rec[n -2] = rec(n - 2);
            }

            // return calculation solely from cache
            return cache_rec[n - 1] + cache_rec[n - 2] + 1;

        } else {
            return 1;
        }
    }

}
