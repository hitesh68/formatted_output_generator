package com.hiteshpoddar;

import java.util.HashMap;
import java.util.Map;

public class App {

    private static final Map<Integer, StringBuilder> INTEGER_MAP = setup();

    private static final Map<Integer, StringBuilder> setup() {
        
        Map<Integer, StringBuilder> integerMap = new HashMap<>();

        for(int digit=0; digit<10; digit++) {
            integerMap.put(digit, new StringBuilder("."));
        }

        return integerMap;
    }

    private static void groupIntegers(String input) {

        for (char character : input.substring(4).toCharArray()) {
            
            if(character == '.') continue;

            int digit = Character.getNumericValue(character);
            StringBuilder groupedIntegerString = INTEGER_MAP.get(digit);

            groupedIntegerString.append(character);
        }
    }

    public static void main(String[] args) {

        StringBuilder output = new StringBuilder();

        output.append(args[0].substring(0, 3));
        groupIntegers(args[0]);

        for(int digit=9; digit>-1; digit--) {

            StringBuilder groupedIntegerString = INTEGER_MAP.get(digit);
            if(groupedIntegerString.length() > 1) output.append(groupedIntegerString);
        }

        System.out.println(output);
    }
}
