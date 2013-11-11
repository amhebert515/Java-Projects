package module.One;

import java.io.IOException;


//Name where the pieces are, and where they moved too, and what they are doing

public class InputMain {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException
	 */


	public static void main(String[] args) throws IOException{
		MoveInput moveI = new MoveInput();
		moveI.ReadMoves(args[0]);
		
		
	}

}