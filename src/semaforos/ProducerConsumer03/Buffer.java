package semaforos.ProducerConsumer03;

import java.util.concurrent.Semaphore;

public class Buffer {
    String[] buffer;
    int outBuf, inBuf, size;
    Semaphore empty, full, mutexp, mutexc;

    public Buffer(int n) {
        size = n;
        full = new Semaphore(0);
        empty = new Semaphore(n);
        mutexp = new Semaphore(1);
        mutexc = new Semaphore(1);
        outBuf = 0;
        inBuf = 0;
        buffer = new String[size];
        for (int i = 0; i < size; i++) {
            buffer[i] = null;
        }
    }

    public void deposit(String value) {
        try {
            empty.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mutexp.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buffer[inBuf] = value;
        inBuf = (inBuf + 1) % size;
        mutexp.release();
        full.release();
    }

    public String fetch() {
        try {
            full.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mutexc.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String v = buffer[outBuf];
        outBuf = (outBuf + 1) % size;
        mutexc.release();
        empty.release();
        return v;
    }
}
