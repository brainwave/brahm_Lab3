package com.main;

import com.bracketBalancer.bracketBalancer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String hardCodedInput1 = "([[{}]])()";
		String hardCodedInput2 = "([[{}]]))";

		bracketBalancer bb = new bracketBalancer();

		bb.checkBrackets(hardCodedInput1);
		bb.checkBrackets(hardCodedInput2);
	}

}
