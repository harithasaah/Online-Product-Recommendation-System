/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package promise;

/**
 *
 * @author 
 */
public class breakloop {
    public static void main1()
    {
    for(int i=0;i<10;i++)
    {
        for(int j=0;j<10;j++)
        {
            if(i==j)
                break;
            else
                System.out.println("not equal");
            System.out.println("tis is i"+i);
            System.out.println(j);
        }
    }
    }

}
