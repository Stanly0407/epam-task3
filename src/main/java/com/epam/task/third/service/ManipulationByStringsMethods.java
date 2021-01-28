package com.epam.task.third.service;


public class ManipulationByStringsMethods implements TextManipulation{

    //  В каждом слове 7-ю букву заменить заданным символом. Если k больше длины слова, корректировку не выполнять.

    public String[] getClearWordsFromText(String text){
        String space = " ";
        String dot = ".";
        String virgule = ", ";
        String dash = " - ";

        String clearText = text.replace(dot, space).replace(virgule, space).replace(dash, space).trim();
        return clearText.split(space);
    }

    public String changeEverySevenLetterInWords(String text) {
        String[] words = getClearWordsFromText(text);
        StringBuilder modificationBuilder = new StringBuilder();

            for(String word : words){
            if (word.length()>= 7){
                StringBuilder temporary = new StringBuilder(word);
                temporary.replace(6, 7, "X");
                modificationBuilder.append(temporary).append(" ");
            } else {
                modificationBuilder.append(word).append(" ");
            }
        }
        return new String(modificationBuilder);
    }


    public String changeTwoLetterWords(String text) {

        return null;
    }


    public String deleteFiveLetterWordsBeginningConsonant(String text) {

        return null;
    }
}
