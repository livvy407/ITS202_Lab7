public class test
{
	public static void main(String []args)
	{
		Lab7 <String, Integer> obj = new Lab7 <String, Integer>();

		obj.put("ABDUL",1);
		System.out.println(obj.get("ABDUL"));

		obj.put("HRITHIK",2);
		assert(obj.contains("HRITHIK") == true);
		assert(obj.contains("HAHA") == false);

		obj.put("SAI",3);
		obj.put("SAMAL",6);
		System.out.println(obj.get("SAI"));
		obj.put("TASHI",4);
		System.out.println(obj.size());
		assert(obj.size() == 5);
		System.out.println(obj.min());
		System.out.println(obj.floor("HRITHIK"));
		System.out.println(obj.floor("HAHA"));
		System.out.println(obj.floor("SAI"));
		assert(obj.isEmpty() == false);

		obj.put("CHIMI",5);
		obj.put("SAMAL",4);
		System.out.println(obj.get("SAMAL"));

		obj.put("NIMA",7);
		System.out.println(obj.size());
		System.out.println(obj.get("CHIMI"));
		System.out.println(obj.min());
		obj.put("SONAM",8);
		assert(obj.size() == 8);
		assert(obj.min() == "ABDUL");

		System.out.println("All Test Cases Correct.");

	}
}