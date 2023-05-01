# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class addTwoNumbers:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode()
        ptr = head
        p1 = l1
        p2 = l2
        add_one = 0
        while p1 or p2 or add_one == 1:
          p1_val = 0 if not p1 else p1.val
          p2_val = 0 if not p2 else p2.val
          curr_digit = p1_val + p2_val + add_one
          add_one = 0 #reset the carry
          if curr_digit > 9:
            add_one = 1
            curr_digit -= 10
          newNode = ListNode(curr_digit)
          ptr.next = newNode
          p1 = p1.next if p1 else None
          p2 = p2.next if p2 else None
          ptr = ptr.next

        return head.next
