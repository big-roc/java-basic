package atguigu.senior;

public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring.toString());
    }
}

//自定义枚举类
enum Season1 {
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象用";"结束
    SPRING("春天", "春暖花开"),

    SUMMER("夏天", "夏日炎炎"),

    AUTUMN("秋天", "秋高气爽"),

    WINTER("冬天", "冰天雪地");


    //2.声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}