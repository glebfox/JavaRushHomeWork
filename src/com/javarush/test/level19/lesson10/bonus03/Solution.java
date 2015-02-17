package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    private static ArrayList<String> tags = new ArrayList<>();
    private static String startTag;
    private static String endTag;
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        String fileName = reader.readLine();
        is.close();
        reader.close();
//        String fileName = "/Users/glebfox/Downloads/javaTestFiles/input.txt";
//        args = "span".split(" ");
        startTag = String.format("<%s", args[0]);
        endTag = String.format("</%s>", args[0]);
        getTags(getStringFromFile(fileName));
        printTags();
    }

    private static void printTags() {
        for (String item : tags)
            System.out.println(item);
    }

    private static void addTag(String tag) {
        int subTagIndex = startTag.length();
        int subTagsCount = 0;
        while ((subTagIndex = tag.indexOf(startTag, subTagIndex)) > 0) {
            subTagsCount++;
            subTagIndex += startTag.length();
        }
        tags.add(tags.size() - subTagsCount, tag);
    }

    private static void getTags(String line) throws IOException {
        int index;
        while ((index = line.indexOf(startTag)) >= 0) {
            if (index > 0)
                line = line.substring(index);
            String tag = getSubTag(line);
            addTag(tag);
            line = line.substring(tag.length());
        }

    }

    private static String getSubTag(String input){
        String tag = input.substring(0, startTag.length());
        input = input.substring(startTag.length());
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '<') {
                if (input.substring(i, i + startTag.length()).equals(startTag)) {
                    String subTag = getSubTag(input.substring(i));
                    i += subTag.length() - 1;
                    addTag(subTag);
                } else if (input.substring(i, i + endTag.length()).equals(endTag)) {
                    tag += input.substring(0, i + endTag.length());
                    return tag;
                }
            }
        }
        return input;
    }

    private static String getStringFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String text = "";
        while (reader.ready())
            text += reader.readLine();
        reader.close();
        return text;
    }
}
