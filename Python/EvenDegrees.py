# Condition: can add at most 2 edges 
# https://leetcode.com/discuss/interview-question/2492212/Hudson-River-Trading

graph = [[False, True, True, True],
        [True, False, True, False],
        [True, True, False, True],
        [True, False, True, False]]

# graph1 = [[False, True, True, False],
#         [True, False, True, False],
#         [True, False, False, True],
#         [True, False, True, False]]

graph2 = [[False, True, False, False],
        [True, False, True, False],
        [False, True, False, True],
        [False, False, True, False]]

graph3 = [[False, True, False, False],
        [True, False, False, False],
        [False, False, False, True],
        [False, False, True, False]]

def can_graph_be_even(graph):
    degrees = []
    for row in graph:
        degree = 0
        for item in row:
            degree = degree + 1 if item else degree
        degrees.append(degree)

    print(degrees) # return something like [1, 2, 2, 1]

    odd = 0 # number of odd degrees
    even = 0 # number of odd degrees

    for i in degrees:
        if i % 2 == 0:
            even = even + 1
        else:
            odd = odd + 1

    print('even: ', even)
    print('odd: ', odd)
    if odd == 0:
        return True
    elif odd == 2 or odd == 4:
        return max(degrees) < len(graph[0]) - 1

    return False

print('answer: ', can_graph_be_even(graph3))