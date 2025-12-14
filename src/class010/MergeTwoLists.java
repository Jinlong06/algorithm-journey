package class010;

// 将两个升序链表合并为一个新的 升序 链表并返回
// 新链表是通过拼接给定的两个链表的所有节点组成的
// 测试链接 : https://leetcode.cn/problems/merge-two-sorted-lists/
public class MergeTwoLists {

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

		public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
			// 1. 处理空链表情况
		    if (head1 == null || head2 == null) {
		        return head1 == null ? head2 : head1;
		    }
		    
		    // 2. 确定合并后的头节点（取两个头节点中较小的）
		    ListNode head = head1.val <= head2.val ? head1 : head2;
		    
		    // 3. 初始化指针
		    ListNode cur1 = head.next;           // 头节点所在链表的剩余部分
		    ListNode cur2 = (head == head1) ? head2 : head1; // 另一个链表
		    ListNode pre = head;                // 已合并部分的尾节点，起始值设为初始化已确认的head节点
		    
		    // 4. 双指针迭代合并
		    while (cur1 != null && cur2 != null) {
		        if (cur1.val <= cur2.val) {
		            pre.next = cur1;    // 将cur1节点链接到结果链表
		            cur1 = cur1.next;   // cur1指针后移
		        } else {
		            pre.next = cur2;    // 将cur2节点链接到结果链表
		            cur2 = cur2.next;   // cur2指针后移
		        }
		        pre = pre.next;         // 尾指针后移
		    }
		    
		    // 5. 处理剩余部分
		    pre.next = (cur1 != null) ? cur1 : cur2;
		    
		    return head;
	}

}
