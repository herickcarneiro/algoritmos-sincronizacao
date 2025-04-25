package semaforos.LeitorEscritor;

public class Writer extends Thread {
    Buffer buffer;
    String value;

    public Writer(Buffer buffer, String value) {
        this.buffer = buffer;
        this.value = value;
    }

    public void run() {
        while (true) {
            buffer.deposit(value);
        }
    }
}
