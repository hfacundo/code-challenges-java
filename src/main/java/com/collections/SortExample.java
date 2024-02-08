package com.collections;

import com.collections.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortExample {

    public static void sortByNameAndAge(List<User> users) {
        System.out.println(users);
        List<User> sortedByAge = users.stream().sorted((u1, u2) -> u1.getAge() - u2.getAge()).collect(Collectors.toList());
        System.out.println(sortedByAge);
        List<User> sortedByName = users.stream().sorted((u1, u2) -> u1.getName().compareTo(u2.getName())).collect(Collectors.toList());
        System.out.println(sortedByName);
    }

    public static void sortByNameAndAgeEnhanced(List<User> users) {
        List<User> sortedByAge = users.stream().sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList());
        System.out.println(sortedByAge);
        List<User> sortedByName = users.stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
        System.out.println(sortedByName);
    }

    public static void sortByNameAndThenAgeEnhanced(List<User> users) {
        List<User> sortedByNameAndThenAge = users.stream()
                .sorted(Comparator.comparing(User::getName).thenComparingInt(User::getAge).thenComparingInt(User::getId))
                .collect(Collectors.toList());
        System.out.println(sortedByNameAndThenAge);
    }

    public static void main(String[] args) {
        User user = new User(1, "John Wick", 45);
        User user2 = new User(2, "Dominic Toretto", 44);
        User user3 = new User(3, "Liam Neeson", 50);
        User user4 = new User(4, "Thanos", 1000);
        User user5 = new User(4, "Peter Parker", 16);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        sortByNameAndAge(users);
        sortByNameAndAgeEnhanced(users);
        sortByNameAndThenAgeEnhanced(users);

        String s = "abbd";
        char[] array = s.toCharArray();
        System.out.println(array[1] < array[2]);
    }
}
