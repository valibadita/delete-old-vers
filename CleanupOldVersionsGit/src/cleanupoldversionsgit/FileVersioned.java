/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleanupoldversionsgit;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author valentin_diana
 */
public class FileVersioned {
    
    private String prefix;
    private ArrayList<String> versions;
    
    FileVersioned(String filePrefix)
    {
        prefix = filePrefix;
        appendVersions(filePrefix);
        
    }
    
    
    
    private void appendVersions(String file)
    {   
        versions = new ArrayList<String>();
        for (String fileName: Utils.listFiles(new File(".")))
        {
        if(fileName.contains(prefix))
        {
            String sufix = fileName.substring(prefix.length(),fileName.length()-4);
            versions.add(sufix);
            //System.out.println(sufix);
            
        }
        }
    }
    
    public ArrayList<String> getVersions()
    {
        return versions;
    }
    
}
