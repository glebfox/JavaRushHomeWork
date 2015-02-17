package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        String fileName;
        while (!(fileName = reader.readLine()).toUpperCase().equals("EXIT")){
            new ReadThread(fileName).start();
        }

        is.close();
        reader.close();
//
//        for (Map.Entry<String, Integer> pair : resultMap.entrySet()){
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private FileInputStream inputStream;

        public ReadThread(String fileName) throws FileNotFoundException{
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            int[] bytes = new int[256];
            int indexOfMax = 0;
            try {
                inputStream = new FileInputStream(fileName);

                while (inputStream.available() > 0){
                    int index = inputStream.read();
                    bytes[index]++;
                    if (bytes[index] > bytes[indexOfMax])
                        indexOfMax = index;
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Solution.resultMap.put(this.fileName, indexOfMax);
        }
    }
}
