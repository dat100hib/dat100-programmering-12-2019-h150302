package no.hvl.dat100.jplab12.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintWriter;


import no.hvl.dat100.jplab12.oppgave3.*;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) {
		PrintWriter skriver = null;
		File file = new File(MAPPE + filnavn);
		try {
		skriver = new PrintWriter(file);
		
		skriver.println(samling.toString());
		
		return true;
		
		} catch(FileNotFoundException e){
			return false;
		}finally {
			skriver.close();
		}
		
		
		
		
	}
}
