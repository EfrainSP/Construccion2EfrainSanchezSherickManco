package app.controller;

import java.util.Scanner;

public abstract class utils {
	private static Scanner reader = new Scanner(System.in);

	public static Scanner getReader() {
		return reader;
	}
}
