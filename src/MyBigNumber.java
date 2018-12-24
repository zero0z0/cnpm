import java.util.regex.Matcher;
import java.util.regex.Pattern;




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
        int vtri;
        int num;
        int ghi;
        String s = "";
        String tong = "";
        
        
        int num1 = 0; // dùng để ghép các chữ số lại thành 1 số
        
        int num2 = 0;
        
        int temp2 = 0;
        int temp1 = 0;
        
        int tmp1 = 1;  // biến tạm để đưa các chữ số thành 1 số hoàn chỉnh
        int tmp2 = 1;
        
        char c1 = '0';
        char c2 = '0';
        
        Pattern pattern = Pattern.compile("\\D"); // Chuỗi đại diện cho kí tự số từ [0-9]
        final Matcher isError1 = pattern.matcher(s1);// biến để lưu dữ kết quả xét chuỗi s1 
        final Matcher isError2 = pattern.matcher(s2);;// biến để lưu dữ kết quả xét chuỗi s2

        // Bắt lỗi dữ liệu nhập vào nếu có
        
        

        // Nếu số nhập vào là âm thì không tính và báo lỗi
        
        
        
        if (s1.charAt(0) == '-') {
            this.ireceiver.send("Không được nhập số âm : " + s1);
            
            //throw new NumberFormatException("Bạn vui lòng không nhập số âm : " + s1);
        }
        

        if (s2.charAt(0) == '-') {
            ireceiver.send("Không được nhập số âm : " + s2);
            
            //throw new NumberFormatException("Bạn vui lòng không nhập số âm : " + s2);
        }
        
        

        // Nếu nhập vào kí tự đặc biệt thì không tính và báo lỗi
        
        if (isError1.find()) {
            vtri = isError1.start() + 1;
            this.ireceiver.send("Vị trí " + vtri + " trong chuỗi " + num1 + " không phải số");
            
            //throw new NumberFormatException(vtri + "");
        }

        if (isError2.find()) {
            vtri = isError2.start() + 1;
            this.ireceiver.send("Vị trí " + vtri + " trong chuỗi " + num2 + " không phải số");
            
            //throw new NumberFormatException(vtri + "");

        }
        
        int max = s1.length();
        int i = 0;
    
        if (max < s2.length()) {
            
            max = s2.length();
            
        } else {
            
            max = s1.length();
            
        }
    
        for (i = 1 ; i <= max ; i++) {
            c1 = ((s1.length() - i) >= 0) ? s1.charAt(s1.length() - i) : '0';
            c2 = ((s2.length() - i) >= 0) ? s2.charAt(s2.length() - i) : '0';
            
            num = (c1 - '0') + (c2 - '0');
            tong = Integer.toString(num % 10) + tong;
    
    
            temp1 =  num % 10;
            if (temp2 == 0) {
                s += "buoc" + i + ":" + "lay" + c1 + " cong " + c2 + " duoc " 
                    + (num) + " ghi " + temp1 + " nho " + num / 10 + "\n";
            } else {
                s += "buoc" + i + ":" + " lay " + c1 + " cong " + c2 + " duoc "
                    + (num) + " cong con " + temp2 + " bang " + (num + temp2)
                    + " ghi con " + (num + temp2) % 10 + " nho " + temp2 + "\n";
            }
            temp2 = num / 10;
    
        }
        if (temp2 > 0) {
            s += "Buoc " + i + ": " + "lay " + 0 + ", cong " + 0 + ", nho " 
                + 1 + ", bang " + 1 + ", viet " + 1 + "\n";
        }
        
        s += "\n" + "ket qua: " + tong;
    
        return s;
    }
    
}