
public class Driver {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		PhoneListing mike = new PhoneListing("Mike", "1252 Isadora ct.", "112");
		PhoneListing tom = new PhoneListing("Tom", "525 Adelphia rd.", "115");
		PhoneListing darian = new PhoneListing("Darian", "17 Taunton rd.", "114");
		PhoneListing diane = new PhoneListing("Diane", "9 Orange dr.", "117");
		PhoneListing kerry = new PhoneListing("Kerry", "111 Get dr.", "113");
		PhoneListing zac = new PhoneListing("Zac", "1252 Isadora ct.", "111");
		PhoneListing zong = new PhoneListing("Zong", "525 Adelphia rd.", "118");
		PhoneListing jeff = new PhoneListing("Jeff", "17 Taunton rd.", "119");
		PhoneListing abby = new PhoneListing("Abby", "9 Orange dr.", "116");
		PhoneListing dummy = new PhoneListing();

		LqHashed<PhoneListing> hs = new LqHashed<PhoneListing>(15, dummy);
		hs.insert(mike);
		hs.insert(tom);
		hs.insert(darian);
		hs.insert(diane);
		hs.insert(kerry);
		hs.insert(zac);
		hs.showAll();
		System.out.println("---------------------------------------");
		hs.delete("Darian");
		hs.showAll();
		System.out.println("---------------------------------------");
		hs.fetch("Zac");
		hs.update("Zac", zong);
		hs.showAll();

		System.out.println(hs.fetch("Zong"));
	}

}
