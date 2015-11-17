/*
    Aufgabe4) Rekursion und Termination

    Die Methoden f, g, h, p und q sind vorgegeben. Rufen Sie in main jede dieser Methoden mit allen Argumenten im
    Bereich von -100 bis 100 (in aufsteigender Reihenfolge) auf und geben sie die Ergebnisse aus, wenn die Aufrufe mit
    Argumenten terminieren. Aufrufe, die nicht terminieren oder einen Überlauf produzieren, sind auszulassen.
    Vermeiden Sie Exceptions.

    Hinweis: Für diese Aufgabe ist es besonders wichtig, die Zusatzfragen beantworten zu können.

    Zusatzfragen:
    1. Nennen Sie für jeden nicht terminierenden Aufruf von f, g, h, p und q einen Grund für die Endlosrekursion
       (im Hinblick auf Fundiertheit und Fortschritt).
    2. Beschreiben Sie überblicksartig, was die Methoden f, g, h, p und q berechnen.
    3. Bedeutet ein StackOverflowError immer, dass eine Endlosrekursion vorhanden ist?
    4. Bedeutet kein StackOverflowError immer, dass ein richtiges Ergebnis geliefert wird?
    5. [optional] Ist die Aufgabe überhaupt lösbar (wegen der Unentscheidbarkeit des Halteproblems der Turing-Maschine)?
*/
public class Aufgabe4 {

    private static int f(int x) {
        return x * x == 100 ? 0 : f(x - 3) + 1;
    }

    private static int g(int x) {
        return x <= -100 ? 0 : g(x / 2 - 2) + 1;
    }

    private static int h(int x) {
        return x == 100 ? 0 : h(x * x + 19) + 1;
    }

    private static int p(int x) {
        return x == 0 ? 0 : x % 2 == 1 ? p(x / 2) + 2 : p(- x - 1) + 1;
    }

    private static int q(int x) {
        return x % 11 == 0 ? 0 : q(x * 2) + 1;
    }

    // to be implemented by you
    public static void main(String[] args) {

        for(int i = -100; i <= 100; i++) {

            // i has to be at least 10 and has to contain (i - 10) a multiple of 3
            if(i == 10 || (i >= 10 && (i - 10) % 3 == 0)) {
                //System.out.println(f(i));
            }

            // can only terminate on -100
            if(i == -100) {
                //System.out.println(g(i));
            }

            // only if 100 or +/- 9
            if(i == 100 || Math.abs(i) == 9) {
                //System.out.println(h(i));
            }

            // only powers of 2 in the negative range
            // only powers of 2 -1 in the positive range
            // and 0
            if (i >= 0 && i <= 6) {
//                System.out.println(p(-((int)Math.pow(2, i))));
//                System.out.println(p(((int)Math.pow(2, i)) - 1));
            }

            // always terminates.
            System.out.println(q(i));

        }

    }
}
