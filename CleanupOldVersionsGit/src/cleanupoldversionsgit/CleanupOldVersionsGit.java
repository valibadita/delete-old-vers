/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleanupoldversionsgit;


import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author valentin
 * Goal: delete all files generated with a version control app not being used. We assume that the newest version should not be deleted
* Steps: 1. Collect all file names (just the distinct ones, without version number)
*/

public class CleanupOldVersionsGit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      try
      {
        File directory;
        if(args.length!=0)
        { 
        directory = new File(args[0]);
        }
        else
        {
        directory = new File(".");
        }
        
        ArrayList<FileVersioned> filesVersioned = new ArrayList<FileVersioned>();
        for (String distinctName: Utils.distinctPrefixFilenames(directory))
        {
            filesVersioned.add(new FileVersioned(distinctName));
        }
        
        
        for(FileVersioned f: filesVersioned)
        {
         //To do something here, delete files 
          
           ArrayList<String> versionsOfFile =  f.getVersions();
           
                for(String version: versionsOfFile)
                
                {
                 String  clearVersionName = version.replaceAll("\\D+", "");
                   
                    if(Integer.parseInt(clearVersionName)<f.getMaxVersion()||version.matches(".*\\D+"))
                    {
                        File fileToDelete = new File(f.getPrefix() + "." + version + ".jar");
                      //  Utils.print(fileToDelete);
                        if(fileToDelete.exists())
                        {
                            fileToDelete.delete();
                        }
                    }
                }
                    
                
            
        }
    
      }
      catch (Exception e)
      {
          Utils.print("Error. Please try again");
          e.printStackTrace();
      }
       
    }
    
}
