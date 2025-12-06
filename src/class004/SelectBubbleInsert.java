package class004;

public class SelectBubbleInsert {

	// 数组中交换i和j位置的数
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// 选择排序
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 思路： 在0-N-1范围内，两两比较,将最小的放在i位置
        // 外层划定了每次循环比较的起始位置或结束位置。选择排序是每次终点位置固定，起始位置在变。
		for (int minIndex, i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}

	// 冒泡排序
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 思路: 每次循环，最后一个位置都是最大值，过程中两两比较
        // 外层划定了每次循环比较的起始位置或结束位置。冒泡排序是每次起始位置固定，终止位置在变。
		for (int end = arr.length - 1; end > 0; end--) {
			for (int i = 0; i < end; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}

	// 插入排序
	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 思路: 每次循环，0~N-1默认已经有序，新数在i位置，向左进行比较
        // 外层划定了每次循环比较的起始位置或结束位置。插入排序是终止起始位置固定，起始位置在变。
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j, j + 1);
			}
		}
	}

}
