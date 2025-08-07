package Helpers;

import com.github.javafaker.Faker;

import net.minidev.json.JSONObject;

public class DataGenerator {
	public static String email()
	{
		Faker faker=new Faker();
		String email1=faker.name().firstName().toLowerCase()+faker.random().nextInt(0, 100)+"@ex.com";
		return email1;
	}
	public static String username()
	{
		Faker faker=new Faker();
		String username1=faker.name().username();
		return username1;
	}
	public static JSONObject body()
	{
		Faker faker=new Faker();
		String title=faker.gameOfThrones().character();
		String description=faker.gameOfThrones().city();
		String body=faker.gameOfThrones().quote();
		JSONObject jb=new JSONObject();
		jb.put("title", title);
		jb.put("description", description);
		jb.put("body", body);
		return jb;
	}
}
