/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dam.codeoptimization.fantasy;
import es.dam.codeoptimization.PlayerStats;

/**
 * THE CLASS YOU HAVE TO MODIFY
 * @author Your Name
 */
public class FantasyCalculator {

    // Method to calculate the points
    public static int calcularFantasyPoints(PlayerStats stats) {
        int fantasyPoints = 0; 
        int points = 0;
        
        int minutes = stats.minutes;
        int goals = stats.goals;
        int assists = stats.assists;
        boolean yellowCard = stats.yellowCard;
        boolean redCard = stats.redCard;
        int saves = stats.saves;
        int goalsAgainst = stats.goalsAgainst;
        char matchResult = stats.matchResult;
        String position = stats.position;

        // --- GOALKEEPER LOGIC ---
        if (position.equals("PORTERO")) {
            if (minutes > 0 && minutes < 60) {
                fantasyPoints += 3;
            } else if (minutes >= 60) {
                fantasyPoints += 5;
            }

            for (int i = 0; i < goals; i++) {
                fantasyPoints += 5;
            }

            fantasyPoints += (assists * 6);

            // 1 point per save
            fantasyPoints += saves; 
            
            switch (goalsAgainst) {
                case 0 -> fantasyPoints += 5;
                case 1 -> fantasyPoints += 3;
                case 2 -> fantasyPoints += 1;
                default -> {
                }
            }

            if (yellowCard) fantasyPoints -= 3; 
            if (redCard) fantasyPoints -= 5;
            
            if (matchResult == 'G') {
                fantasyPoints += 5;
            } else if (matchResult == 'E') {
                fantasyPoints += 2;
            }

        // --- DEFENDER LOGIC ---
        } else if (position.equals("DEFENSA")) {
            if (minutes > 0 && minutes < 60) {
                fantasyPoints += 3;
            } else if (minutes >= 60) {
                fantasyPoints += 5;
            }

            for (int i = 0; i < goals; i++) {
                fantasyPoints += 5;
            }

            fantasyPoints = fantasyPoints + (assists * 6);

            switch (goalsAgainst) {
                case 0 -> fantasyPoints = fantasyPoints + 5;
                case 1 -> fantasyPoints = fantasyPoints + 3;
                case 2 -> fantasyPoints = fantasyPoints + 1;
                default -> {
                }
            }

            if (yellowCard) fantasyPoints -= 3;
            if (redCard) fantasyPoints -= 5;
            
            if (matchResult == 'G') {
                fantasyPoints += 5;
            } else if (matchResult == 'E') {
                fantasyPoints += 2;
            }

        // --- MIDFIELDER LOGIC ---
        } else if (position.equals("MEDIO")) {
            if (minutes > 0 && minutes < 60) {
                fantasyPoints += 3;
            } else if (minutes >= 60) {
                fantasyPoints += 5;
            }

            for (int i = 0; i < goals; i++) {
                fantasyPoints += 5;
            }

            fantasyPoints = fantasyPoints + (assists * 6);

            if (yellowCard) fantasyPoints -= 3;
            if (redCard) fantasyPoints -= 5;
            
            if (matchResult == 'G') {
                fantasyPoints += 5;
            } else if (matchResult == 'E') {
                fantasyPoints += 2;
            }

        // --- FORWARD LOGIC ---
        } else if (position.equals("DELANTERO")) {
            if (minutes > 0 && minutes < 60) {
                fantasyPoints += 3;
            } else if (minutes >= 60) {
                fantasyPoints += 5;
            }

            for (int i = 0; i < goals; i++) {
                fantasyPoints = fantasyPoints + 6;
            }

            fantasyPoints = fantasyPoints + (assists * 5);

            if (yellowCard) fantasyPoints -= 3;
            if (redCard) fantasyPoints -= 5;
            
            if (matchResult == 'G') {
                fantasyPoints += 5;
            } else if (matchResult == 'E') {
                fantasyPoints += 2;
            }
        }

        return fantasyPoints;
    }
}
