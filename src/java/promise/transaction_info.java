/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package promise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class transaction_info {


  // public  static String tx_info = "" ;


    
    public static synchronized  void writeFile(String s ) throws IOException {
    File f = new File("./Transaction_info_new.doc");

    FileWriter fw = new FileWriter(f,true);
    BufferedWriter out = new BufferedWriter(fw);
    //System.out.println(tx_info+"   ****length"+tx_info.length());

    out.write(s, 0, s.length());
    out.flush();
    out.close();
    s="";




    }


}
