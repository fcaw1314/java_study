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
        for (int parent = (array.length - 1 - 1) / 2; parent >= 0; parent--) {
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
        mergeFunc(array, 0, array.length - 1);
    }

    private static void mergeFunc(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeFunc(array, left, mid);
        mergeFunc(array, mid + 1, right);
        //左边分解完，右边分解完，开始合并
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = right;
        int[] tmpArr = new int[right - left + 1];
        int k = 0;

        //保证两个表都有数据
        while (s1 <= e1 && s2 <= e2) {
            if (array[s1] <= array[s2]) {
                tmpArr[k++] = array[s1++];
            } else {
                tmpArr[k++] = array[s2++];
            }
        }
        //看那个数组还有数据拷贝回去
        while (s1 <= e1) {
            tmpArr[k++] = array[s1++];
        }
        while (s2 <= e2) {
            tmpArr[k++] = array[s2++];
        }

        for (int i = 0; i < k; i++) {
            array[left + i] = tmpArr[i];
        }
    }

    /**
     * @description 非递归实现归并排序
     * SORT
     * @date 2024/5/15 14:44:39
     */
    public static void mergeSortNor(int[] array) {
        int gap = 1;
        while (gap < array.length) {
            for (int i = 0; i < array.length; i = i + 2 * gap) {
                int left = i;
                int mid = left + gap - 1;
                if (mid >= array.length) {
                    mid = array.length - 1;
                }
                int right = mid + gap;
                if (right >= array.length) {
                    right = array.length - 1;
                }
                merge(array, left, mid, right);
            }

            gap *= 2;
        }
    }

    public static void countSort(int[] array) {
        //求最值
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        //定义计数数组
        int[] count = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - min;
            count[index]++;
        }

        //遍历数组
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                array[k] = i+min;
                k++;
                count[i]--;
            }
        }
    }
}









