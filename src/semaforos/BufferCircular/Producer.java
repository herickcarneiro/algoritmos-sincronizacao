package semaforos.BufferCircular;

public class Producer extends Thread {
    Buffer buffer;
    String value;

    public Producer(Buffer buffer, String value) {
        this.buffer = buffer;
        this.value = value;
    }

    public void run() {
        int i = 0;
        while (true) {
            try {
                buffer.deposit(value + String.valueOf(i++));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
