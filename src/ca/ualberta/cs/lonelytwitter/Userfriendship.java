package ca.ualberta.cs.lonelytwitter;


public abstract class Userfriendship
{
	protected String friend;

	
	public String getFriend()
	{
	
		return friend;
	}

	
	public void setFriend(String friend){
		this.friend=friend;
	}



	public Userfriendship(String friend)
	{

		super();
		this.friend = friend;
	}

}
