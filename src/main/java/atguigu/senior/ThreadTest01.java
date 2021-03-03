package atguigu.senior;

class MyThread01 implements Runnable {
    public MyThread01() {
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}


public class ThreadTest01 {
    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();
        Thread thread = new Thread(myThread01);
        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
