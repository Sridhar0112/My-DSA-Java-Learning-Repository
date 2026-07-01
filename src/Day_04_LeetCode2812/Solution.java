package Day_04_LeetCode2812;

import java.util.*;

/*
Problem: Maximum Safeness Factor
You are given a 0-indexed 2D matrix grid of size n x n.
Each cell represents:
- grid[r][c] = 1 → Cell contains a thief
- grid[r][c] = 0 → Empty cell

You start at cell (0, 0).
In one move, you can move to any adjacent cell:
- (r + 1, c)
- (r - 1, c)
- (r, c + 1)
- (r, c - 1)

The destination is:
(n - 1, n - 1)

Safeness Factor:
The safeness factor of a path is defined as:
The minimum Manhattan distance from any cell in the path to any thief.

Manhattan Distance:
For cells (a, b) and (x, y):
distance = |a - x| + |b - y|

Return the maximum possible safeness factor among all paths
from (0, 0) to (n - 1, n - 1).

Example 1:
Input:
grid = [
 [1,0,0],
 [0,0,0],
 [0,0,1]
]

Output:
0

Explanation:

Every path from (0,0) to (2,2) contains thief cells:
(0,0) and (2,2)

Therefore minimum distance = 0.

Example 2:

Input:
grid = [
 [0,0,1],
 [0,0,0],
 [0,0,0]
]

Output:
2

Explanation:
Best path:
(0,0) → (1,0) → (1,1) → (2,1) → (2,2)

Distances from nearest thief:
(0,0) = 2
(1,0) = 3
(1,1) = 2
(2,1) = 3
(2,2) = 2

Minimum distance in this path = 2
Answer = 2

Example 3:
Input:
grid = [
 [0,0,0,1],
 [0,0,0,0],
 [0,0,0,0],
 [1,0,0,0]
]

Output:
2

Explanation:
The best path has minimum distance 2 from all thieves.
No other path can achieve a higher safeness factor.

Constraints:
1 <= n <= 400

grid.length == n
grid[i].length == n
grid[i][j] is either 0 or 1

There is at least one thief in the grid.
*/

class Solution {

    int n;
    int[] parent;
    int[] size;
    int[] dr = {1,-1,0,0};
    int[] dc = {0,0,1,-1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        n = grid.size();

        int[][] dist = new int[n][n];

        for(int[] row : dist)
            Arrays.fill(row, -1);


        int[] qr = new int[n*n];
        int[] qc = new int[n*n];

        int front = 0;
        int rear = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    dist[i][j]=0;
                    qr[rear]=i;
                    qc[rear]=j;
                    rear++;
                }
            }
        }

        while(front < rear){
            int r = qr[front];
            int c = qc[front];
            front++;

            for(int k=0;k<4;k++){
                int nr=r+dr[k];
                int nc=c+dc[k];

                if(nr>=0 && nc>=0 &&
                        nr<n && nc<n &&
                        dist[nr][nc]==-1){
                    dist[nr][nc]=dist[r][c]+1;
                    qr[rear]=nr;
                    qc[rear]=nc;
                    rear++;
                }
            }
        }
        ArrayList<int[]>[] buckets = new ArrayList[2*n];
        for(int i=0;i<2*n;i++)
            buckets[i]=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                buckets[dist[i][j]].add(new int[]{i,j});
            }
        }
        parent = new int[n*n];
        size = new int[n*n];
        for(int i=0;i<n*n;i++){
            parent[i]=i;
            size[i]=1;
        }

        boolean[][] active = new boolean[n][n];
        for(int safe=2*n-2; safe>=0; safe--){
            for(int[] cell : buckets[safe]){
                int r=cell[0];
                int c=cell[1];
                active[r][c]=true;
                for(int k=0;k<4;k++){
                    int nr=r+dr[k];
                    int nc=c+dc[k];
                    if(nr>=0 && nc>=0 &&
                            nr<n && nc<n &&
                            active[nr][nc]){
                        union(
                                r*n+c,
                                nr*n+nc
                        );
                    }
                }
            }
            if(active[0][0] && active[n-1][n-1] &&
                    find(0)==find(n*n-1)){
                return safe;
            }
        }
        return 0;
    }

    int find(int x){
        if(parent[x]!=x)
            parent[x]=find(parent[x]);
        return parent[x];
    }

    void union(int a,int b){
        int pa=find(a);
        int pb=find(b);
        if(pa==pb)
            return;
        if(size[pa]<size[pb]){
            parent[pa]=pb;
            size[pb]+=size[pa];
        }else{
            parent[pb]=pa;
            size[pa]+=size[pb];
        }
    }
}
