package semaforos.Filósofos;

public class Philosofer extends Thread {
    int id;
    Table table;

    public Philosofer(Table table, int id) {
        this.table = table;
        this.id = id;
    }

    public void run() {
        while (true) {
            /* thinking */
            try {
                sleep(100);
            } catch (Exception e) {
            }
            ;
            /* hungry */
            table.acquire(id);
            /* eating */
            try {
                sleep(200);
            } catch (Exception e) {
            }
            ;
            table.release(id);
        }
    }
}
