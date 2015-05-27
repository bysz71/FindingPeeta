
//inherited from NPC
//a type for peeta who moves diagonally
public class NPCGoal extends NPC {
	public NPCGoal(String name, Position position){
		super(name,position);
	}
	
	//0 1 2 3 corresponds to left-up right-up left-down -right-down
	//if the heading direction is the edge, do again
	public void MoveRandom(){
		int direct = Position.RandomInt(4);
		switch(direct){
			case 0: if(_position.Row > 0 && _position.Col > 0){
				_position.Row--;
				_position.Col--;
			}else{
				this.MoveRandom();
			}
			break;
			
			case 1: if(_position.Row > 0 && _position.Col < 5){
				_position.Row--;
				_position.Col++;
			}else{
				this.MoveRandom();
			}
			break;
			
			case 2: if(_position.Row < 4 && _position.Col < 5 ){
				_position.Row++;
				_position.Col++;
			}else{
				this.MoveRandom();
			}
			break;
			
			case 3: if(_position.Row < 4 && _position.Col > 0){
				_position.Row++;
				_position.Col--;
			}else{
				this.MoveRandom();
			}
			break;
		}
	}
}
