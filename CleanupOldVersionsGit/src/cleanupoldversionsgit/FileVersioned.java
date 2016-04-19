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
    
    public String getPrefix()
    {
        return prefix;
    }
    
    
    
    private void appendVersions(String file)
    {   
        versions = new ArrayList<String>();
        for (String fileName: Utils.listFiles(new File(".")))
        {
        if(fileName.contains(prefix))
        {
            String sufix = fileName.substring(prefix.length(),fileName.length()-4).replace(".", "");
            versions.add(sufix);
            //System.out.println(sufix);
            
        }
        }
    }
    
    public ArrayList<String> getVersions()
    {
        return versions;
    }
    
    public int getMaxVersion()
            {
                
                String[] versionStrings = new String[versions.size()];
                versionStrings = versions.toArray(versionStrings);
                int max = 0;
                for (int i=0; i<versionStrings.length-1; i++)
                {
                    String  clearVersionNameSecond = versionStrings[i+1].replaceAll("\\D+", "");
                    String  clearVersionNameFirst = versionStrings[i].replaceAll("\\D+", "");
                    if( Integer.parseInt(clearVersionNameFirst) < Integer.parseInt(clearVersionNameSecond) )
                    {  
                        max=Integer.parseInt(clearVersionNameSecond);
                    }
                }
               return max;
            }
    
}
