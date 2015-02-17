package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endX) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        for (Word word : detectAllWords(crossword, "home", "same"))
            System.out.println(word);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<>();

        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (words[wordIndex].charAt(0) == crossword[i][j]) {
                        int[] endCoords = getEndCoords(crossword, i, j, words[wordIndex]);
                        if (endCoords[0] != -1) {
                            Word word = new Word(words[wordIndex]);
                            word.setStartPoint(j, i);
                            word.setEndPoint(endCoords[1], endCoords[0]);
                            result.add(word);
                        }
                    }
                }
            }
        }

        return result;
    }

    private static int[] getEndCoords(int[][] crossword, int startX, int startY, String word){
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int x = startX;
                int y = startY;
                int matchCount = 1;
                boolean writeWord = true;
                for (int letterIndex = 1; letterIndex < word.length() && writeWord; letterIndex++) {
                    x += dx;
                    y += dy;
                    try {
                        if (crossword[x][y] == word.charAt(letterIndex)) {
                            matchCount++;
                        }
                        else
                            writeWord = false;
                    } catch (IndexOutOfBoundsException e) {
//                        e.printStackTrace();
                    }
                }
                if (matchCount == word.length())
                    return new int[] {x, y};
            }
        }

        return new int[]{-1, -1};
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
