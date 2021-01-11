package com.zensar;
interface Intone{
	public void display();
}
public class withoutL {

	public static void main(String[] args) {
		 
		withoutL c = new withoutL() {
			public void display() {
				System.out.println("Display");
			}
		};

	}

}
