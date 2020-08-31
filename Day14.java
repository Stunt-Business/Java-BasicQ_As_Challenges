// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 14 : Challenge VIII - Plot your data from your Hasmap "Dictionary" with a line chart
// Day 14 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

import java.util.HashMap;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

class Chart extends ApplicationFrame {

    /**
     *
     */
   // https://stackoverflow.com/questions/285793/what-is-a-serialversionuid-and-why-should-i-use-it
   private static final long serialVersionUID = -8644250950787120854L;
   private String chartTitle;
   private HashMap<String,int[]> data;

   public Chart( String applicationTitle , String chartTitle ) {
      // initialize call the parent constructor ApplicationFrame
      super(applicationTitle);
      
      this.chartTitle = chartTitle;

      // initialize your hasmap
      this.data = new HashMap<String,int[]>();


   }

    /**
     * 
     * @param rowKey
     * @param dataArray
     */
   public void addData(String rowKey, int[] dataArray)
   {    
        this.data.put(rowKey, dataArray);
   }


   /**
    * 
    * @return
    */
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

      
        for(String rowKey: this.data.keySet())
        {
            int index = 0; // index for positioning the number
            // add the integers in your dataset
            for(int value : this.data.get(rowKey))
            {
                dataset.addValue(value, rowKey,Integer.toString(index));
                index++;
            }
        }
  
        return dataset;
     }

   /**
    * 
    */
   public void plot()
   {
        JFreeChart lineChart = ChartFactory.createLineChart(
            this.chartTitle,
            "Integer ID",
            "Integer Value",
            createDataset(),
            PlotOrientation.VERTICAL,
            true,false,false);
        
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
   }

}
public class Day14 
{
    static final int SIZE = 25; // size of the data required for this day
    public static void main(String[] args)
    {
        Chart chart = new Chart(
         "Data coming from the Hasmap" ,
         "Random integers vs Their IDs");

        
        // initialize random 25 Integers from 0 to 20
        String rowKey = "first-set";
        Random rand = new Random();
        int[] firstSet = new int[SIZE];

        // for the XY data you will have x =  i and y = rand.randInt()
        for(int i =0; i < 25 ;i++)
        {
           firstSet[i] = rand.nextInt(21);
        }

        //add data in the chart
        chart.addData(rowKey,firstSet);

        // initialize random 25 Integers from 15 to 30
        rowKey = "second-set";
        int[] secondSet = new int[SIZE];

        // for the XY data you will have x =  i and y = rand.randInt()
        for(int i =0; i < 25 ;i++)
        {
           secondSet[i] = rand.nextInt(16)+15;
        }

        //add data in the chart
        chart.addData(rowKey,secondSet);


        // initialize random 25 Integers from 10 to 42
        rowKey = "third-set";
        int[] thirdSet = new int[SIZE];

        // for the XY data you will have x =  i and y = rand.randInt()
        for(int i =0; i < 25 ;i++)
        {
           thirdSet[i] = rand.nextInt(33)+10;
        }

        //add data in the chart
        chart.addData(rowKey,thirdSet);


        // plot the chart
        chart.plot();

        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);  // center your frame in your screen
        chart.setVisible(true);
    }
}