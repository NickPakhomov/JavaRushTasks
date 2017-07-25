package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
    }

    public static class IncomeDataAdapter implements Customer, Contact{

        private IncomeData data;

        IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return String.format("%s, %s",
                    data.getContactLastName(), data.getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
            StringBuilder phoneNumber = new StringBuilder(
                    String.valueOf(data.getPhoneNumber()).replace(" ", ""));
            while (phoneNumber.length() < 10) {
                phoneNumber.insert(0, "0");
            }

            return String.format("+%d(%s)%s-%s-%s",
                    data.getCountryPhoneCode(), // + 38
                    phoneNumber.toString().substring(0,3), //050
                    phoneNumber.toString().substring(3, 6), //123
                    phoneNumber.toString().substring(6, 8), //45
                    phoneNumber.toString().substring(8, 10)); //67
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 50 123 45 67
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