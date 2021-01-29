package com.epam.task.third;


import com.epam.task.third.service.DataException;
import com.epam.task.third.service.ModificationByStringMethods;
import org.apache.log4j.Logger;


public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.info("Program started");

        String textExample = "";
        try {
            ModificationByStringMethods modificationByStringMethods = new ModificationByStringMethods();
            System.out.println(modificationByStringMethods.changeEverySeventhLetterInWords(textExample));
        } catch (DataException e) {
            LOGGER.error(e.getMessage(), e);
        }

        LOGGER.info("Program finished");
    }
}
