import java.util.Arrays;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author: 派大星
 * @date: 2024/1/26  10:50
 */
public class Test {
    public static void move(char pos1,char pos2){
        System.out.print(pos1 + " => " + pos2 + " ");
    }
/**
 * @param n: 盘子数目
 * @param pos1:起始位置
 * @param pos2:中转位置
 * @param pos3:目的地位置
 * @return void
 * @author yxb
 * @description TODO
 * @date 2024/1/26 11:08
 */
    public static void hanio(int n , char pos1 ,char pos2 , char pos3){
        if(n == 1){
            move(pos1,pos3);
            return;
        }
        hanio(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanio(n-1,pos2,pos1,pos3);
    }

    public static void main(String[] args) {
        hanio(1,'A','B','C');
        System.out.println();
        hanio(2,'A','B','C');
        System.out.println();
        hanio(3,'A','B','C');
        System.out.println();
        int[] array = { 1 , 2 , 3 };
        System.out.println(Arrays.toString(array));
    }
}
