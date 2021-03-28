package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("No item");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            FindEl.indexOf(new String[] {"123", "321"}, "1111");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}