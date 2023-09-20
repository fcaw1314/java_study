public class HelloWorld {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        byte c = (byte)(a+b);//小于4个字节的在运算的时候，会提升为4个字节

    }

    public static void main13(String[] args) {
        int a = 10;
        long b = 20L;
        int c = (int)(a+b);//a提升为8个字节 然后和b参与运算-》 8个字节的结果
        long d = a+b;

        //b = a;

        /*a = (int)b;//强制类型转换 不一定安全 风险：
        System.out.println(a);
        System.out.println(b);*/

        /*int c = 10;
        float f = 12.5f;
        c = (int)f;*/


    }

    //0是假  非0 既是真 在java中，真只有一个true假 只有一个叫false
    public static void main12(String[] args) {
        //JVM 没有明确他的大小
        boolean flg = true;
        System.out.println(flg);
    }

    public static void main11(String[] args) {
        //字符类型 是2个字节   16bit 不能赋值 负数   Character
        char ch = 'a';
        System.out.println(ch);
        char ch2 = '美';
        System.out.println(ch2);

        char ch3 = 97;
        System.out.println(ch3);
    }

    public static void main10(String[] args) {
        float f = 12.5f;
        System.out.println(f);
    }

    public static void main9(String[] args) {
        //8个
        double d = 12.500;
        System.out.println(d);

        double num = 1.1;
        System.out.println(num*num);
        //小数其实没有精确的 只能说 精确到某一位上

      /*  System.out.printf("%.2f\n",d);
        System.out.printf("%f",d);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        int a = 1;
        int b = 2;
        System.out.println(a/b); ctr+shift+/ */
    }

    public static void main8(String[] args) {
        //1个字节    8个bit  -128        127
        byte a = 127;
        System.out.println(a);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
    }


    // 高高兴兴上课      开开心心写代码
    public static void func(String[] args) {
        //2个字节  16bit  -2^15   2^15 -1
        short sh = -32760;
        System.out.println(sh);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
    }

    public static void main5(String[] args) {
        // 8个字节
        long a = 10L;
        System.out.println(a);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
    }

    public static void main4(String[] args) {
        /*
        1. a是整型变量  此时a占用4个字节【和平台是多少位没有关系】
        16位平台 ？
        32位平台？
        64位平台？
        4个字节-》 32位
        bit  byte  kb   mb   gb  tb  pb
         */
        int a = 10;
        System.out.println(a);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public static void main2(String[] args) {
        //数据类型   变量  = 赋值  变量可以在运行的过程当中 修改的量
        //final int a = 10;
        int a = 10;
        a = 20;
    }
    /*

     */
    //psvm    m    main  回车
    public static void main1(String[] args) {
        //final int a = 10;
        //sout
        System.out.println("helloworld");
    }
}
