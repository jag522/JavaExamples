package com.jag.i18n;

import java.util.*;

public class I18NSample {

   static public void main(String[] args) {

      String language;
      String country;

      language = new String("fr");
      country = new String("FR");

      Locale currentLocale;
      ResourceBundle messages;

      currentLocale = new Locale(language, country);

      messages =
        ResourceBundle.getBundle("je3.i18n.MessagesBundle",currentLocale);

      System.out.println(messages.getString("greetings"));
      System.out.println(messages.getString("inquiry"));
      System.out.println(messages.getString("farewell"));
   }
}
