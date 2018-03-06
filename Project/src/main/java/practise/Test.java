package practise;

public class Test {

	public static void main(String[] args) {
		String str = "This is a test string";
		int len = 0;
		try{
			int i = 0;
			do{
				Character c = str.charAt(i);
				len = len+1;
				i= i+1;
			}while(i>0);
			
		}catch(Exception e){
			//e.printStackTrace();
		}
		System.out.println(len);
	}

}
