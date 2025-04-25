package semaforos.LeitorEscritor;

import java.util.concurrent.Semaphore;

public class Buffer {
    Semaphore mutex, wlock, queue;
    int numReaders;
    String buffer;

    public Buffer(String buffer) {
        this.buffer = buffer;
        mutex = new Semaphore(1);
        queue = new Semaphore(1);
        wlock = new Semaphore(1);
        numReaders = 0;
    }

    public void deposit(String v) {
        try {
            queue.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            wlock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queue.release();
        this.buffer = v;
        wlock.release();
    }

    public String fetch() {
        String v;
        try {
            queue.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        numReaders++;
        if (numReaders == 1) {
            try {
                wlock.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mutex.release();
        queue.release();
        v = this.buffer;
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        numReaders--;
        if (numReaders == 0)
            wlock.release();
        mutex.release();
        return v;
    }
}
