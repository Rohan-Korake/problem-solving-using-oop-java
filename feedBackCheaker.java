// Problem Statement: An online food delivery platform receives thousands of customer feedback messages daily. The support team wants a utility that processes each feedback string to: count words, detect if the feedback contains any blacklisted (abusive) words, reverse the message for archival watermarking, and efficiently build a consolidated daily feedback report by appending individual messages — without the performance penalty of repeated String concatenation.
// Write a Java program that:
// Task 1.⁠ ⁠Accepts multiple customer feedback strings.
// Task 2.⁠ ⁠Uses String methods to count words and check for blacklisted keywords.
// Task 3.⁠ ⁠Uses StringBuffer/StringBuilder to efficiently append all feedback into a single daily report and to reverse individual messages.
// Task 4.⁠ ⁠Compares and prints the time taken using String concatenation vs StringBuilder for building the report to reason about efficiency.

import java.io.*;

class feedbackRecord {
    String feedBack = "";
    String[] blackListedSet = { "spam", "scam", "fake", "trash", "horrible", "bad", "dirty", "abuse", "worst" };

    // accept the feedBack
    public void acceptFeedBack(BufferedReader buffer, int feedbackNum) {
        try {
            System.out.print("Enter feedback " + feedbackNum + " here :");
            feedBack = buffer.readLine();
        } catch (Exception e) {
            System.out.println("Invalid input format.");
        }
    }

    // display the feedback length
    public void countFeedBackLength(int i) {
        System.out.println("\nUser Id " + (i + 1) + " Feedback details");
        System.out.println("FeedBack Length : " + feedBack.length());
    }

    // detect the feedback type
    public void checkFeedBack() {
        String lowerFeedBack = feedBack.toLowerCase();
        boolean isGoodFeedback = true;
        for (String blackListWord : blackListedSet) {
            if (lowerFeedBack.contains(blackListWord)) {
                System.out.println("Negative feedback : " + blackListWord);
                isGoodFeedback = false;
            }
        }

        // display feedback type
        if (isGoodFeedback) {
            System.out.println("Positive Feedback :)");
        }
    }

}

public class feedBackCheaker {

    public static void main(String args[]) throws Exception {
        int feedbackCount = 0;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of feedbacks to process : ");
        feedbackCount = Integer.parseInt(buffer.readLine());

        if (feedbackCount < 1) {
            System.out.println("Invalid number! Please enter valid Number..");
            return;
        }

        feedbackRecord[] record = new feedbackRecord[feedbackCount];

        // Task 1: Accept the user feedback
        for (int i = 0; i < feedbackCount; i++) {
            record[i] = new feedbackRecord();
            record[i].acceptFeedBack(buffer, i + 1);
        }

        // Count the feedback length and check the feedBack
        for (int i = 0; i < feedbackCount; i++) {
            record[i].countFeedBackLength(i); // Task 2.1 : Count the feedback length
            record[i].checkFeedBack(); // Task 2.2 : Check the feedBack
        }

        // Task 3.1: Generate the combined report using StringBuffer
        StringBuffer dailyReport = new StringBuffer();

        // combine all feedbackRecord
        for (int i = 0; i < feedbackCount; i++) {
            dailyReport.append("\nUser Id " + (i + 1) + " : ").append(record[i].feedBack);
        }

        // print daily report
        System.out.print("\n------------- Today's Feedback -------------");
        System.out.println(dailyReport.toString());

        // Task 3.2 : Print reverse feedback
        System.out.println("\n------------- Reverse Feedback -------------");
        String[] lines = dailyReport.toString().split("\\r?\\n");

        for (String line : lines) {
            String[] words = line.split("\\s+");
            StringBuilder lineResult = new StringBuilder();

            for (int i = 0; i < words.length; i++) {
                lineResult.append(new StringBuilder(words[i]).reverse());
                if (i < words.length - 1) {
                    lineResult.append(" ");
                }
            }
            System.out.println(lineResult.toString());
        }

        // Task 4.1 : Test using regular string concatenation ( + )
        long startStr = System.currentTimeMillis();
        String reportString = "Report string : \n";
        for (int i = 0; i < feedbackCount; i++) {
            reportString += record[i].feedBack + "\n";
        }
        long endStr = System.currentTimeMillis();
        long timeStr = endStr - startStr;

        // Task 4.2 : measure time using string buffer
        long startBuff = System.currentTimeMillis();
        StringBuffer reportBuffer = new StringBuffer();
        for (int i = 0; i < feedbackCount; i++) {
            reportBuffer.append(record[i].feedBack + "\n");
        }
        long endBuff = System.currentTimeMillis();
        long timeBuff = endBuff - startBuff;

        // Display Comparison
        System.out.println("\n----------- Efficiency Comparison -----------");
        System.out.println("Time taken with String (+) : " + timeStr + " ms");
        System.out.println("Time taken with StringBuffer : " + timeBuff + " ms");
    }
}
