package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        if (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner scan = new Scanner(line);
            while (scan.hasNextInt()) {
                int number = scan.nextInt();
                list.add(number);
                if (!scan.hasNextInt()) break;
            }
        }
        Collections.sort(list);
        System.out.println(list);
        System.out.println("count: " + list.size());
        System.out.println("distinct: " + getDistinct(list));
        System.out.println("min: " + list.stream().findFirst().get());
        System.out.println("max: " + list.stream().toList().get(list.size() - 1));
    }

    private static Integer getDistinct(ArrayList<Integer> set) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (Integer num : set) {
            if (list.contains(num)) count++;
            list.add(num);
        }
        return set.size() - count;
    }

}