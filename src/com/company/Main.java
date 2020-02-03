package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        File file = new File("movies.txt");
        Scanner scan = new Scanner(file);
        int i = 0;
        String pic;
        String[] movie = new String[1000];
        while (scan.hasNextLine()) {
            pic = scan.nextLine();
            movie[i++] = pic;
        }

        int ind = (int) (Math.random() * i);
        String mov = movie[ind];
        //System.out.println(mov);
        int size = mov.length();
        char[] ans = new char[size];
        char[] movi = mov.toCharArray();
        int c = 1;
        for (int j = 0; j < size; j++) {
            if (movi[j] != ' ')
                ans[j] = '_';
            else c++;
        }
        int score = 10;
        int point = 0;
        boolean won = false;
        System.out.println("IT HAS " + c + " WORDS\nTOTAL NUMBER OF LETTERS : " + (size - c + 1));
        while (score != 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("ENTER YOUR GUESS : ");
            char ch = sc.nextLine().charAt(0);
            boolean flag = false;
            for (int j = 0; j < size; j++) {
                if (Character.toLowerCase(ch) == Character.toLowerCase(movi[j]) && ans[j] == '_' && ch != ' ') {
                    ans[j] = ch;
                    flag = true;
                    point++;
                    System.out.println(ans);
                    break;
                }
            }
            if (!flag) {
                System.out.println("WRONG GUESS !");
                score--;
            }


            if (point == ((size - mov.split(" ").length) + 1)) {
                System.out.println("YOU WON !\n" + "YOUR SCORE : " + score);
                won = true;
                break;

            }
        }
        if (!won) System.out.println("YOU LOST !\nCORRECT ANSWER IS : " + mov);
        else if (score >= 5) System.out.println("WELL PLAYED !");
        else if (score < 5) System.out.println("NEED SOME IMPROVEMENT !");
    }
}
