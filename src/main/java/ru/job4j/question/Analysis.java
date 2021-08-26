package ru.job4j.question;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analysis {
    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, String> currMap = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        for (User u : previous) {
            if (!currMap.containsKey(u.getId())) {
                info.setDeleted(info.getDeleted() + 1);
            } else if (!currMap.containsValue(u.getName())) {
                info.setChanged(info.getChanged() + 1);
            }
            info.setAdded(currMap.size() - (previous.size() - info.getDeleted()));
        }
        return info;
    }
}
