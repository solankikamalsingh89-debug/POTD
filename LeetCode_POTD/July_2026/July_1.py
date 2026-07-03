"""
FIrst we created a queue with all theives and then iterate with BFS of multiple sources increasing 1 distance from previous and marking it in grid(Representing max minimum distance from theives)
Now as we have grid showing distance - Iterate from (0,0) to others keeping maximum distance iteration first

TC - O(n^2*log(n^2)){As used priority queue}, SC - O(n^2)
"""

DIR4 = [(0, 1), (0, -1), (1, 0), (-1, 0)]
class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        ROW, COL = len(grid), len(grid[0])
        values = [[0] * COL for _ in range(ROW)]
        queue = deque()
        visited = [[False] * COL for _ in range(ROW)]
        for r in range(ROW):
            for c in range(COL):
                if grid[r][c] == 1:
                    queue.append((r, c))
                    visited[r][c] = True

        while queue:
            len_ = len(queue)
            for _ in range(len_):
                curRow, curCol = queue.popleft()
                for dr, dc in DIR4:
                    newRow, newCol = curRow + dr, curCol + dc
                    if 0 <= newRow < ROW and 0 <= newCol < COL and not visited[newRow][newCol]:
                        values[newRow][newCol] = values[curRow][curCol] + 1
                        visited[newRow][newCol] = True
                        queue.append((newRow, newCol))

        pq = [(-values[0][0], 0, 0)]  # (safety, row, col)
        dist = [[0] * COL for _ in range(ROW)]
        dist[0][0] = values[0][0]
        while pq:
            safety, curRow, curCol = heappop(pq)
            safety = -safety
            if curRow == ROW - 1 and curCol == COL - 1:
                return safety
            for dr, dc in DIR4:
                newRow, newCol = curRow + dr, curCol + dc
                if 0 <= newRow < ROW and 0 <= newCol < COL:
                    newSafety = min(safety, values[newRow][newCol])
                    if newSafety > dist[newRow][newCol]:
                        dist[newRow][newCol] = newSafety
                        heappush(pq, (-newSafety, newRow, newCol))
        return 0