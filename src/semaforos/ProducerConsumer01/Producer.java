package semaforos.ProducerConsumer01;

public class Producer extends Thread {
    Buffer buffer;
    String value;

    public Producer(Buffer buffer, String value) {
        this.buffer = buffer;
        this.value = value;
    }

    public void run() {
        buffer.deposit(value);
    }
}
