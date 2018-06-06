/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;

/**
 *
 * @author Reyes Ruiz
 */
public class TimingInfo {

    private String algorithm;
    private long millis;
    private int minLength;
    private String targetFile;

    public TimingInfo(String algorithm, long millis, int minLength, String targetFile) {
        this.algorithm = algorithm;
        this.millis = millis;
        this.minLength = minLength;
        this.targetFile = targetFile;
    }

    /**
     * Build a single TimingInfo with time equal to the average of the times of
     * the passed list
     *
     * Assumes that all times in the list have same algorithm, minLength and
     * targetFile
     *
     * @param times
     * @return
     */
    public static TimingInfo buildAverage(List<TimingInfo> times) {
        if (times.isEmpty()) {
            return null;
        }

        int n = 0;
        long currentAvg = 0;
        for (TimingInfo time : times) {
            currentAvg = (currentAvg * n++) + time.getMillis();
            currentAvg /= n;
        }

        TimingInfo ti = new TimingInfo(times.get(0).algorithm, currentAvg, times.get(0).minLength, times.get(0).getTargetFile());
        return ti;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public long getMillis() {
        return millis;
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public String getTargetFile() {
        return targetFile;
    }

    public void setTargetFile(String targetFile) {
        this.targetFile = targetFile;
    }

    @Override
    public String toString() {
        return "(" + algorithm + ", " + millis + "ms)";
    }

}
