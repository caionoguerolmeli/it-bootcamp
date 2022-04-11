package br.com.meli.codigomorse;

import org.apache.tomcat.util.buf.CharsetUtil;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MorseService {
    String letters;
    String[] morseLetters;
    String newText = "";

    public MorseService() {

        this.letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890,.?";
        this.morseLetters = new String[]{ ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.." };
    }

    public String converteParaPortugues(String value) {
        List<String> valueList = Arrays.stream(value.split(" ")).collect(Collectors.toList());
        List<String> translated = new ArrayList<>();
        int countSpace = 0;
        for (int i = 0; i < letters.length(); i++) {

            if (letters.charAt(i)!=32) {
                for (int j = 0; j < this.morseLetters.length; j++) {
                    if (valueList.get(i).equals(this.morseLetters[j])) {
                        translated.add(String.valueOf(letters.charAt(i)));
                    }
                }
            } else{
                countSpace++;
                if(countSpace==3){
                    translated.add(" ");
                }
            }

        }

        return translated.stream().collect(Collectors.joining());
    }
}
