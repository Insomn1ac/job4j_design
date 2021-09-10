package ru.job4j.io;

import java.io.*;
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
            if (OUT.equals(userMessage)) {
                active = false;
                dialogue = false;
                sc.close();
                saveLog(logs);
            }
            if (STOP.equals(userMessage)) {
                dialogue = false;
            }
            if (CONTINUE.equals(userMessage)) {
                dialogue = true;
            }
            if (dialogue) {
                String answer = answers.get(rand.nextInt(answers.size()));
                System.out.println(answer);
                logs.add(answer);
            }
        }
        logs.add(sc.nextLine());
        saveLog(logs);
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            String str = in.readLine();
            while (str != null) {
                phrases.add(str);
                str = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            for (String s : log) {
                out.write(s);
                out.newLine();
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
