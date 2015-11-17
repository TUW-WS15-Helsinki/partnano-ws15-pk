/*
    Aufgabe2) Verschachtelte Schleifen und Rekursion

    - Erweitern Sie die Klasse 'Aufgabe2' um eine statische Methode namens "drawNumDiamondIter(int h)", die einen Diamanten
    (Raute) mit Zahlen iterativ berechnet und ausgibt. Der übergebene Parameter "h" entspricht der Höhe des Diamanten (Raute).
    Ein h=9 führt zu folgender Ausgabe:

        1
       222
      33333
     4444444
    555555555
     4444444
      33333
       222
        1

    Testen Sie Ihre Methode mit weiteren Höhen für "h"! Der Rückgabetyp der Methode ist "void".

    - Implementieren Sie zusätzlich eine Methode "drawNumDiamondRec(int h)", die den Diamanten (Raute) rekursiv generieren
    soll. Sie können für die rekursive Implementierung zusätzliche Methoden anlegen.


    Zusatzfragen:
    1. Wie ist die Vorgangsweise abzuändern, wenn statt jedem Wert 1 der Buchstabe A, statt jedem Wert 2 der
    Buchstabe B, ... und statt jedem Wert 5 der Buchstabe E ausgegeben werden soll ?
    (Die Methode soll dann nur für h <= 17 funktionieren.)

    2. An welchen Stellen ist das Programm zu ändern, wenn Rauten der Form
        1
        2
       333
       444
      55555
       444
       333
        2
        1
    generiert werden sollen ?
    3. Welche Unterschiede konnten Sie zwischen der rekursiven und iterativen Implementierung feststellen?
*/
public class Aufgabe2 {

    // just for testing ...
    public static void main(String[] args) {

        drawNumDiamondIter(10);
        System.out.println("********");
        drawNumDiamondRec(10);

    }

    private static void drawNumDiamondIter(int h) {

        // calculation of the middle of the height and if it's odd / even
        double hd = h;
        boolean odd = hd % 2 == 1;
        int middle = (int) Math.ceil(hd / 2);


        // initialize the printed counter and the loop.
        int c = 0;
        for(int i = 1; i <= h; i++) {

            if(i <= middle) {
                // we are in the top half
                c++;

                // how many whitespace prints? take the cut height middle and
                // subtract the amount of spaces characters will take up
                for(int j = h/2 -c +1; j > 0; j--)
                    System.out.print(" ");

                // print characters, always an odd number, so
                // double the c -1
                for(int j = c*2 -1; j > 0; j--)
                    System.out.print(c);

                System.out.println("");

            } else {
                // we are in the bottom half.
                // same as above, just the other direction.
                // if h is odd, subtract it at the beginning, so we do not get double middle lines
                if(odd)
                    c--;

                for(int j = h/2 -c +1; j > 0; j--)
                    System.out.print(" ");

                for(int j = c*2 -1; j > 0; j--)
                    System.out.print(c);

                // if h is even, subtract at the end, so we do get middle lines
                if(!odd)
                    c--;

                System.out.println("");
            }
        }

    }

    private static void drawNumDiamondRec(int h) {

        // calculation of the middle of the height and if it's odd / even
        double hd = h;
        boolean odd = hd % 2 == 1;
        int middle = (int) Math.ceil(hd / 2);

        actual_recursion(h, middle, odd, 1, 0);

    }

    private static void char_recursion(int j, String a) {
        if(j > 0) {

            j--;
            System.out.print(a);

            char_recursion(j, a);

        }
    }

    private static void actual_recursion(int h, int middle, boolean odd, int c, int i) {
        if(h > i) {

            // how many whitespace prints? take the cut height middle and
            // subtract the amount of spaces characters will take up
            char_recursion(h/2 -c +1, " ");

            // print characters, always an odd number, so
            // double the c -1
            char_recursion(c*2 -1, "" + c);

            // finish line
            System.out.println("");
            i++;

            // in the top half, add to c
            // in the middle (if even) don't add or subtract
            // in the bottom half subtract
            if(i < middle) {
                c++;
                actual_recursion(h, middle, odd, c, i);
            } else if (!odd && i == middle) {
                actual_recursion(h, middle, odd, c, i);
            } else {
                c--;
                actual_recursion(h, middle, odd, c, i);
            }

        }
    }
}

