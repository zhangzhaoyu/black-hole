package org.zzy.distributed.web.locale;

import java.io.File;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by zhaoyu on 16-9-9.
 */
public class LocaleTest {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getDisplayLanguage());

        System.out.println(LocaleTest.class.getResource("/org"));
        System.out.println(LocaleTest.class.getResource("/logback.xml"));

        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages/messages");
        Enumeration<String> keySet = resourceBundle.getKeys();
        while (keySet.hasMoreElements()) {
            String key = keySet.nextElement();
            System.out.println(key+ " : " + resourceBundle.getString(key));
        }

        File file = new File("/"); // path /
        File file2 = new File(""); // parent project path
        System.out.println(file.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());
    }
}
