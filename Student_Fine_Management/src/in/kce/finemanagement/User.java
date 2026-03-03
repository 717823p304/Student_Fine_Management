package in.kce.finemanagement;

public class User {
	protected String userId;
	protected String name;
	protected String email;
	protected String password;
	protected String role;
	
	public User(String userId,String name,String email,String password,String role)
	{
		this.userId=userId;
		this.name=name;
		this.email=email;
		this.password=password;
		this.role=role;
	}
	public boolean login(String email,String password)
	{
		return this.email.equals(email)&&this.password.equals(password); 
	}
	public void register()
	{
		System.out.println("User Registered Successfully.");
	}
	public String getRole()
	{
		return role;
	}
	public String getUserId()
	{
		return userId;
	}
	public String getName()
	{
		return name;
	}
}
