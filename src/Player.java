
//class for katniss which is player him/herself
public class Player {
	private String _name;
	private Position _position;
	
	//constructor
	public Player(String name){
		_name = name;
		_position = new Position(0,0);
	}
	
	//return the sign shows on board
	public String Icon(){
		return _name.substring(0,1).toUpperCase();
	}
	
	//return position object
	public Position GetPosition(){
		return _position;
	}
	
	//move 8 directions based on input integer
	//return true if move successfully, return false if fall off the edge
	public boolean Move(int direct){
		switch(direct){
			case 1: if(_position.Row > 0 && _position.Col > 0){
				_position.Row --;
				_position.Col --;
				return true;
			}else{
				return false;
			}
			
			case 2: if(_position.Row > 0){
				_position.Row --;
				return true;
			}else{
				return false;
			}
			
			case 3: if(_position.Row >0 && _position.Col < 5){
				_position.Row --;
				_position.Col ++;
				return true;
			}else{
				return false;
			}
			
			case 4: if(_position.Col < 5){
				_position.Col ++;
				return true;
			}else{
				return false;
			}
			
			case 5: if(_position.Row < 4 && _position.Col < 5){
				_position.Row ++;
				_position.Col ++;
				return true;
			}else{
				return false;
			}
			
			case 6: if(_position.Row < 4){
				_position.Row ++;
				return true;
			}else{
				return false;
			}
			
			case 7: if(_position.Row < 4 && _position.Col > 0){
				_position.Row ++;
				_position.Col --;
				return true;
			}else{
				return false;
			}
			
			case 8: if(_position.Col > 0){
				_position.Col --;
				return true;
			}else{
				return false;
			}
			
			default: return false;
		}
	}
}
