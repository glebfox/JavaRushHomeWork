package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String lastName = scanner.next();
            String firstName = scanner.next();
            String middleName = scanner.next();
            int day = scanner.nextInt();
            int month = scanner.nextInt();
            int year = scanner.nextInt();

            return new Person(firstName, middleName, lastName, new GregorianCalendar(year, month - 1, day).getTime());
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
