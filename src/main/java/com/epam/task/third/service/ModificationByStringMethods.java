package com.epam.task.third.service;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// only String methods, + regex-s
public class ModificationByStringMethods implements TextModifiable {

    private final static Logger LOGGER = Logger.getLogger(ModificationByStringMethods.class);

    public String[] splitTextWithSpace(String text) {
        String separatorSpace = "\\s";
        return text.split(separatorSpace);
    }

    public String cleanWordFromPunctuationMark(String word) {
        String dot = ".";
        String virgule = ",";
        String emptyReplacement = "";
        String cleanWordFirstStage = word.replace(dot, emptyReplacement);
        return cleanWordFirstStage.replace(virgule, emptyReplacement);
    }

    public String modifySeventhLetter(String word, String cleanWord) {
        LOGGER.debug("The method to modify seventh letter was called.");
        String firstWordPart = word.substring(0, 6);
        String secondWordPart;
        if (cleanWord.length() != 7) {
            secondWordPart = word.substring(7);
        } else if (word.length() > 7) {
            char punctuationMark = word.charAt(7);
            secondWordPart = String.valueOf(punctuationMark);
        } else {
            secondWordPart = "";
        }
        String replacementLetter = "X";
        return firstWordPart + replacementLetter + secondWordPart;
    }

    public String changeEverySeventhLetterInWords(String text) throws DataException {
        if (text.isEmpty()) {
            throw new DataException("no text data");
        }
        String[] wordsWithPunctuation = splitTextWithSpace(text);

        String modifiedText = "";
        for (String word : wordsWithPunctuation) {

            String cleanWord = cleanWordFromPunctuationMark(word);
            String space = " ";
            if (cleanWord.length() >= 7) {
                String modifiedWord = modifySeventhLetter(word, cleanWord);
                modifiedText = modifiedText + modifiedWord;
                modifiedText = modifiedText + space;
            } else {
                modifiedText = modifiedText + word;
                modifiedText = modifiedText + space;
            }
        }
        LOGGER.debug("The method to change every seven letter in words was used.");
        return modifiedText.trim();
    }

    public boolean checkIfEightLetterWordBeginsConsonant(String word) {
        LOGGER.debug("The method to check if eight letter word begins consonant was called.");

        String cleanWord = cleanWordFromPunctuationMark(word);
        boolean checkResult = false;
        String firstConsonant = "^[a-z&&[^aeiou]]";
        if (cleanWord.length() == 8) {
            Pattern linePattern = Pattern.compile(firstConsonant);
            Matcher matcher = linePattern.matcher(cleanWord);
            checkResult = !matcher.matches();
        }
        return checkResult;
    }

    public String deleteWordsOfEightLettersBeginningConsonant(String text) throws DataException {
        if (text.isEmpty()) {
            throw new DataException("no text data");
        }
        String[] wordsWithPunctuation = splitTextWithSpace(text);

        String modifiedText = "";
        for (String word : wordsWithPunctuation) {
            if (!checkIfEightLetterWordBeginsConsonant(word)) {
                String space = " ";
                modifiedText = modifiedText + word + space;
            }
        }
        LOGGER.debug("The method to delete words of eight letters beginning consonant was used.");
        return modifiedText.trim();
    }
}