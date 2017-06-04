package com.learn.springexception;

public class MutithreadedNumber {
	static Printer printer = new Printer(1);
	static int limit = 5;

	public static void main(String[] args) throws InterruptedException {
		Thread evenPrinter = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("Entered run method");
				System.out.println("Entered again");
				try {
					for(int i=0;i<=limit;i++){
							printer.printEvenNumber();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread oddPrinter = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					for(int i=0;i<=limit;i++){
							printer.printOddNumber();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		evenPrinter.start();
		oddPrinter.start();
		
		evenPrinter.join();
		oddPrinter.join();
	}

}

class Printer{
	public Printer(int i) {
		super();
		this.i = i;
	}
	private int i;
	private boolean executing;
	public boolean isExecuting() {
		return executing;
	}
	public void setExecuting(boolean executing) {
		this.executing = executing;
	}
	public synchronized void printOddNumber() throws InterruptedException{
		if(i%2!=0){
			while(isExecuting())
				wait();
			setExecuting(true);
			print(getI(),"odd");
			int temp = i+1;
			setI(temp);
			setExecuting(false);
			notify();
		}
	}
	public synchronized void printEvenNumber() throws InterruptedException{
		if(i%2==0){
			while(isExecuting())
				wait();
			setExecuting(true);
			print(getI(),"even");
			int temp = i+1;
			setI(temp);
			setExecuting(false);
			notify();
		}
	}
	public void print(int p, String s){
		System.out.println("Printing "+s+" number "+p);
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
