package me.zwy.code;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			ServerSocket ss = new ServerSocket(10010);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
