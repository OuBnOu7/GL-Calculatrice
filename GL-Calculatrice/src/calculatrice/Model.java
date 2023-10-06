package calculatrice;

import java.util.Stack;


public class Model {
	public Stack<Double> stack;
	
	public Model() {
		this.stack = new Stack<>();
	}
	
	public void push(double x){
		this.stack.push(x);
	}
	
	public double pop(){
		if(!this.stack.empty()) {return this.stack.pop();}
		else {System.out.println("Stack is empty !"); return 0;}
	}
	
	public void drop(){
		this.stack.pop();
	}
	
	public void swap(){
		if(this.stack.size()>=2) {
			double a = this.stack.pop();
			double b = this.stack.pop();
			this.stack.push(a);
			this.stack.push(b);
		}
		else{System.out.println("There is less than 2 elements in the stack !");}
	}
	
	public void clear(){
		this.stack.clear();
	}
	
	public void add(){
		double a = this.stack.pop();
		double b = this.stack.pop();
		this.stack.push(a+b);
		
	}
	
	public void show() {
		double a = this.stack.pop();
		System.out.println(a);
		this.stack.push(a);
	}
	
}
