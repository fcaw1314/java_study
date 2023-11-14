import java.util.Scanner;

public class Text {
    public static void login(){
    int count = 3;
    Scanner scanner = new Scanner(System.in);
    while (count != 0){
        System.out.println("请输入你的密码：");
        String passWord = scanner.nextLine();
        if(passWord.equals("123456")){
            System.out.println("登陆成功！");
            break;
        }else {
            count--;
            System.out.println("你还有 "+count+" 次机会 ！");
        }
    }
    }

    public static void main(String[] args) {
    login();
    }
}
