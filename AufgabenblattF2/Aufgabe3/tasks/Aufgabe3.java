import java.text.DecimalFormat;
import java.util.Arrays;

/*
    Aufgabe3) Eindimensionales Array

    Implementieren Sie folgende statische Methoden:

      - 'createArray' gibt ein neues Array zurück, dessen Länge gleich dem Argument der Methode ist. Das Array
        enthält Zufallszahlen größer oder gleich 0.0 und kleiner 100.0 (des diesen Literalen entsprechenden Typs).
        Zur Erzeugung von Zufallszahlen können Sie Math.random() verwenden:
        http://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#random

      - 'printArray' hat zwei Parameter, gibt aber kein Ergebnis zurück. Der erste Parameter A ist ein Array, das z.B.
        durch 'createArray' erzeugt wurde. Der zweite Parameter N ist eine ganze Zahl mit N > 0. 'printArray' zerlegt
        den Wertebereich [0.0, 100.0) in N gleich große Teilbereiche (z.B. für N gleich 4 in [0.0, 25.0), [25.0, 50.0),
        [50.0, 75.0) und [75.0, 100.0) ) und zählt die Zahlen im Array A, die in jeden dieser Wertebereiche fallen.
        Schließlich gibt 'printArray' für jeden dieser Teilbereiche eine Zeile aus, welche die Anzahl der Zahlen im
        entsprechenden Teilbereich enthält. Beispielsweise gibt 'printArray' für ein A der Länge 5 mit den Zahlen
        10.0, 60.0, 20.0, 80.0 und 70.0 und N gleich 4 folgende Zeilen aus:

            2
            0
            2
            1

        Hinweise: Verwenden Sie zum Zählen der Zahlen in den Teilbereichen am besten ein weiteres Array. Am einfachsten
        ist es, die Zuordnung einer Zahl zu einem Teilbereich in die Berechnung des Indexes für dieses Array einzubauen.
        A und N dienen zur Beschreibung der Methode. In Ihrer Implementierung können die Parameter anders heißen.

      - 'diffArray' hat ein Array (wie von 'createArray' zurückgegeben) als Parameter und gibt nichts zurück. Jeder
        Wert im Array wird durch die positive Differenz zwischen diesem Wert und dem Durchschnittswert aller
        Elemente im Array ersetzt.

    Zusatzfragen:
    1. Warum kann man in 'printArray' for-each-Schleifen (also Schleifen der Form for(... : ...) ...) verwenden,
       in 'createArray' und 'diffArray' aber nicht?
    2. Warum ist es möglich, dass 'diffArray' kein Ergebnis zurückgibt, die Auswirkungen der Methode aber dennoch
       sichtbar werden?
    3. Woran könnte man feststellen, ob die Lösung richtig ist, obwohl jeder Testlauf andere Ergebnisse liefert?
    4. Wie wirken sich wiederholte Anwendungen von 'diffArray' auf die Verteilung der Werte im Array aus
       (entsprechend der Ausgabe von 'printArray')?
*/
public class Aufgabe3 {

    // TODO(partnano): do with for-each

    // create array with random values.
    private static double[] create_array(int n) {
        double[] arr = new double[n];

        // go through array and fill with random numbers between 0.0 and 100.0
        for(int i = 0; i < arr.length; i++)
            arr[i] = Math.random() * 100;

        // debug: print array
        // System.out.println(Arrays.toString(arr));

        return arr;

    }

    // prints categorized array
    private static void print_array(double[] arr, int N) {

        // is n bigger 0?
        if(N < 0) {
            System.out.println("N smaller 1 !");
        } else // if yes, go on
        {

            double diff = 100.0 / N;    // section size
            double x = 0;               // section sum
            int count = 0;              // section amount

            // add sections until maximum of range is reached.
            for (; x < 100.1 - diff; x += diff)
                count++;

            // create sections array
            int[] sections = new int[count];

            // go through array, check in which section the number goes and add to it
            int sec_num = 0;
            for (double i: arr) {
                sec_num = (int) (i / diff);
                sections[sec_num]++;
            }

            // debug
            // System.out.println("Sec size: " + diff + ", Diff * Secs: " + x + ", Sec amount: " + count);
            // System.out.println(Arrays.toString(sections));

            // printer with section info (cut decimals for readability)
            DecimalFormat df = new DecimalFormat("#.##");
            for (int i = 0; i < sections.length; i++) {
                System.out.println(sections[i]
                        + " [" + df.format(i*diff) + " - "
                        + df.format((i+1)*diff) + "]");
            }
        }
    }

    private static void diff_array(double[] arr) {
        int sum = 0;

        // calculate sum of all array values
        for(int i = 0; i < arr.length; i++)
            sum += arr[i];

        // calculate average
        int avg = sum / arr.length;

        // rewrite every value with absolute difference of arrayelement - average
        for(int i = 0; i < arr.length; i++)
            arr[i] = Math.abs(arr[i] - avg);

        // debug
        // System.out.println(avg + ", " + Arrays.toString(arr));
    }

    public static void main(String[] args) {

        double[] ran = create_array(10);

        print_array(ran, 3);
        diff_array(ran);
    }
}
