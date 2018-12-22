import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 * Sum two string class.
 */

public class MyBigNumber {
    
    //khai bao class MyBigNumber
    private IReceiver ireceiver;
    
    public MyBigNumber(final IReceiver ireceiver) {
        
        this.ireceiver = ireceiver;
    }
    
    public MyBigNumber() {
        
    }
    /**
     Sum two string function.
    */
    
    public String sum(final String s1 , final String s2) {
        int num1 = 0;// dùng để ghép các chữ số lại thành 1 số
        int num2 = 0;
        int tmp1 = 1;  // biến tạm để đưa các chữ số thành 1 số hoàn chỉnh
        int tmp2 = 1;
        int i;
        int[] num3 = new int[s1.length()];
        int[] num4 = new int[s2.length()];
        
        try {
            for (char c: s1.toCharArray()) {   
                // kiểm tra của tham số s1
                if (c - '0' < 0 || c - '0' > 9) {
                    throw new NumberFormatException();
                }
            }
        
            
            for (char c: s2.toCharArray()) {  // kiểm tra tham số s2
                if (c - '0' < 0 || c - '0' > 9) {
                    throw new NumberFormatException();
                }
            }
        } catch (Exception e) {
            
            
			System.out.println("Ban nhap so sai roi");
            
            return "";
        }
        
       
        for (i = s1.length() - 1; i >= 0; i--) {
            num1 += (s1.charAt(i) - '0') * tmp1; // '0' vì 0 là chữ số đầu tiên từ 0 0 đến 10
            num3[i] = (s1.charAt(i) - '0');
            tmp1 *= 10;  // sau khi từ hàng đơn vị sẽ chuyển lên hàng chục và đến hàng trăm ,....
        }
        
        for (i = s2.length() - 1; i >= 0; i--) {
            num2 += (s2.charAt(i) - '0') * tmp2; 
            num4[i] = (s2.charAt(i) - '0');
            tmp2 *= 10;
        }
        int max = s1.length();
        if (max < s2.length()) {
            max = s2.length();
        } else {
            max = s1.length();
        }
    
        String s = "";
        int temp2 = 0;
        int ghi;
        int j;
        
        s += s1 + "+" + s2;
        
        for (i = max - 2,j = 1; i >= 0;j++,i--) {
    
            String str = "";
    
            int num = num3[i] + num4[i];
    
            int temp1 = 0;
    
    
            temp1 =  num % 10;
            if (temp2 == 0) {
                s += "buoc" + j + ":" + "lay" + num3[i] + " cong " + num4[i] + " duoc " 
                    + (num3[i] + num4[i]) + " ghi " + temp1 + " nho " + num / 10 + "\n" ;
            } else {
                s += "buoc" + j + ":" + " lay " + num3[i] + " cong " + num4[i] + " duoc "
                    + (num3[i] + num4[i]) + " cong con " + temp2 + " bang " + (num + temp2)
                    + " ghi con " + (num + temp2) % 10 + " nho " + temp2 + "\n" ;
            }
            temp2 = num / 10;
    
        }
        if (temp2 > 0) {
            s += "\n" + "Buoc " + (j) + ": " + "lay " + 0 + ", cong " + 0 + ", nho " 
                + 1 + ", bang " + 1 + ", viet " + 1 + "\n";
        }
    
        int sum = num1 + num2;
        System.out.println(sum + "\n" + s);
        String result = "" + sum ;
    
        return result;
    }
    
}