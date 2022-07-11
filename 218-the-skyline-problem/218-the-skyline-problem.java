class Solution {
    
    public class Point{
        int x;
        int y;
        boolean start;
        public Point(int x, int y, boolean start){
            this.x = x;
            this.y = y;
            this.start = start;
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<Point> list = new ArrayList<>();
        
        for(int[] b : buildings){
            list.add(new Point(b[0], b[2], true));
            list.add(new Point(b[1], b[2], false));
        }
        
        Collections.sort(list, (a,b) ->{
            if(a.x!=b.x){
                return a.x-b.x;
            }else if(a.start && !b.start){
                return -1;
            }else if(!a.start && b.start){
                return 1;
            }else if(a.start && b.start){
                return b.y - a.y;
            }else{
                return a.y - b.y;
            }
            
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, (a,b) -> b-a);
        
        pq.offer(0);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(Point p : list){
            int max = pq.peek();
            if(p.start){
                pq.offer(p.y);
            }else{
                pq.remove(p.y);
            }
            
            if(max != pq.peek()){
                List<Integer> tmp = new ArrayList();
                tmp.add(p.x);
                tmp.add(pq.peek());
                ans.add(tmp);
            }
            
        }
        
        return ans;
    }
}