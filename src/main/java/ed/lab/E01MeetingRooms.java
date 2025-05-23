package ed.lab;

import java.util.*;

public class E01MeetingRooms {

    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        if (meetingIntervals == null || meetingIntervals.isEmpty()) {
            return 0;
        }


        meetingIntervals.sort(Comparator.comparingInt(MeetingInterval::startTime));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (MeetingInterval interval : meetingIntervals) {
            if (!minHeap.isEmpty() && interval.startTime() >= minHeap.peek()) {
                minHeap.poll();
            }

            minHeap.offer(interval.endTime());
        }

        return minHeap.size();
    }
}
