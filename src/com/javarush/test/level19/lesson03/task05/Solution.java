package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            if (countries.containsValue(customer.getCountryName()))
                for (Map.Entry<String, String> pair : countries.entrySet()) {
                    if (pair.getValue().equals(customer.getCountryName())) {
                        return pair.getKey();
                    }
                }
            return "";
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().split(", ")[1];
        }

        @Override
        public String getContactLastName() {
            return contact.getName().split(", ")[0];
        }

        @Override
        public String getDialString() {
            String callto = "callto://";
            String[] phoneParts = contact.getPhoneNumber().split("[()-]");

            for (int i = 0; i < phoneParts.length; i++) {
                callto += phoneParts[i];
            }
            return callto;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}

//    public static void main(String[] args) {
//        DataAdapter da = new DataAdapter(new MyCustomer(), new MyContract());
//
//        System.out.println(da.getCompany());
//        System.out.println(da.getContactFirstName());
//        System.out.println(da.getContactLastName());
//        System.out.println(da.getCountryCode());
//        System.out.println(da.getDialString());
//
//    }

//    public static class MyCustomer implements Customer {
//
//        @Override
//        public String getCompanyName() {
//            return "JavaRush Ltd.";
//        }
//
//        @Override
//        public String getCountryName() {
//            return null;
//        }
//    }
//
//    public static class MyContract implements Contact {
//
//        @Override
//        public String getName() {
//            return "Gorelov, Gleb";
//        }
//
//        @Override
//        public String getPhoneNumber() {
//            return "+7(925)721-89-79";
//        }
//    }