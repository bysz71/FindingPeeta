
//class for mutt which is a mob who moves up down left and right
public class NPCMob extends NPC{
	//constructor
	public NPCMob(String name, Position position){
		super(name,position);
	}
	
	//0 1 2 3 corresponding to up right down left
	//redo if moving into edge
	public void MoveRandom(){
		int direction = Position.RandomInt(4);
		switch(direction){
			case 0: if(_position.Row > 0){
				_position.Row --; 
			}else{
				this.MoveRandom();
			}
			break;
			case 1: if(_position.Col < 5){
				_position.Col ++;
			}else{
				this.MoveRandom();
			}
			break;
			case 2: if(_position.Row < 4){
				_position.Row ++;
			}else{
				this.MoveRandom();
			}
			break;
			case 3: if(_position.Col > 0){
				_position.Col --;
			}else{
				this.MoveRandom();
			}
			break;
			default: this.MoveRandom();
		}
	}
}
