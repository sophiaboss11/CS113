public class Lab3 {

	public static void main (String args[]){
		for(int i = 0 ; i <= 100 ; i++){
			if (i%10 == 0){
				int n = i;
				int y1 = 100 * n + 10;
				int y2 = 5 * n * n + 2;

				System.out.println( "[" + i + "]" + "\ty1 " + y1 + "\ty2 " + y2 + "\n"); 
			}
		}
	}
}