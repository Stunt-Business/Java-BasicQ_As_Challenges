// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 18 :  Challenge X - Data processing - Read and Plot
// Day 18 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

// Open a text file and write inside the following content:
// Angle  Cosine  Sine
// 0
// 15
// 30
// 45
// 60
// 75
// ...
// Generate your angle from 0 to 360. 
// And add a 15 degrees span between each angle value.
// Parse the File you have just created and look for Angles, Cosine and Sine values
// use the library Jfreechart used in Day13 for your plot
// Plot the values with the Angles on the X-Axis and Cosine/Sine on the Y axis


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import org.apache.commons.lang3.StringUtils;


import java.util.HashMap;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

class Graph extends ApplicationFrame {

    /**
     *
     */
    private static final long serialVersionUID = 8636866202142037430L;
    private String chartTitle;
   private HashMap<String,double[]> data;

   public Graph( String applicationTitle , String chartTitle ) {
      // initialize call the parent constructor ApplicationFrame
      super(applicationTitle);
      
      this.chartTitle = chartTitle;

      // initialize your hasmap
      this.data = new HashMap<String,double[]>();


   }



    /**
     * Add data for the graph, data stored in the Hashmap<>
     * @param rowKey
     * @param dataArray
     */
   public void addData(String rowKey, double[] dataArray)
   {    
        this.data.put(rowKey, dataArray);
   }


   /**
    * 
    * @return
    */
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

        // get the angles values from the dictionary
        double[] angles = this.data.get("Angles");

        //remove the angles so that you are only left with the sine and cosine values
        this.data.remove("Angles");
        
        // add data in the dictionary
        for(String rowKey: this.data.keySet())
        {
            int index = 0; // index for positioning the number
            // add the integers in your dataset
            // each array have the same size
            for(double value : this.data.get(rowKey))
            {
                dataset.addValue(value, rowKey,Double.toString(angles[index++]));
            }
        }

        // add the angles array back into the dictionary
        this.data.put("Angles", angles);
  
        return dataset;
     }

   /**
    * 
    */
   public void plot()
   {
        JFreeChart lineChart = ChartFactory.createLineChart(
            this.chartTitle,
            "Angles",
            "Cosine / Sine Values",
            createDataset(),
            PlotOrientation.VERTICAL,
            true,false,false);
        
        
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 680 , 480 ) );
        setContentPane( chartPanel );
        
   }

}


public class Day18 
{
    private static final String PATH = "text_data/";
    /**
     * @return an return an array of integers from the start to the end with span 
     * between those numbers
     */
    private static int[] generateAngles(int start, int end, int span)
    {
        List<Integer> data = new ArrayList<Integer>();

        // generate the appropriate angle vakues

        for(int i = start; i <= end; i+=span)
        {
            data.add(i);
        }

        // from your list 'data' return an array of integers (int[])
        // https://www.geeksforgeeks.org/stream-in-java/
        // https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java

        return data.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args)
    {
 
        File directory = new File(PATH);

        // create directory if it does not exist

        if( !(directory.exists()))
        {
            directory.mkdir();
        }


        File file = new File(PATH + "Day18_data.txt");
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

            // get the values for your array
            int[] angleValues =  generateAngles(0, 360, 15);

            //System.out.println(Arrays.toString(angleValues));

            // Write inside the file
            FileWriter writer =  new FileWriter(file.getAbsolutePath());
            System.out.println("\n----------- WRITING ------------\n");

            writer.write("Angle\t\tCosine\t\tSine\n");
           
            for( int i : angleValues)
            {
                double cosine  = Math.cos( Math.toRadians(i));
                double sine = Math.sin( Math.toRadians(i));
                writer.write(
                    String.format("%d\t\t%f\t\t%f\n", i,cosine,sine )
                );
            }
  
            writer.close();

            Scanner sc = new Scanner(file); 

            System.out.println("\n----------- READING ------------\n");
            // read the content of the file
            // Info : check if a data exists in your array 
            // https://stackoverflow.com/questions/1128723/how-do-i-determine-whether-an-array-contains-a-particular-value-in-java

            List<Double> cosine = new ArrayList<Double>();
            List<Double> sine  = new ArrayList<Double>();
            List<Double> angles = new ArrayList<Double>();

            while (sc.hasNextLine()) 
            {
                String[]  line =  sc.nextLine().split("\t");

                // check if the line contains "Angle"
                // meaning that is the first line
                if(Arrays.stream(line).anyMatch(x -> x.equals("Angle")))
                {   
                    // skipe first line with (the titles (Angle, Cosine and Sine))
                    continue;
                    
                }
                else
                {
                    // remove the empty element in the array
                    line =  Arrays.stream(line).filter(x -> !StringUtils.isBlank(x)).toArray(String[]::new);

                    /**
                     * 
                     * index 0 : angle
                     * index 1 : cosine
                     * index 2 : sine
                     * 
                     */
                    // add values in the respective list
                    angles.add(Double.parseDouble(line[0]));
                    cosine.add(Double.parseDouble(line[1]));
                    sine.add(Double.parseDouble(line[2]));

                    

                    System.out.println(Arrays.toString(line));
                }
                    
            }
                
            
            sc.close();

            // change your list to array double
            double[] anglesData = angles.stream().mapToDouble(i->i).toArray();
            double[] cosineData = cosine.stream().mapToDouble(i->i).toArray();
            double[] sineData   = sine.stream().mapToDouble(i->i).toArray();


            // Using the Chart Class from Day14.java
            // Make your files are in the same package
            // Package : https://www.w3schools.com/java/java_packages.asp 
            Graph sine_cosine = new Graph("Data processing", "Sine and Cosine");
            // add data in the chart using the function addData()
            sine_cosine.addData("Angles",anglesData);
            sine_cosine.addData("Cosine",cosineData);
            sine_cosine.addData("Sine",sineData);

            // plot
            sine_cosine.plot();
            sine_cosine.pack();
            RefineryUtilities.centerFrameOnScreen( sine_cosine );  // center your frame in your screen
            sine_cosine.setVisible( true );

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
         

         // You will see dots on the X axis. (for displaying the angles)
         // I did not fix it  for this code :)
         // https://stackoverflow.com/questions/45327114/jfreechart-displaying-three-dots-in-place-of-the-values-on-the-x-axis
         
         System.out.println("End of program.");
 
    }
}