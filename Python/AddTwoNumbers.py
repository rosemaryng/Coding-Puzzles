# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        # let's do the math first
        # num_one = []
        # num_two = []
        # ptr = l1
        # while ptr:
        #     num_one.insert(0, ptr.val)
        # ptr = l2
        # while ptr:
        #     num_two.insert(0, ptr.val)

        sum = ListNode()
        ptr = sum
        prev_ptr = None
        p1 = l1
        p2 = l2
        add_one = 0
        while l1 or l2:
            curr_digit = p1.val + p2.val + add_one
            if curr_digit > 9:
                add_one = True
                curr_digit -= 10
            ptr.val = curr_digit
            ptr.next = ListNode()
            ptr = ptr.next
            add_one = 0




