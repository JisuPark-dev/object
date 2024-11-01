package threaad.control.printer;

import java.awt.print.Printable;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class MyPrinter {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            log("프린터할 문서를 입력하세요. 종료 (q): ");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                printer.work = false;
                break;
            }
            printer.addJob(input);
        }
    }
    static class Printer implements Runnable {
        volatile boolean work = true; // 여러 스레드가 동시에 접근할 때,
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();
        @Override
        public void run() {
            while (work) {
                if(jobQueue.isEmpty()) {
                    continue;
                }
                String job = jobQueue.poll();
                log("출력 시작: " + job + ", 대기 문서: " + jobQueue);
                sleep(3000);
                log("출력 완료");
            }
            log("프린터 종료");
        }

        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }
}
