from collections import deque
# thoughts: unpack the nearest 2 nums to the operator
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        num_stack = []
        for t in tokens:
            if t.isdigit() or t[1:].isdigit():
                num_stack.append(int(t))
            else:
                var_snd = num_stack.pop()
                var_fst = num_stack.pop()
                match t:
                    case '+':
                        num_stack.append(var_fst + var_snd)
                    case '-':
                        num_stack.append(var_fst - var_snd)
                    case '*':
                        num_stack.append(var_fst * var_snd)
                    case '/':
                        num_stack.append(int(var_fst / var_snd))
        return num_stack.pop()

    def evalRPN_lambda(self, tokens: List[str]) -> int:

        operations = {
            "+": lambda a, b: a + b,
            "-": lambda a, b: a - b,
            "/": lambda a, b: int(a / b),
            "*": lambda a, b: a * b
        }

        stack = []
        for token in tokens:
            if token in operations:
                number_2 = stack.pop()
                number_1 = stack.pop()
                operation = operations[token]
                stack.append(operation(number_1, number_2))
            else:
                stack.append(int(token))
        return stack.pop()
