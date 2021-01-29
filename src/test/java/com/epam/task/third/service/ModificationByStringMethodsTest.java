package com.epam.task.third.service;

import org.junit.Assert;
import org.junit.Test;

public class ModificationByStringMethodsTest {
    ModificationByStringMethods modificationByStringMethods = new ModificationByStringMethods();

    private final static String TESTED_TEXT = "Coupling is the degree of interdependence between software modules.";

    @Test
    public void shouldChangeEverySevenLetterInWords() throws DataException {
        String expectedText = "CoupliXg is the degree of interdXpendence betweeX softwaXe moduleX.";
        String actualText = modificationByStringMethods.changeEverySeventhLetterInWords(TESTED_TEXT);
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void shouldDeleteWordsOfEightLettersBeginningConsonant() throws DataException {
        String expectedText = "is the degree of interdependence between modules.";
        String actualText = modificationByStringMethods.deleteWordsOfEightLettersBeginningConsonant(TESTED_TEXT);
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void shouldSplitTextWithSpace(){
        String[] expectedArray = new String[]{"Coupling", "is", "the", "degree", "of", "interdependence", "between", "software", "modules."};
        String[] actualArray = modificationByStringMethods.splitTextWithSpace(TESTED_TEXT);
        Assert.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void shouldCleanWordFromPunctuationMark(){
        String testedWord = "modules.";
        String expectedWord = "modules";
        String actualWord = modificationByStringMethods.cleanWordFromPunctuationMark(testedWord);
        Assert.assertEquals(expectedWord, actualWord);
    }

    @Test
    public void shouldModifySeventhLetter(){
        String testedWordWithPunctuationMark = "modules.";
        String cleanWord = "modules";
        String expectedWord = "moduleX.";
        String actualWord = modificationByStringMethods.modifySeventhLetter(testedWordWithPunctuationMark, cleanWord);
        Assert.assertEquals(expectedWord, actualWord);
    }

    @Test
    public void checkIfEightLetterWordBeginsConsonantShouldReturnTrue(){
        String testedWord = "Coupling";
        boolean actualResult = modificationByStringMethods.checkIfEightLetterWordBeginsConsonant(testedWord);
        Assert.assertTrue(actualResult);
    }




    @Test(expected = DataException.class)
    public void changeEverySeventhLetterInWordsThrowsException() throws DataException {
        String noText = "";
        String actualText = modificationByStringMethods.changeEverySeventhLetterInWords(noText);
    }

    @Test(expected = DataException.class)
    public void deleteWordsOfEightLettersBeginningConsonantThrowsException() throws DataException {
        String noText = "";
        String actualText = modificationByStringMethods.deleteWordsOfEightLettersBeginningConsonant(noText);
    }
}
