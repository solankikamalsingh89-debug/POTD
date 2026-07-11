"""
Doing it manually by creating adjacent list(BFS) or by reaching max dist each step to destination leads to TLE

Binary Lifting - Works as Lowest Common Ancestor
Make a sorted copy of nums(nlogn) and also a array to know index of element in nums(pos[index in nums]=index in sorted copy)
Similar to part1 of this question- 1 array for grouping(comp) to knoww whether path exist or not
Now precompute from each position, if steps taken (1,2,4,..2^(no. of bit in n)), where will it reach in sorted array-- (nlogn)
Now for each query start from highest step to coming down until it's greater than bigger element -- (logn)

TC - O(nlogn), SC - O(n)
"""

class Solution:
    def pathExistenceQueries(self, n: int, nums: List[int], maxDiff: int, queries: List[List[int]]) -> List[int]:
        arr = [(nums[i], i) for i in range(n)]
        arr.sort(key=lambda x: x[0])
        sv = [a for a, _ in arr]
        si = [i for _, i in arr]
        pos = [0] * n
        for j in range(n):
            pos[si[j]] = j
        comp = [0] * n
        for i in range(1, n):
            comp[i] = comp[i - 1] + (1 if sv[i] - sv[i - 1] > maxDiff else 0)
        r = [0] * n
        j = 0
        for i in range(n):
            while j < n and sv[j] - sv[i] <= maxDiff:
                j += 1
            r[i] = j - 1
        L = n.bit_length()
        f = [r[:]]
        for p in range(1, L):
            fp = [0] * n
            for i in range(n):
                fp[i] = f[p - 1][f[p - 1][i]]
            f.append(fp)
        def jump(a, b):
            if sv[b] - sv[a] <= maxDiff:
                return 1
            steps, cur = 0, a
            for p in range(L - 1, -1, -1):
                if f[p][cur] < b:
                    cur = f[p][cur]
                    steps += 1 << p
            return steps + 1 if f[0][cur] >= b else -1
        res = []
        for u, v in queries:
            if u == v:
                res.append(0)
                continue
            a, b = pos[u], pos[v]
            if a > b:
                a, b = b, a
            if comp[a] != comp[b]:
                res.append(-1)
            else:
                res.append(jump(a, b))
        return res