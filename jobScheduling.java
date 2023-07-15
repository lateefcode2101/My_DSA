import java.util.Arrays;

//public class jobScheduling {
//    public static void main(String[] args) {
//        int n = 5; // Number of processors
//        int m = 11; // Number of jobs
//        int k = 2; // Index of the most efficient processor
//
//        int[] schedule = scheduleJobs(n, m, k);
//        System.out.println("Balanced schedule: " + Arrays.toString(schedule));
//    }
//
//    public static int[] scheduleJobs(int n, int m, int k) {
//        int[] schedule = new int[n];
//        int jobsPerProcessor = m / n; // Number of jobs per processor
//        int extraJobs = m % n; // Extra jobs to be distributed
//
//        // Assign jobs to processors
//        for (int i = 0; i < n; i++) {
//            if (i < extraJobs) {
//                schedule[i] = jobsPerProcessor + 1;
//            } else {
//                schedule[i] = jobsPerProcessor;
//            }
//        }
//
//        // Rearrange processors to make kth processor the most efficient one
//        int temp = schedule[0];
//        schedule[0] = schedule[k - 1];
//        schedule[k - 1] = temp;
//
//        return schedule;
//    }
//}
public class jobScheduling {
    public static void main(String[] args) {
        int n = 5; // Number of processors
        int m = 12; // Number of jobs
        int k = 5; // Index of the most efficient processor

        int maxJobs = getMaxJobsForProcessor(n, m, k);
        System.out.println("Maximum jobs on processor " + k + ": " + maxJobs);
        int[] schedule = scheduleJobs(n, m, k);
        System.out.println("Balanced schedule: " + Arrays.toString(schedule));

    }

    public static int getMaxJobsForProcessor(int n, int m, int k) {
        int baseJobsPerProcessor = m / n;
        int extraJobs = m % n;

        if (extraJobs >= k) {
            return baseJobsPerProcessor + 1;
        } else {
            return baseJobsPerProcessor;
        }
    }

        public static int[] scheduleJobs(int n, int m, int k) {
        int[] schedule = new int[n];
        int jobsPerProcessor = m / n; // Number of jobs per processor
        int extraJobs = m % n; // Extra jobs to be distributed

        // Assign jobs to processors
        for (int i = 0; i < n; i++) {
            if (i < extraJobs) {
                schedule[i] = jobsPerProcessor + 1;
            } else {
                schedule[i] = jobsPerProcessor;
            }
        }

        // Rearrange processors to make kth processor the most efficient one
        int temp = schedule[0];
        schedule[0] = schedule[k - 1];
        schedule[k - 1] = temp;

        return schedule;
    }

}


