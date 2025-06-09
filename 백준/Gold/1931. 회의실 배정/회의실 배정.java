import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static class Meeting implements Comparable<Meeting> {
        private final int startTime;
        private final int entTime;

        public Meeting(final int startTime, final int entTime) {
            this.startTime = startTime;
            this.entTime = entTime;
        }

        public boolean isOverlapping(final Meeting meeting) {
            return meeting.startTime >= entTime;
        }

        @Override
        public int compareTo(final Meeting meeting) {
            if (meeting.entTime == entTime) {
                return Integer.compare(startTime, meeting.startTime);
            }

            return Integer.compare(entTime, meeting.entTime);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            Meeting meeting = new Meeting(startTime, endTime);
            meetings.add(meeting);
        }

        Collections.sort(meetings);

        List<Meeting> answer = new ArrayList<>();
        answer.add(meetings.get(0));
        for (int i = 1; i < meetings.size(); i++) {
            Meeting lastMeeting = answer.get(answer.size() - 1);

            Meeting meeting = meetings.get(i);
            if (lastMeeting.isOverlapping(meeting)) {
                answer.add(meeting);
            }
        }

        System.out.println(answer.size());
    }
}
