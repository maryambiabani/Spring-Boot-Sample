package com.example.demo.common;

import java.io.File;
import java.io.FilenameFilter;
public class GetAllFilesWithCertainExtMain {

    public static void main(String[] args) {

GetAllFilesWithCertainExtMain main=new GetAllFilesWithCertainExtMain();
System.out.println("Finding .json files in the folder /Users/Arpit/Desktop/Blog");
System.out.println("-----------------");
// Read the file
File folder=new File("/Users/maryambiabani/Documents/java project/api sample/Spring-Boot-Sample/demo/demo");
String[] test= main.getAllFilesWithCertainExtension(folder,"json");
        System.out.printf(test.toString());
        for (int i = 0; i < test.length; i++) {
            System.out.println("File :"+test[i]);
        }

System.out.println("-----------------");
    }

    public String[] getAllFilesWithCertainExtension(File folder,String filterExt)
    {
      MyExtFilter extFilter=new MyExtFilter(filterExt);
        String[] list = folder.list(extFilter);
      if(!folder.isDirectory())
     {
        System.out.println("Not a folder");


     }
     else
     {
        // list out all the file name and filter by the extension


        if (list.length == 0) {System.out.println("no files end with : " + filterExt);
         return list;
        }

        for (int i = 0; i < list.length; i++) {
         System.out.println("File :"+list[i]);
        }
         return list;

     }
return list;
    }

        // inner class, generic extension filter
        public class MyExtFilter implements FilenameFilter {

        private String ext;

        public MyExtFilter(String ext) {
this.ext = ext;
        }

        public boolean accept(File dir, String name) {
return (name.endsWith(ext));
        }
}
}
