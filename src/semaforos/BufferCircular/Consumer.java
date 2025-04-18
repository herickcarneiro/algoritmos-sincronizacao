package semaforos.BufferCircular;

public class Consumer extends Thread {
    Buffer buffer;
    String value;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            value = buffer.fetch();
        }
    }
}
