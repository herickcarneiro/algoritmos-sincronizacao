package semaforos.ProducerConsumer02;

public class Consumer extends Thread {
    Buffer buffer;
    String value;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                value = buffer.fetch();
                System.out.println("Consumidor: " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
