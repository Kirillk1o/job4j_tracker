package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByName()));
        System.out.println(jobs);
        Comparator<Job> comb = new JobDescByNameLn()
                .thenComparing(new JobDescByName())
                .thenComparing(new JobDescByPriority())
                .thenComparing(new JobAscByPriority())
                .thenComparing(new JobAscByName());
        Collections.sort(jobs, comb);
    }
}
