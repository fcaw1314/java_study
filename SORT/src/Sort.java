import java.util.Stack;

/**
 * @ProjectName: SORT
 * @Package: PACKAGE_NAME
 * @ClassName: Sort
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/11 20:14
 * @Version: 1.0
 */
public class Sort {

    //插入排序
    public static void insertSort(int[] Array) {
        for (int i = 1; i < Array.length; i++) {
            int j = i - 1;
            int tmp = Array[i];
            for (; j >= 0; j--) {
                if (tmp < Array[j]) {
                    Array[j + 1] = Array[j];
                } else {
                    break;
                }
            }
            Array[j + 1] = tmp;
        }
    }

    public static void shellSort(int[] Array) {
        int gap = Array.length;
        while (gap > 1) {
            gap /= 2;
            shell(gap, Array);
        }
    }

    //希尔排序
    public static void shell(int gap, int[] Array) {
        for (int i = gap; i < Array.length; i++) {
            int j = i - gap;
            int tmp = Array[i];
            for (; j >= 0; j -= gap) {
                if (tmp < Array[j]) {
                    Array[j + gap] = Array[j];
                } else {
                    break;
                }
            }
            Array[j + gap] = tmp;
        }
    }

    //选择排序
    public static void selectSort(int[] Array) {
        for (int i = 0; i < Array.length; i++) {
            int minIndex = i;
            int j = i + 1;
            for (; j < Array.length; j++) {
                if (Array[j] < Array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(Array, i, minIndex);
        }
    }

    public static void swap(int[] Array, int i, int j) {
        int tmp = Array[i];
        Array[i] = Array[j];
        Array[j] = tmp;
    }

    public static void selectSort2(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = left;
            for (int i = left + 1; i <= right; i++) {
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            swap(array, minIndex, left);
            if (maxIndex == left) {
                maxIndex = minIndex;
            }
            swap(array, maxIndex, right);
            left++;
            right--;
        }
    }

    //堆排序
    public static void heapSort(int[] array) {
        //创建大根堆
        createHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            swap(array, 0, end);
            siftDown(array, 0, end);
            end--;
        }
    }

    private static void createHeap(int[] array) {
        for (int parent = (array.length - 1 - 1) / 2; parent > 0; parent--) {
            siftDown(array, parent, array.length);
        }
    }

    private static void siftDown(int[] array, int parent, int len) {
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array, parent, child);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    //快速排序
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    private static void quick(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(array, start, end);
        quick(array, start, pivot - 1);
        quick(array, pivot + 1, end);
    }

    private static int partition(int[] array, int left, int right) {
        int tmp = array[left];
        while (left < right) {
            while (left < right && array[right] >= tmp) {
                right--;
            }
            if (left >= right) {
                break;
            }
            array[left] = array[right];
            while (left < right && array[left] <= tmp) {
                left++;
            }
            if (left >= right) {
                break;
            }
            array[right] = array[left];
        }
        array[left] = tmp;
        return left;
    }

    //快速排序非递归实现
    public static void quickSortNor(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int pivot = partition(array, left, right);
        Stack<Integer> stack = new Stack<>();
        if (pivot - 1 > left) {
            stack.push(left);
            stack.push(pivot - 1);
        }
        if (pivot + 1 < right) {
            stack.push(pivot + 1);
            stack.push(right);
        }
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            pivot = partition(array, left, right);

            if (pivot - 1 > left) {
                stack.push(left);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < right) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }

    public static void mergeSort(int[] array) {

    }

    private static void mergeFunc(){

    }
}