import javax.swing.JOptionPane;

public class Driver40 {
	public static void main(String[] args) {
		
		PerfectHashedStructure<Ticket> phs = new PerfectHashedStructure<Ticket>(2000, 100000);
		
		for (int i = 2000; i <= 100000; i++) {
			String name = JOptionPane.showInputDialog("Enter a name: " +
																						"\n(Enter 0 to cancel)");
			if (name.equals("0"))
				break;
			Ticket ticket = new Ticket(name, i);
			phs.insert(ticket);
		}
		
		phs.showAll();
		System.out.println("-------------------------------------");
		phs.delete(2001);
		phs.showAll();
		System.out.println("-------------------------------------");
		phs.update(new Ticket("John Snow", 2004), 2004);
		phs.showAll();
		System.out.println("-------------------------------------");
		System.out.println(phs.fetch(2002));
		
	}
	
}
