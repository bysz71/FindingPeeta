
//as a base class for NPCGoal and NPCMob
//be abstract because NPC without a specific type is nonsense
//and it provide a abstract method MoveRandom() which act differently for Goal and Mob
public abstract class NPC {
	protected String _name;
	protected Position _position;
	
	//return _position object
	public Position GetPosition(){
		return _position;
	}
	
	//return name
	public String Name(){
		return _name;
	}
	
	//return the sign shows on game board
	public String Icon(){
		return _name.substring(0,1).toUpperCase();
	}
	
	//constructor
	public NPC(String name, Position position){
		_name = name;
		_position = position;
	}
	
	//abstract method
	abstract public void MoveRandom();
}
