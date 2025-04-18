package semaforos.ProducerConsumer01;

import java.util.concurrent.Semaphore;

public class Buffer {
    Semaphore s;
    String value;

    public Buffer() {
        s = new Semaphore(0);
        value = null;
    }

    public void deposit(String v) {
        value = v;
        s.release();
    }

    public String fetch() throws InterruptedException {
        s.acquire();
        return value;
    }
}
