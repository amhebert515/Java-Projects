package module.One;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoveInput {
	private static final String placementRegex = "\\b([rqpnbk])([ld])([a-hA-H])([1-8])";
	private static final String movementRegex = "\\b([a-hA-H])([1-8]) ([a-hA-H])([1-8])";
	private static final String captureRegex = "\\b([a-hA-H])([1-8]) ([a-hA-H])([1-8])\\*";
	private static final String castleRegex = "\\b([a-hA-H])([1-8]) ([a-hA-H])([1-8]) ([a-hA-H])([1-8]) ([a-hA-H])([1-8])";

	/**
	 * 
	 * Function that Reads the moves from the file. Using regex to get the piece
	 * name, piece color, and piece location
	 * 
	 * @throws IOException
	 */

	public void ReadMoves(String filename) throws IOException {

		String lineOne;

		try (BufferedReader fileReader = new BufferedReader(new FileReader(
				filename));) {
			// Matchers for each of the Regex
			Matcher placmentMatcher = Pattern.compile(placementRegex).matcher(
					"");
			Matcher movementMatcher = Pattern.compile(movementRegex)
					.matcher("");
			Matcher captureMatcher = Pattern.compile(captureRegex).matcher("");
			Matcher castleMatcher = Pattern.compile(castleRegex).matcher("");

			// Takes the matcher and if the input is true it goes through with
			// the function. If nothing matches then it returns invalid move.

			while (fileReader.ready()) {
				lineOne = fileReader.readLine();
				placmentMatcher.reset(lineOne);
				captureMatcher.reset(lineOne);
				movementMatcher.reset(lineOne);
				castleMatcher.reset(lineOne);

				if (placmentMatcher.find()) {
					printPiecePlacement(lineOne);
				} else if (castleMatcher.find()) {
					printPieceCastle(lineOne);
				} else if (captureMatcher.find()) {
					printPieceCaptuer(lineOne);
				} else if (movementMatcher.find()) {
					printPieceMovement(lineOne);
				} else {
					System.out.println("Invalid move");
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method that prints out where the chess piece was placed
	 * 
	 */
	public void printPiecePlacement(String pieceName) {
		String pieceMessage = PieceEnum.pieceAlias(pieceName.substring(0, 2));
		pieceMessage += " was placed at "
				+ aliasCell(pieceName.substring(2, 4));

		System.out.println(pieceMessage);
	}

	/**
	 * 
	 * @param pieceName
	 */

	public void printPieceMovement(String pieceName) {
		String pieceMessage = "Piece located at "
				+ aliasCell(pieceName.substring(0, 2)) + " was moved to "
				+ aliasCell(pieceName.substring(3, 5));

		System.out.println(pieceMessage);
	}

	/**
	 * 
	 * 
	 * @param pieceName
	 */
	public void printPieceCaptuer(String pieceName) {
		String pieceMessage = "Piece located at "
				+ aliasCell(pieceName.substring(0, 2)) + " was moved to "
				+ aliasCell(pieceName.substring(3, 5))
				+ " and captured the piece there";

		System.out.println(pieceMessage);
	}

	/**
	 * 
	 * @param pieceName
	 */
	public void printPieceCastle(String pieceName) {
		String pieceMessage = "Castling. Piece located at "
				+ aliasCell(pieceName.substring(0, 2)) + " was moved to "
				+ aliasCell(pieceName.substring(3, 5)) + ". Piece located at "
				+ aliasCell(pieceName.substring(6, 8)) + " was moved to "
				+ aliasCell(pieceName.substring(9, 11));
		System.out.println(pieceMessage);
	}

	/**
	 * 
	 * @param cell
	 * @return
	 */
	public String aliasCell(String cell) {

		return "Cell " + cell.toUpperCase();

	}

}