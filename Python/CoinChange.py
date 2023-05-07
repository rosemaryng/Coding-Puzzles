from functools import lru_cache
# Top down with memoisation
def coinChange(self, coins: List[int], amount: int) -> int:
        @lru_cache(None)
        def dfs(rem) -> int:
            if rem < 0:
                return -1
            if rem == 0:
                return 0
            min_cost = float('inf')
            for coin in coins:
                res = dfs(rem - coin)
                if res != -1:
                    min_cost = min(min_cost, res + 1)
            return int(min_cost) if min_cost != float('inf') else -1
        return dfs(amount)

# bottom-up
def coinChange_dynamic(self, coins: List[int], amount: int) -> int:
    # assuming the smallest coin is 1, so e.g. if amount is 12, max coins is 12
    coin_list = [amount + 1] * (amount + 1) # [amount + 1, ..., amount + 1]
    coin_list[0] = 0 # takes 0 coin to make up 0
    for coin in coins:
        for x in range(coin, amount + 1):
            coin_list[x] = min(coin_list[x], coin_list[x - coin] + 1)
    return coin_list[amount] if coin_list[amount] != amount + 1 else -1
