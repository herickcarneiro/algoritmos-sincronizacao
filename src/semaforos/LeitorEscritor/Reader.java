package semaforos.LeitorEscritor;

public class Reader extends Thread {
    Buffer buffer;
    String value;

    public Reader(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            value = buffer.fetch();
        }
    }
}
