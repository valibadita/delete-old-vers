/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleanupoldversionsgit;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author valentin_diana
 */
public class Utils {
    
    public static <E> void print(E input)
    {
        System.out.println(input);
    }
    
    public static ArrayList<String> listFiles(File folder)
    {
        ArrayList<String> filesToAdd = new ArrayList<String>();
        for (File file: folder.listFiles())
        {
            filesToAdd.add(file.getName());
        }
        return filesToAdd;
    }
    
    public static Set<String> distinctPrefixFilenames(File folder)
    {
      Set<String> set = new HashSet<String>();  
      
        for (File file: folder.listFiles())
            {    
        
                String fileName = file.getName();
                Pattern pattern = Pattern.compile("(.*SP54)(.*)(\\.jar)");
                Matcher matcher = pattern.matcher(fileName);
                    if(matcher.find())
                        {
                           set.add(matcher.group(1));
                        }
                   
        
            }
    return set;        
    
    }
}
