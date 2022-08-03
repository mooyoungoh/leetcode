class MyCalendar {

    List<int[]> books;
    
    public MyCalendar() {
        books = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] b : books){
            if(Math.max(b[0], start) < Math.min(b[1], end))
                return false;
        }
        books.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */