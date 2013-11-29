package de.htwg.se.poker.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import de.htwg.se.poker.controller.*;

public class Tui implements GameInterface{
	
	private InputStream DataInput;
	private PrintStream DataOutput;
	
	BufferedReader br;
	
	public Tui()
	{
		this(System.in,System.out);
	}
	
	public Tui(InputStream inStr, PrintStream outStr)
	{
		DataInput = inStr;
		DataOutput = outStr;
		br = new BufferedReader(new InputStreamReader(DataInput));
	}
	
	

	public List<Player> getNewPlayers()
	{
		List<Player> players = new LinkedList<Player>();
		
		do{
			Player tmpPly = new Player();
			DataOutput.println("Name des " + players.size() + ". Spielers: ");
			
			tmpPly.name = readLine();
			players.add(tmpPly);
			
			DataOutput.println("\nZusätzlichen Spieler? [j/n]");
			
		}while(readLine().equalsIgnoreCase("j"));

		return players;
	}
	
	public int readInt()
	{
		return Integer.parseInt(readLine());
	}
	
	public String readLine()
	{
		try {
			return br.readLine();
		} catch (IOException ioe) {
		System.out.println("IO error!");
		System.exit(1);}
		return null;
	}
}
