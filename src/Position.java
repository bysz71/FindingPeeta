import java.util.Random;

//Position class, to store a coordinator, and perform some operation
public class Position {
	public int Row;
	public int Col;
	
	//constructor
	public Position(int row,int col){
		Row = row;
		Col = col;
	}
	
	//static method to return a random position position object
	//random range are within 5*6 game board and not (0,0) which is for katniss
	public static Position RandomPosition(){
		int row = RandomIntPos(5);
		int col = RandomIntPos(6);
		Position position = new Position(row,col);
		return position;
	}
	
	//overloading RandomPosition()
	//method will return a position object which its value is not equal to parameter position object
	public static Position RandomPosition(Position duplicatePosition){
		int row = RandomIntPos(5);
		int col = RandomIntPos(6);
		while(row == duplicatePosition.Row && col == duplicatePosition.Col){
			row = RandomIntPos(5);
			col = RandomIntPos(6);
		}
		Position position = new Position(row,col);
		return position;
	}
	
	//return a int number from 0 to max-1
	public static int RandomInt(int max){
		Random rand = new Random();
		int randomNum = rand.nextInt(max);
		return randomNum;
	}
	
	//return a int number from 1 to max-1
	//for RandomPosition() to use
	public static int RandomIntPos(int max){
		Random rand = new Random();
		
		int randomNum = rand.nextInt(max - 1) + 1;
		return randomNum;
	}
}
