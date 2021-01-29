package com.epam.task.third.service;


import org.apache.log4j.Logger;

// using StringBuilder methods and without regex-s
public class ModificationByStringBuilder implements TextModifiable {

    private final static Logger LOGGER = Logger.getLogger(ModificationByStringBuilder.class);

    public String[] splitTextWithSpace(String text) {
        String separatorSpace = " ";
        return text.split(separatorSpace);
    }

    public String cleanWordFromPunctuationMark(String word) {
        LOGGER.debug("The method to clean word from punctuation mark was called.");
        StringBuilder cleanWordBuilder = new StringBuilder(word);
        String dot = ".";
        String virgule = ",";
        if (word.contains(dot) || word.contains(virgule)) {
            int indexOfLastChar = word.length() - 1;
            cleanWordBuilder.deleteCharAt(indexOfLastChar);
        }
        return new String(cleanWordBuilder);
    }

    public String changeEverySeventhLetterInWords(String text) throws DataException {
        if (text.isEmpty()) {
            throw new DataException("no text data");
        }
        String[] wordsWithPunctuation = splitTextWithSpace(text);

        StringBuilder modifiedText = new StringBuilder();

        for (String word : wordsWithPunctuation) {
            String cleanWord = cleanWordFromPunctuationMark(word);
            String space = " ";
            if (cleanWord.length() >= 7) {
                StringBuilder temporary = new StringBuilder(word);
                String replacementLetter = "X";
                temporary.replace(6, 7, replacementLetter);

                modifiedText.append(temporary).append(space);
            } else {
                modifiedText.append(word).append(space);
            }
        }
        LOGGER.debug("The method to change every seven letter in words was used.");
        return new String(modifiedText).trim();
    }

    public boolean checkIfEightLetterWordBeginsConsonant(String word) {
        LOGGER.debug("The method to check if eight letter word begins consonant was called.");

        String cleanWord = cleanWordFromPunctuationMark(word);
        String[] consonants = new String[]{"b", "c", "d", "f", "g", "h", "k", "l", "m", "n", "p", "q",
                "r", "s", "t", "v", "w", "x", "y", "z"};
        boolean result = false;
        if (cleanWord.length() == 8) {
            for (String consonant : consonants) {
                char firstChar = cleanWord.toLowerCase().charAt(0);
                String firstLetter = String.valueOf(firstChar);
                result = !consonant.equals(firstLetter);
            }
        }
        return result;
    }


    public String deleteWordsOfEightLettersBeginningConsonant(String text) throws DataException {
        if (text.isEmpty()) {
            throw new DataException("no text data");
        }
        String[] wordsWithPunctuation = splitTextWithSpace(text);

        StringBuilder modificationBuilder = new StringBuilder();

        for (String word : wordsWithPunctuation) {
            if (!checkIfEightLetterWordBeginsConsonant(word)) {
                String space = " ";
                modificationBuilder.append(word);
                modificationBuilder.append(space);
            }
        }
        LOGGER.debug("The method to delete words of eight letters beginning consonant was used.");
        return new String(modificationBuilder).trim();
    }
}