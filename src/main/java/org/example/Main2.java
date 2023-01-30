package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
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
        if (list.size()%2 != 0) throw new Exception("All numbers dont have pairs");
        Collections.sort(list);
        for (int i = 0; i < list.size()/2; i++){
            System.out.println(list.get(i)+" "+list.get(list.size()-1 - i));
        }
    }
}
