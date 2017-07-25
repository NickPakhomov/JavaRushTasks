package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

            System.out.println(solution.equals(clone));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Solution))
            return false;

        if (obj == this) return true;

        Solution slt = (Solution) obj;
        return Objects.equals(users, slt.users);
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution solution1 = new Solution();
        solution1.users.putAll(users);
        return solution1;
    }

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            return new User(age, name);
        }
    }
}
