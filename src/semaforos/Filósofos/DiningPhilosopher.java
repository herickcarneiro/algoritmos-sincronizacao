package semaforos.Filósofos;

import java.util.Scanner;

public class DiningPhilosopher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int np = scanner.nextInt();
        Table table = new Table(np);
        for (int i = 0; i < np; i++) {
            new Philosofer(table, i).start();
        }
    }
}
