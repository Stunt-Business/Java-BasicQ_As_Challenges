// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 17 : Challenge IX - Writing in a File (data coming from the web)
// Day 17 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?


import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class Day17 {

    private static final String PATH = "text_data/";
    public static void main(String[] args)
    {
        //initialize the url of the website you want to visit
        String baseUrl = "https://www.stuntbusiness.ca/fr/legal/terms-and-conditions" ;
        
        // WebClient :  The main starting point in HtmlUnit: this class simulates a web browser.
        // https://htmlunit.sourceforge.io/apidocs/com/gargoylesoftware/htmlunit/WebClient.html
        WebClient client = new WebClient();

        // deactivate css and javascript
        client.getOptions().setJavaScriptEnabled(false);
		client.getOptions().setCssEnabled(false);
        
        // Start parsing your page
		try {
            // get your html page
			HtmlPage page = client.getPage(baseUrl);
            
            // Get all the html element h4 with class="title-in-content"
            List<HtmlElement> items = (List<HtmlElement>) (Object) page.getByXPath("//h4[@class='title-in-content']") ;
            
            if(items.isEmpty())
            {
				System.out.println("Nothing found with your request.");
            }else{

                File directory = new File(PATH);
        
                // create directory if it does not exist

                if( !(directory.exists()))
                {
                    directory.mkdir();
                }


                File file = new File(PATH + "Day17_data.txt");
                // creating the file if it does not exist
                if(!file.exists())
                {
                    try
                    {
                        if(file.createNewFile())
                        {
                            System.out.println("\nFile successfully created : "+file.getName());
                        }
                    }catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                
                }
                else   // the file does not exist
                {
                    System.out.println(
                            String.format("\nFile %s already exists.", file.getName())
                        );
                }


                // writing and reading processes
                try
                {

                    System.out.println("\n>>>>  GETTING ALL H4 TAGS <<<<\nfrom: "+ baseUrl +"\n");
                    // Write inside the file
                    FileWriter writer =  new FileWriter(file.getAbsolutePath());
                    System.out.println("\n----------- WRITING ------------\n");

                    writer.write("\nTag Id\t\tTag Content\n");
                    // print all the elements collected
                    int index = 0;

                    // print the h4 found.
                    for(HtmlElement htmlItem : items){
                        writer.write(
                            String.format("%d\t\t%s\n",index++,htmlItem.asText())
                        );
                        // System.out.println(
                        //      "> " + (index++) + ":\n" + htmlItem.asText()
                        //  );
                    }
                   
                    writer.close();
                    Scanner sc = new Scanner(file); 

                    System.out.println("\n----------- READING ------------\n");
                    // read the content of the file
                    while (sc.hasNextLine()) 
                        System.out.println(sc.nextLine());
                    
                    sc.close();

                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }

                
            }
        
        // close your web client
        client.close();

		} catch(Exception e){
			e.printStackTrace();
        }
        
        System.out.println("End of program.");

    }
    
}