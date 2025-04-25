package semaforos.Filósofos;

import java.util.concurrent.Semaphore;

public class Table {
    Semaphore[] fork;
    Semaphore mutex;
    int seats;

    public Table(int s) {
        this.seats = s;
        fork = new Semaphore[s];
        for (int i = 0; i < s; i++) {
            fork[i] = new Semaphore(1);
        }
        mutex = new Semaphore(1);
    }

    public void acquire(int id) {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            fork[id].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            fork[(id + 1) % seats].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mutex.release();
    }

    public void release(int id) {
        fork[id].release();
        fork[(id + 1) % seats].release();
    }
}
