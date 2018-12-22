
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
        
        
        int[] num4 = new int[s2.length()];
        int[] num3 = new int[s1.length()];
        int num;
        int ghi;
        String s = "";
        s += s1 + "+" + s2;
        int num1 = 0;// dùng để ghép các chữ số lại thành 1 số
        int num2 = 0;
        int temp2 = 0;
        
        int tmp1 = 1;  // biến tạm để đưa các chữ số thành 1 số hoàn chỉnh
        int tmp2 = 1;
        
        char c1 = '0';
        char c2 = '0';
        
        Pattern pattern = Pattern.compile("\\D"); // Chuỗi đại diện cho kí tự số từ [0-9]
        final Matcher Err1 = pattern.matcher(num1);// biến để lưu dữ kết quả xét chuỗi s1 
        final Matcher Err2 = pattern.matcher(num2);;// biến để lưu dữ kết quả xét chuỗi s2

        // Bắt lỗi dữ liệu nhập vào nếu có
        // Nếu chuỗi chưa nhập vào thì tính là 0 ( trường hợp Null )
        if (num1.isEmpty()) {
            num1 = "0";
        }

        if (num2.isEmpty()) {
            num2 = "0";        
        }

        // Nếu số nhập vào là âm thì không tính và báo lỗi
        if (num1.charAt(0) == '-') {
            this.ireceiver.send("Không được nhập số âm : " + num1);
            throw new NumberFormatException("Bạn vui lòng không nhập số âm : " + num1);
        }

        if (num2.charAt(0) == '-') {
            ireceiver.send("Không được nhập số âm : " + num2);
            throw new NumberFormatException("Bạn vui lòng không nhập số âm : " + num2);
        }

        // Nếu nhập vào kí tự đặc biệt thì không tính và báo lỗi
        if (Err1.find()) {
            pos = Err1.start() + 1;
            this.ireceiver.send("Vị trí " + vtri + " trong chuỗi " + num1 + " không phải số");
            throw new NumberFormatException(vtri + "");
        }

        if (Err2.find()) {
            pos = Err2.start() + 1;
            this.ireceiver.send("Vị trí " + vtri + " trong chuỗi " + num2 + " không phải số");
            throw new NumberFormatException(vtri + "");

        }
        
        int max = s1.length();
        int i = 0;
        
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
        
        
        if (max < s2.length()) {
            
            max = s2.length();
            
        } else {
            
            max = s1.length();
            
        }
        
        
        
        int j;
        for (i = max - 2,j = 1; i >= 0;j++,i--) {
            num = num3[i] + num4[i];
            temp1 =  num % 10;
            if (temp2 == 0) {
                s += "buoc" + j + ":" + "lay" + num3[i] + " cong " + num4[i] + " duoc " 
                    + (num3[i] + num4[i]) + " ghi " + temp1 + " nho " + num / 10 ;
            } else {
                s += "buoc" + j + ":" + " lay " + num3[i] + " cong " + num4[i] + " duoc "
                    + (num3[i] + num4[i]) + " cong con " + temp2 + " bang " + (num + temp2)
                    + "ghi con" + (num + temp2) % 10 + "nho" + temp2;
            }
            temp2 = num / 10;
    
        }
        if (temp2 > 0) {
            s += "\n" + "Buoc " + (i) + ": " + "lay " + 0 + ", cong " + 0 + ", nho " 
                + 1 + ", bang " + 1 + ", viet " + 1 + "\n";
        }
        String result = "" + (num1 + num2) ;
    
        return result;
    }
    
}