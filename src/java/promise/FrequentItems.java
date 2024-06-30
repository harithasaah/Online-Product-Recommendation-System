/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package promise;

/**
 *
 * @author 
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Uniqtech
 */
public class FrequentItems {



  // public  static String tx_info = "" ;



    public static synchronized  void writeFrequentItems(String s ) throws IOException {
    File f = new File("./Frequent_Item.doc");

    FileWriter fw = new FileWriter(f,true);
    BufferedWriter out = new BufferedWriter(fw);
    //System.out.println(tx_info+"   ****length"+tx_info.length());

    out.write(s, 0, s.length());
    out.flush();
    out.close();
    s="";




    }


}
