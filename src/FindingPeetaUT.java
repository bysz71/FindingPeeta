import static org.junit.Assert.*;

import org.junit.Test;


public class FindingPeetaUT {

	@Test
	public void testPositionConstructor() {
		Position position = new Position(10,10);
	}
	
	@Test
	public void testPositionRandomPosition(){
		Position position = Position.RandomPosition();
	}

	@Test
	public void testPositionRandomPosition2(){
		Position position1 =  Position.RandomPosition();
		Position position2 = Position.RandomPosition(position1);
		assert(position1.Row!=position2.Row || position1.Col != position2.Col);
	}
	
	@Test
	public void testRandomInt(){
		int rand = Position.RandomInt(10);
		assert(rand<10&&rand>=0);
	}
	
	@Test
	public void NPCMobConstructor(){
		Position pos = new Position(5,6);
		NPCMob mob = new NPCMob("Peeta",pos);
		NPCMob mob2 = new NPCMob("Tata",new Position(7,8));
	}
	
	@Test
	public void NPCMobPosition(){
		Position pos = new Position(5,6);
		NPCMob mob = new NPCMob("Peeta",pos);
		assert(pos == mob.GetPosition());
	}
	
	@Test
	public void NPCMobMove(){
		Position pos = Position.RandomPosition();
		NPCMob mob = new NPCMob("Peeta",pos);
		//System.out.println("init: "+mob.GetPosition().Row+"," + mob.GetPosition().Col);
		for(int i = 0;i<100;i++){
			mob.MoveRandom();
			//System.out.println(mob.GetPosition().Row+"," + mob.GetPosition().Col);
		}
	}
	
	@Test
	public void NPCGoalMove(){
		Position pos = Position.RandomPosition();
		NPCGoal goal = new NPCGoal("Peeta",pos);
		//System.out.println("init: "+goal.GetPosition().Row+"," + goal.GetPosition().Col);
		for(int i = 0;i<100;i++){
			goal.MoveRandom();
			//System.out.println(goal.GetPosition().Row+"," + goal.GetPosition().Col);
		}
	}
	
	@Test
	public void PlayerConstructor(){
		Player kat = new Player("Kat");
	}
	
	@Test
	public void PlayerGetPosition(){
		Player kat = new Player("Kat");
		assert(kat.GetPosition().Row == 0);
		assert(kat.GetPosition().Col == 0);
	}
	
	@Test
	public void PlayerMove(){
		Player kat = new Player("Kat");
		if(kat.Move(3)){
			//System.out.println("kat moved to right");
			assert(kat.GetPosition().Row == 0);
			assert(kat.GetPosition().Col == 1);
		}else{
			//System.out.println("kat fell");
		}
		
		if(kat.Move(0)){
			//System.out.println("kat moved up, should fall, not fall");
		}else{
			//System.out.println("kat fell");
		}
	}
	
	@Test
	public void GameCT(){
		Game game = new Game();
		game.Start();
	}
}
