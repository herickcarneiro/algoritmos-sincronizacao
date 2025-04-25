package monitores.ProcuderConsumer02;

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
            buffer.deposit(value + String.valueOf(i));
        }
    }
}
