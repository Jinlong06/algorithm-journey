package class012;

// 给你一个链表的头节点 head 和一个特定值 x
// 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
// 你应当 保留 两个分区中每个节点的初始相对位置
// 测试链接 : https://leetcode.cn/problems/partition-list/
public class PartitionList {

	// 不要提交这个类
	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	class Solution {

		public static ListNode partition(ListNode head, int x) {
			ListNode leftHead = null, leftTail = null; // < x的区域
			ListNode rightHead = null, rightTail = null; // >=x的区域
			ListNode next = null; // 用于原来链表的指针走向
			while (head != null) {
				next = head.next;
				// 切断next指针，即指向null，是将当前元素独立出来，因为还有head指针指向，所以并非僵尸节点，不会被jvm给回收
				head.next = null; 
				if (head.val < x) {
					if (leftHead == null) {
						leftHead = head;
					} else {
						leftTail.next = head;
					}
					leftTail = head;
				} else {
					if (rightHead == null) {
						rightHead = head;
					} else {
						rightTail.next = head;
					}
					rightTail = head;
				}
				head = next;
			}
			if (leftHead == null) {
				return rightHead;
			}
			// < x的区域有内容！这个语句包含了两种场景，一种是右侧区域有值，一种是右侧区域没有值。
			// 当右侧大于x的区域为null时，用leftTail.next指向null
			// 作为尾结点的指向也是正确的操作
			leftTail.next = rightHead;
			return leftHead;
		}

	}

}
