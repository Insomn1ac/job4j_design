package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> answers = readPhrases();
        List<String> logs = new ArrayList<>();
        boolean active = true;
        boolean dialogue = true;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        while (active) {
            String userMessage = sc.nextLine();
            if (OUT.equalsIgnoreCase(userMessage)) {
                active = false;
                dialogue = false;
                logs.add(userMessage);
                sc.close();
            }
            if (STOP.equalsIgnoreCase(userMessage)) {
                dialogue = false;
                logs.add(userMessage);
            }
            if (CONTINUE.equalsIgnoreCase(userMessage)) {
                dialogue = true;
            }
            if (dialogue) {
                String answer = answers.get(rand.nextInt(answers.size()));
                System.out.println(answer);
                logs.add(userMessage);
                logs.add(answer);
            }
            saveLog(logs);
        }
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            String str = in.readLine();
            while (in.ready()) {
                phrases.add(str);
                str = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, Charset.forName("windows-1251"))))) {
            for (String s : log) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./src/main/resources/chatLog.txt", "./src/main/resources/botAnswers.txt");
        cc.run();
    }
}
