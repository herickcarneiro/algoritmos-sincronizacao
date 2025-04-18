package semaforos.ProducerConsumer02;

import java.util.concurrent.Semaphore;

public class Buffer {
    Semaphore s1, s2;
    String value;

    public Buffer() {
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
        value = null;
    }

    public void deposit(String v) {
        try {
            s1.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = v;
        s2.release();
    }

    public String fetch() throws InterruptedException {
        try {
            s2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String valor = value;
        s1.release();
        return valor;
    }
}
