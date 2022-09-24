package Arrays.Advance_Array3;

import java.util.ArrayList;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }

public class Merge_intervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<>();
        int n = intervals.size();
        int i=0;
        while(i<n && intervals.get(i).end<newInterval.start){
            ans.add(intervals.get(i));
            i++;
        }
        while(i<n && intervals.get(i).start<=newInterval.end){
            newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
            i++;
        }
        ans.add(newInterval);
        while(i<n){
            ans.add(intervals.get(i));
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        Interval newInterval = new Interval(4,9);
        System.out.println(new Merge_intervals().insert(intervals, newInterval));
    }
}
