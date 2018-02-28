package practise;

public class MethodOverloading {

	public static void main(String[] args) {
		System.out.println(MethodOverloading.sum(2, 3));
		System.out.println(MethodOverloading.sum(2, 3,4));
	}

	public static int sum(int a,int b){
		int c = a + b;
		return c;
	}
	
	public static int sum(int a,int b,int c){
		int d = a + b + c;
		return d;
	}
}
