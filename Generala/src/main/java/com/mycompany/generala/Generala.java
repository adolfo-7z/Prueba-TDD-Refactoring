/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generala;

import java.util.Arrays;

// '(int... dice)' es similar a tener public static int generala(int d1, int d2, int d3 , etc) pero permite realizar operaciones como -> for (int die : dice)
//es una forma de decir que el metodo puede aceptar 1 o más parametros de tipo int ... lista de parametros dinamicos.
public class Generala {

    protected int[] dice;
    public Generala(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public static int chance(int... dice) {
        return Arrays.stream(dice).sum();
    }


    public static int generala(int... dice){
        if(Arrays.stream(dice).distinct().count()<=1){
            return 50;
        }
        return 0;
    }

    public static int ones(int... dice) {
        return Arrays.stream(dice).filter(d -> d == 1).sum();
    }

    public static int twos(int... dice) {
        return Arrays.stream(dice).filter(d -> d == 2).sum();
    }

    public static int threes(int... dice) {
        return Arrays.stream(dice).filter(d -> d == 3).sum();
    }

    public int fours(){
        return Arrays.stream(this.dice).filter(d -> d == 4).sum();
    }

    public int fives(){
        return Arrays.stream(this.dice).filter(d -> d == 5).sum();
    }

    public int sixes(){
        return Arrays.stream(this.dice).filter(d -> d == 6).sum();
    }

    public static int score_pair(int... dice){
        int[] counts = new int[6];
        fors(counts,dice);
        for (int i = 0; i != 6; i++) {
            if (counts[6 - i - 1] >= 2) {
                return (6 - i) * 2;
            }
        }
        return 0;
    }

    public static int two_pair(int... dice){
        int[] counts = new int[6];
        fors(counts,dice);
        int num = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                num++;
                score += (6-i);
            }
        if (num == 2)
            return score * 2;
        else
            return 0;
    }

    public static int three_of_a_kind(int... dice){
        int[] tallies = new int[6];
        fors(tallies,dice);
        return matches(3, tallies);
    }

    public static int four_of_a_kind(int... dice){
        int[] tallies = new int[6];
        fors(tallies,dice);
        return matches(4, tallies);
    }

    public static void fors(int[] array, int... dice){
        for(int die:dice){
            array[die-1]++;
        }
    }

    public static int matches(int num, int [] tallies){
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= num)
                return (i+1) * num;
        return 0;
    }


    public static int smallStraight(int... dice){
        int[] tallies = new int[6];
        fors(tallies,dice);
        for(int i=0; i<5 ; i++){
            if(tallies[i] !=1){
                return 0;
            }
        }
        return 15;
    }

    public static int largeStraight(int... dice){
        int[] tallies = new int[6];
        fors(tallies,dice);
        for(int i=0; i<5 ; i++){
            if(tallies[i+1] !=1){
                return 0;
            }
        }
        return 20;
    }

    public static int fullHouse(int... dice){
        int[] tallies = new int[6];
        fors(tallies,dice);
        boolean isPar = isCondition(tallies,2);
        boolean isTrio = isCondition(tallies,3);
        int contadorPares = contadorGeneral(tallies,2);
        int contadorTrio = contadorGeneral(tallies,3);

        if (isPar && isTrio)
            return contadorPares * 2 + contadorTrio * 3;
        else
            return 0;
    }

    public static boolean isCondition(int[] tallies, int value){
        for (int i = 0; i != 6; i += 1)
            if (tallies[i] == value) {
                return true;
            }
        return false;
    }

    public static int contadorGeneral(int[] array,int value){
        for (int i = 0; i != 6; i += 1)
            if (array[i] == value) {
                return i+1;
            }
        return 0;
    }
}

