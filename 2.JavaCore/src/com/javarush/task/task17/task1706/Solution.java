package com.javarush.task.task17.task1706;

/* 
Синхронизированный президент
*/

public class Solution {
    static OurPresident expectedPresident;
    static OurPresident ourPresident;

    public static void main(String[] args) {


        new Thread(() -> expectedPresident = OurPresident.getOurPresident()).start();

        new Thread(() -> ourPresident = OurPresident.getOurPresident()).start();

        System.out.println(expectedPresident == ourPresident );
    }
}
