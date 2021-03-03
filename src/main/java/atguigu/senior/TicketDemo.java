package atguigu.senior;

class Ticket implements Runnable {
    private int tick = 100;

    public void run() {
        while (true) {
            if (tick > 0) {
                System.out.println(Thread.currentThread().getName() + "售出车票，tick号为：" + tick--);
            } else break;
        }
    }
}

public class TicketDemo {
    public static void main(String[] args) {
        Ticket t = new Ticket();

        Thread thread01 = new Thread(t);
        Thread thread02 = new Thread(t);
        Thread thread03 = new Thread(t);

        thread01.setName("窗口1");
        thread02.setName("窗口2");
        thread03.setName("窗口3");

        thread01.start();
        thread02.start();
        thread03.start();
    }
}
