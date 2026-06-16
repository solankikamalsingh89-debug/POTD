"""
Just did as mentioned: Using list as string are mutable(But on LC using string gave lesser runtime-I think may be because of small constraint(len(str)<=20))
Better method: processStr1(Deque + reverse flag + List)
"""

from collections import deque

class Solution:
    def processStr(self, s: str) -> str:
        res=[]
        for i in s:
            if i =='*':
                if res: res.pop()
            elif i=='#':
                res.extend(res)
            elif i=='%':
                res.reverse()
            else:
                res.append(i)
        return "".join(res)
    
    def processStr1(s: str) -> str:
        dq = deque()
        rev = False
        for ch in s:
            if ch == '%':
                rev = not rev                        # O(1) — just flip flag
            elif ch == '#':
                dq.extend(list(dq))                  # O(n) — unavoidable
            elif ch == '*':
                if dq:
                    if rev: dq.popleft()             # O(1)
                    else:   dq.pop()                 # O(1)
            else:  # lowercase letter
                if rev: dq.appendleft(ch)            # O(1)
                else:   dq.append(ch)                # O(1)
        # Final output: respect the rev flag
        return ''.join(reversed(dq)) if rev else ''.join(dq)