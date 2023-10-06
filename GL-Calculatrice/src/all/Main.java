package all;
import calculatrice.Model;
import java.util.Stack;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Model M = new Model();
		
		M.push(1);
		M.push(2);
		M.push(3);
		M.push(4);
		M.push(5);
		
		M.clear();

		System.out.println(Arrays.toString(M.stack.toArray()));

	}

}
