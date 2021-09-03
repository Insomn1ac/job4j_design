package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        List<String> time = new ArrayList<>();
        boolean downtime = false;
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = read.readLine()) != null) {
                if ((line.startsWith("400") || line.startsWith("500")) && !downtime) {
                    downtime = true;
                    time.add(line.split("\\s")[1]);
                }
                if ((line.startsWith("200") || line.startsWith("300")) && downtime) {
                    downtime = false;
                    time.add(line.split("\\s")[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            int i = 0;
            for (String t : time) {
                if (i == 0) {
                    out.print(t + ";");
                    i++;
                } else if (i == 1) {
                    out.println(t + ";");
                    i = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis a = new Analysis();
        a.unavailable("./src/main/resources/server.log", "./src/main/resources/unavailable.csv");
    }
}
