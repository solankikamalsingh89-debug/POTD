"""
With iteration check for such sequence and add traversal index with that itself, but to prevent not counting of equal numbers at boundary(where few countrd in previous one)-always check before starting if equal elements exist as well to count

TC - O(n), SC - O(1)
"""

class Solution:
	def bitonic(self,arr):
	    ans=1
		i=0
		n=len(arr)
		while i<n-ans:
		    cur=1
		    j=i
		    while j>0 and arr[j]==arr[j-1]: 
		        cur+=1
		        j-=1
		    while i<n-1 and arr[i+1]>=arr[i]: 
		        i+=1
		        cur+=1
		    while i<n-1 and arr[i+1]<=arr[i]: 
		        i+=1
		        cur+=1
		    ans=max(ans,cur)
	    return ans