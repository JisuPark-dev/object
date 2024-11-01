package threaad.start;

public class HelloRunnableMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+" : main() start");
        Runnable r = new HelloRunnable();
        Thread t = new Thread(r);
        System.out.println(Thread.currentThread().getName()+"helloThread start 전");
        t.start();
        System.out.println(Thread.currentThread().getName()+"helloThread start 후");

        System.out.println(Thread.currentThread().getName()+" : main() end");
    }
}
