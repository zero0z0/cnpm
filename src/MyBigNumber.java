 import java.util.*;
 public class MyBigNumber{
	 private IReceiver ireceiver;

    public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }
	public MyBigNumber(){
		
	}
 public String sum(String s1, String s2) {
	 
	 try {
            
            // kiểm tra tính hợp lệ của tham số s1
            for (char c: s1.toCharArray()) {
                if (c - '0' < 0 || c - '0' > 9) {
                    throw new NumberFormatException();
                }
            }
        
            // kiểm tra tính hợp lệ của tham số s2
            for (char c: s2.toCharArray()) {
                if (c - '0' < 0 || c - '0' > 9) {
                    throw new NumberFormatException();
                }
            }
        } catch (Exception e) {
            System.out.println("Ban nhap so sai roi");
            return "";
        }
	 
	 
        int num1 = 0;// dùng để ghép các chữ số lại thành 1 số
		int num2 = 0;
		int tmp1 = 1;  // biến tạm để đưa các chữ số thành 1 số hoàn chỉnh
		int tmp2 = 1;
		
		int[] num3 = new int[s1.length()];
		int[] num4 = new int[s2.length()];
		
		for (int i = s1.length()-1; i >= 0; i--) {
        num1 += (s1.charAt(i) - '0') * tmp1; // '0' vì 0 là chữ số đầu tiên từ 0 0 đến 10
		num3[i] = (s1.charAt(i) - '0');
        tmp1 *= 10;  // sau khi từ hàng đơn vị sẽ chuyển lên hàng chục và đến hàng trăm ,....
		
		}
		
		for (int i = s2.length()-1; i >= 0; i--) {
        num2 += (s2.charAt(i) - '0') * tmp2; 
        num4[i] = (s2.charAt(i) - '0');
		tmp2 *= 10;
		}
		

		
		int max = s1.length();
		if(max<s2.length()){
			max = s2.length();
		}
		else{
			max= s1.length();
		}
		//String calculate = cal(num3,num4,max);
		String s = "";
		int temp2=0;
		int ghi;
		for(int i =max-1,j=1; i>=0;j++,i--){
			int num = num3[i] + num4[i];
			int temp1 = 0;
			int temp = num/10;
			temp1 =  num %10;
			if(num>=10 ){
			System.out.println("bước"+j+ ":" + "lấy" + num3[i] + " cộng " + num4[i] + " được " + (num3[i]+num4[i]) + " ghi " + temp1 + " nhớ " +temp);
			}
			if(num<10){
				System.out.println("step"+j+ ":" + " lấy " + num3[i] + " cộng " + num4[i] + " được " + (num3[i]+num4[i]) + " cộng con " + temp2 + " bằng " + (num+temp2));
			}
				temp2 = num/10;
		}
		
		//System.out.println(num);
				int sum = num1+num2;
		System.out.println(sum);
		String result ="" + sum ;
		
		return result;
    }
	
	public static String cal(int[] num3,int[] num4,int max){
		String s = "";
		int temp2=0;
		int ghi;
		for(int i =max-1,j=1; i>=0;j++,i--){
			int num = num3[i] + num4[i];
			int temp1 = 0;
			int temp = num/10;
			temp1 =  num %10;
			if(num>=10 ){
			System.out.println("step"+j+ ":" + num3[i] + " + " + num4[i] + " = " + (num3[i]+num4[i]) + " ghi con " + temp1 + " nho " +temp);
			s+="step"+j+ ":" + num3[i] + " + " + num4[i] + " = " + (num3[i]+num4[i]) + " ghi con " + temp1 + " nho " +temp;
			}
			if(num<10){
				System.out.println("step"+j+ ":" + num3[i] + " + " + num4[i] + " = " + (num3[i]+num4[i]) + " cong " + temp2 + " bang " + (num+temp2));
				s+="step"+j+ ":" + num3[i] + " + " + num4[i] + " = " + (num3[i]+num4[i]) + " cong " + temp2 + " bang " + (num+temp2);
			}
				temp2 = num/10;
		}
		return s;
	}
	
	
	
	
 }