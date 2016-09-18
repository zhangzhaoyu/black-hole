package org.zzy.thinkinjava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by zhaoyu on 16-9-12.
 */

class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}

public class DirList {
    public static void main(String[] args) {
        File path = new File(DirList.class.getClassLoader().getResource("").getPath());
        System.out.println(path.getAbsolutePath());
        String[] list = path.list(new DirFilter(".*.txt"));

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String file : list) {
            System.out.println(file);
        }
    }
}
