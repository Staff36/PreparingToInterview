package task1;


public class PingPongWriter {
    private String currentWord = "Ping";
    private final int numberOfWrites;
    private int count = 0;

    public PingPongWriter(int numberOfWrites) {
        this.numberOfWrites = numberOfWrites;
    }

    public void displayTheLetter(String threadsWord, String nextWord, Object lock) {
        synchronized (lock) {
            while (count < numberOfWrites - 1) {
                while (!currentWord.equals(threadsWord)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(currentWord);
                currentWord = nextWord;
                lock.notifyAll();
                count++;
            }
        }
    }
}
