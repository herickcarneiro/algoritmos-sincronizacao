package monitores.ProcuderConsumer02;

public class Buffer {
    String value;
    boolean empty;

    public Buffer() {
        this.value = null;
        this.empty = true;
    }

    public synchronized void deposit(String v) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        value = v;
        empty = false;
        notify();
    }

    public synchronized String fetch() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notify();
        return value;
    }
}
