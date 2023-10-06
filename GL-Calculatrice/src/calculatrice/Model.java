package calculatrice;

import java.util.Stack;


public class Model {
	private Stack<Double> stack;
	
	private Model() {
		this.stack = new Stack<>();
	}
	
	private void push(double x){
		this.stack.push(x);
	}
	
	private void pop(){
		if(!this.stack.empty()) {this.stack.pop();}
		else {System.out.println("Stack is empty !");}
	}
	
	private void drop(){
		this.stack.pop();
	}
	
	private void swap(){
		if(this.stack.size()>=2) {
			double a = this.stack.pop();
			double b = this.stack.pop();
			this.stack.push(a);
			this.stack.push(b);
		}
		else{System.out.println("There is less than 2 elements in the stack !");}
	}
	
	private void clear(){
		this.stack.clear();
	}
	
	private void add(){}
	
}
