package atguigu.senior;

public class BankTest {
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    //方式一：
//    public static Bank getInstance() {
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
//    }

    //方式二：
    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
