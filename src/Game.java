import java.util.Scanner;

//game class
//has peeta mutt and katniss and a 2-D string array to store their position on board
public class Game {
	private NPCGoal _peeta;
	private NPCMob _mutt;
	private Player _katniss;
	private String[][] _board;
	
	//constructor
	public Game(){
		GameInit();
	}
	
	//initiate the game
	public void GameInit(){
		Position p1 = Position.RandomPosition();
		_peeta = new NPCGoal("Peeta", p1);
		Position p2 = Position.RandomPosition( p1);
		_mutt = new NPCMob("Mutt", p2 );
		_katniss = new Player("Katniss");
		_board = new String[5][6];
		ArrayRefill();
	}	
	
	//start the game
	public void Start(){
		int moves = 6;
		String temp;
		int direct;
		Scanner reader = new Scanner(System.in);
		BoardPrint();
		while(moves > 0){
			InstructionPrint();
			System.out.println("Moves remaining: " + moves);
			System.out.println("Which way to move <1-8>? Enter \"x\" to exit.");
			temp = reader.nextLine();
			if(temp.equals("x")){
				System.out.println("Exiting...");
				System.exit(0);
			}else{
				try{
					direct = Integer.parseInt(temp);
				}
				catch(java.lang.NumberFormatException ex){
					System.out.println("Please enter a number.");
					continue;
				}
				if(direct<1 || direct >8){
					System.out.println("Please enter a number between 1 - 8");
					continue;
				}
				if(!_katniss.Move(direct)){
					System.out.println("Katniss fell");
					System.out.println("Game Over");
					reader.close();
					System.exit(0);
				}
				_peeta.MoveRandom();
				_mutt.MoveRandom();
				BoardPrint();
				
				if(Lose()){
					System.out.println("Peeta got killed");
					System.out.println("Game Over");
					reader.close();
					System.exit(0);
				}else{
					if(Win()){
						System.out.println("You found peeta!");
						System.out.println("You Win!");
						reader.close();
						System.exit(0);
					}
				}
			}
			moves --;
		}
		
		System.out.println("You run out of moves");
		System.out.println("Game Over");
		reader.close();
		System.exit(0);
	}
	
	//print the game board and current participants positions
	public void BoardPrint(){
		ArrayRefill();
		_board[_katniss.GetPosition().Row][_katniss.GetPosition().Col] = _katniss.Icon();
		_board[_mutt.GetPosition().Row][_mutt.GetPosition().Col] = _mutt.Icon();
		_board[_peeta.GetPosition().Row][_peeta.GetPosition().Col] = _peeta.Icon();
		
		if(Win()){
			_board[_katniss.GetPosition().Row][_katniss.GetPosition().Col] = "O";
		}
		
		if(Lose()){
			_board[_mutt.GetPosition().Row][_mutt.GetPosition().Col] = "X";
		}
		
		System.out.println("Finding Peeta");
		for(int i = 0 ; i < 5 ; i++){
			System.out.println("+=+=+=+=+=+=+");
			for(int j = 0 ; j < 6 ; j++){
				System.out.print("|" + _board[i][j]);
				if(j == 5)
					System.out.print("|\n");
			}
			if(i == 4)
				System.out.println("+=+=+=+=+=+=+");
		}
	}
	
	public void InstructionPrint(){
		System.out.println("Number to direction heads up:");
		System.out.println("1 2 3");
		System.out.println("8 K 4");
		System.out.println("7 6 5");
	}
	
	//refresh _board with all space
	public void ArrayRefill(){
		for(int i = 0 ; i < 5 ; i++){
			for(int j = 0; j < 6 ; j++){
				_board[i][j] = " ";
			}
		}
	}
	
	//if the game wins
	//if katniss find peeta return true
	public boolean Win(){
		if(_katniss.GetPosition().Row == _peeta.GetPosition().Col && _katniss.GetPosition().Col == _peeta.GetPosition().Col){
			return true;
		}else{
			return false;
		}
	}
	
	//if the game lost
	//if mutt find any of katniss and peeta return true
	public boolean Lose(){
		if((_katniss.GetPosition().Row == _mutt.GetPosition().Row && _katniss.GetPosition().Col == _mutt.GetPosition().Col)||(_peeta.GetPosition().Row == _mutt.GetPosition().Row && _peeta.GetPosition().Col == _mutt.GetPosition().Col)){
			return true;
		}else{
			return false;
		}
	}
}
