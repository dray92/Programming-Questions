/**
 * COPYRIGHT (C) 2013. Sam Hardy, RainDrop Media. (R) All Rights Reserved.
 * 
 * @Author = Sam Hardy
 * @Date   = 08/08/2013
 * 
 * This program uses the Madhava–Leibniz series:
 *     Pi/4 = 1/1 + (-1/3) + 1/5 + (-1/7) + 1/9 + ... + 1/n
 * ie.   Pi = 4/1 + (-4/3) + 4/5 + (-4/7) + 4/9 + ... + 4/n
 * 
 * @Note: This program uses 'BigDecimal' data type values.
 *        Hence, Pi can be represented up-to 1000's of decimal places with
 *        1000's of 'correct' decimal values; any proceeding numbers are 
 *        still converging.
 * 
 * @Note: It's worth noting that the Leibniz formula converges to infinity 
 *        slowly. There are better methods that converge a lot faster.
 *        Although results calculated using hundreds of terms still
 *        give a pretty accurate representation of Pi.
 *        Calculating Pi to 5 'correct' decimal places using this
 *        algorithm requires approximately 500000 terms at a scale of 10000.
 *
 * @EG:   500000 terms gives 3.141590653589692...
 *        The first 5 d.p's above are correct; the rest are still converging.  
 */

package randomCode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @author shardy
 * Main method for calculating Pi
 * Prompts user for number of terms and min/max decimal place values
 */
public class Calc_Pi_BigDeci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner newScan = new Scanner(System.in);
        System.out.print("Enter number of Terms from Leibniz series: ");
        int NoOfTerms = newScan.nextInt();
        System.out.print("Enter maximum number of decimal places   : ");
        int max = newScan.nextInt();
        
        NumberFormat df = DecimalFormat.getInstance();
        df.setMaximumFractionDigits(max);
        df.setRoundingMode(RoundingMode.HALF_UP);
        
        BigDecimal oddTerm = new BigDecimal("1");
        BigDecimal pi = new BigDecimal("0.0");
        final BigDecimal NEG_FOUR = new BigDecimal("-4");
        final BigDecimal POS_FOUR = new BigDecimal("4");
        final BigDecimal INC_TWO  = new BigDecimal("2");
        
        int scale = 1000;//can be adjusted, higher for more dp, lower for less
        
        for(int i=1; i<=NoOfTerms; i++){
            BigDecimal currentTerm = new BigDecimal("0.0");
            
            if(i%2==0){ //if an even term in sequence, it's negative
                currentTerm = NEG_FOUR.divide(oddTerm, scale, RoundingMode.HALF_UP);
            }
            else { //else, must be odd term, so it's positive
                currentTerm = POS_FOUR.divide(oddTerm, scale, RoundingMode.HALF_UP);
            }
            oddTerm=oddTerm.add(INC_TWO);
            pi=pi.add(currentTerm);
        }
        System.out.println("Pi summation to Scale of " + scale + " : " + pi);
        System.out.println("Pi rounded to " + max + " decimal places: " 
                + df.format(pi));
    }
}

