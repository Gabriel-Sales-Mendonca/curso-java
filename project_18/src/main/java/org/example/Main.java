package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        String pathFile = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line = br.readLine();
            Map<String, Integer> result = new HashMap<>();

            while(line != null) {
                String[] nameVotes = line.split(",");
                String name = nameVotes[0];
                Integer votes = Integer.parseInt(nameVotes[1]);

                if(result.containsKey(name)) {
                    Integer totalVotes = result.get(name) + votes;
                    result.put(name, totalVotes);
                } else {
                    result.put(name, votes);
                }

                line = br.readLine();
            }

            for(String name : result.keySet()) {
                System.out.println(name + ": " + result.get(name));
            }
        }
        catch (IOException e) {
            System.out.println("Erro " + e);
        }
    }
}