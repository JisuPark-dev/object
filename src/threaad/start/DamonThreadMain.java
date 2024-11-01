package threaad.start;

public class DamonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "main start");
        DamonThread damonThread = new DamonThread();
        damonThread.setDaemon(true);
        damonThread.start();
        System.out.println(Thread.currentThread().getName() + "main end");
    }

    static class DamonThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run() start");
            try {
                Thread.sleep(10000);
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": run() end");


        }
    }
}
