import java.util.Arrays;

/**
 * @ProjectName: SORT
 * @Package: PACKAGE_NAME
 * @ClassName: Test
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/12 9:46
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] array = {10,9,8,7,6,5,4,3,2,1,454,55,98,8888};
       //Sort.insertSort(array);
        //Sort.shellSort(array);
        //Sort.selectSort2(array);
        Sort.quickSortNor(array);
        System.out.println(Arrays.toString(array));

    }
}