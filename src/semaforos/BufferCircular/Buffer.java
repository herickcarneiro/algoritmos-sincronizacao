package semaforos.BufferCircular;

import java.util.concurrent.Semaphore;

public class Buffer {
    String[] buffer;
    int outBuf, inBuf, size;
    Semaphore empty, full;

    public Buffer(int n) {
        size = n;
        full = new Semaphore(0);
        empty = new Semaphore(n);
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
        buffer[inBuf] = value;
        inBuf = (inBuf + 1) % size;
        full.release();
    }

    public String fetch() {
        try {
            full.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String v = buffer[outBuf];
        outBuf = (outBuf + 1) % size;
        empty.release();
        return v;
    }
}
