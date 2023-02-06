package org.example;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<List<Integer>> allPairs = new LinkedList<>();
        int num = in.nextInt();
        for (int i = 0; i < num; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            List<Integer> pairs = List.of(a, b);
            allPairs.add(pairs);
        }
        System.out.println("@@@@");
        System.out.println("@@@@" + allPairs);
        Set<Set<Integer>> set = new HashSet<>();
        List<List<Integer>> listInvisible = new ArrayList<>();
        for (int i=0; i<allPairs.size();i++) {
            for (int j=allPairs.size()-1; j>=0;j--) {
                Set<Integer> setTmp = new TreeSet<>();
                int c = allPairs.get(i).get(0);
                int d = allPairs.get(i).get(1);
                if (i!=j && !listInvisible.contains(allPairs.get(j))){
                    if (allPairs.get(j).contains(c)) {
                        setVeritcal(allPairs, set, listInvisible, j, setTmp, d);
                    } else if (allPairs.get(j).contains(d)) {
                        setVeritcal(allPairs, set, listInvisible, j, setTmp, c);
                    } else {
                        setTmp.add(allPairs.get(j).get(0));
                        setTmp.add(allPairs.get(j).get(1));
                        set.add(setTmp);
                    }
                }
            }
        }
        set.removeIf(pairs -> listInvisible.contains(pairs.stream().toList()));
        System.out.println("@@@ RESULT" + set);
    }

    private static void setVeritcal(List<List<Integer>> allPairs, Set<Set<Integer>> set, List<List<Integer>> listInvisible, int j, Set<Integer> setTmp, int c) {
        setTmp.add(allPairs.get(j).get(0));
        setTmp.add(allPairs.get(j).get(1));
        setTmp.add(c);
        set.add(setTmp);
        listInvisible.add(List.of(allPairs.get(j).get(0),allPairs.get(j).get(1)));
    }
}
