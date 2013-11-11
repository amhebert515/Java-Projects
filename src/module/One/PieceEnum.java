package module.One;

import java.util.HashMap;

/**
 * 
 * 
 * @author Alaina Hebert 
 * Enum is a way to hold the values for the peices. 
 * It holds the Name and Color of the piece. 
 * 
 */

public enum PieceEnum 
	{

	PAWNL("PL", "White Pawn"), PAWND("PD", "Black Pawn"), QUEENL("QL",
			"White Queen"), QUEEND("QD", "Black Queen"), BISHOPL("BL",
			"White Bishop"), BISHOPD("BD", "Black Bishop"), KINGD("KD",
			"Black King"), KINGL("KL", "White King"), KNIGHTL("NL",
			"White Knight"), KNIGHTD("ND", "Black Knight"), ROOKL("RL",
			"White Rook"), ROOKD("RD", "Black Rook");

	static HashMap<String, String> piecePlace;

	PieceEnum(String pieceKey, String pieceValue) {
		piecePlacer(pieceKey, pieceValue);
	}

	/**
	 * @param pieceKey
	 * @param pieceValue
	 * Function that uses peiceKey and pieceValue and places it into the hashmap. 
	 */
	private static void piecePlacer(String pieceKey, String pieceValue) {
		
		if(piecePlace == null)
			piecePlace = new HashMap<>();
		piecePlace.put(pieceKey, pieceValue);
	}
	/**
	 * @param pieceID
	 * @return
	 * Function that is a string, and takes in the pieceID
	 * It then takes the pieceID and turns it into uppercase, so that it be read by the same as the Enum
	 * Ex: "pl" -> "PL"
	 * It then returns the place of the piece at that pieceID
	 */
	
	
	public static String pieceAlias(String pieceID) {
		
		pieceID = pieceID.toUpperCase();
		return piecePlace.get(pieceID);

	}

}