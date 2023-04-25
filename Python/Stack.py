'''
Define a Stack class

initialization: takes a list of numbers that u wanna put into the stack (e.g. [4, 2, 52] -> [4, 2, 52])


define a method that gets u the top of the stack

define a method that pops an elem off the stack
'''
from typing import List, Optional

class Stack:
    stack: List[int]

    def __init__(self, nums: List[int]):
        self.stack = nums

    def peek(self) -> Optional[int]:
        if not self.stack:
            return None
        return self.stack[-1]

    def pop(self) -> Optional[int]:
        if not self.stack:
            return None
        return self.stack.pop()

test_stack = Stack([])

test_stack.pop()
print(test_stack.stack)
print(test_stack.peek())
