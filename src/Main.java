import threaad.start.HelloThread;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+" : main() start");
        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName()+"helloThread start 전");
        helloThread.start();
        System.out.println(Thread.currentThread().getName()+"helloThread start 후");

        System.out.println(Thread.currentThread().getName()+" : main() end");
    }
}