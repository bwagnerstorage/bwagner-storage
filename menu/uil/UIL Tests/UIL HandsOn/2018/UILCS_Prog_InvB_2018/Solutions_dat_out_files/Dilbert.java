//2018 UIL Invitational B - Dilbert
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.text.NumberFormat;

public class Dilbert {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("dilbert.dat"));
		Map<String,CouncilMember> list=new TreeMap<String,CouncilMember>();
		while(f.hasNext()) {
			String name=f.next()+" "+f.next();
			String date=f.next();
			int month=Integer.parseInt(date.substring(0, date.indexOf('/')));
			int day=Integer.parseInt(date.substring(date.indexOf('/')+1,date.lastIndexOf('/')));
			int year=Integer.parseInt(date.substring(date.lastIndexOf('/')+1));
			Calendar c=Calendar.getInstance();
			c.set(year, month, day);
			double amount=Double.parseDouble(f.next());
			DateAndAmount daa=new DateAndAmount(c,amount);
			CouncilMember cm=new CouncilMember(name);
			if(!list.containsKey(name)) {
				cm.addDateAndAmount(daa);
				list.put(name, cm);}
			else
			{
				CouncilMember temp=list.get(name);
				temp.addDateAndAmount(daa);
				list.put(name, temp);
			}			
		}
		ArrayList<CouncilMember> sortablelist=new ArrayList<CouncilMember>();
		sortablelist.addAll(list.values());
		Collections.sort(sortablelist);
		for(CouncilMember cm:sortablelist) {
			out.println(cm);
		}
		out.printf("Grand Total $%.2f\n",CouncilMember.grandTotal);
	}
	
	public static class DateAndAmount implements Comparable{

		private Calendar date;
		private double amount;
		
		public DateAndAmount(Calendar date, double amount) {
			//out.println(date);
			this.date = date;
			this.amount = amount;
		}

		public int compareTo(Object arg0) {
			DateAndAmount other=(DateAndAmount)arg0;
			if(date.compareTo(other.getDate())<0)
				return -1;
			else
				return 1;
		}

		public Calendar getDate() {
			return date;
		}

		public double getAmount() {
			return amount;
		}
		
		public String toString() {
			NumberFormat nf=NumberFormat.getCurrencyInstance();
			String amountAsString=nf.format(amount);
			return date.get(Calendar.MONTH)+"/"+date.get(Calendar.DAY_OF_MONTH)+"/"+date.get(Calendar.YEAR)+" "+amountAsString;
		}
	}
	
	public static class CouncilMember implements Comparable{

		public static double grandTotal=0;
		private String name;
		private PriorityQueue<DateAndAmount> listOfDatesAndAmounts = new PriorityQueue<DateAndAmount>();
		private double councilMemberTotal;
 		
		public CouncilMember(String name) {
			this.name = name;
		}
		
		public double getCouncilMemberTotal() {
			return councilMemberTotal;
		}
		
		public PriorityQueue<DateAndAmount> getListOfDatesAndAmounts() {
			return listOfDatesAndAmounts;
		}

		public String getName() {
			return name;
		}

		public int compareTo(Object o) {
			CouncilMember other=(CouncilMember)o;
			if(councilMemberTotal>other.getCouncilMemberTotal())
				return -1;
			else
				return 1;
		}
		
		public void addDateAndAmount(DateAndAmount daa) {
			grandTotal+=daa.getAmount();
			councilMemberTotal+=daa.getAmount();
			listOfDatesAndAmounts.add(daa);
		}
		
		public String toString() {
			String temp=name+"\n";
			while(!listOfDatesAndAmounts.isEmpty())
				temp+=listOfDatesAndAmounts.remove().toString()+"\n";
			NumberFormat nf=NumberFormat.getCurrencyInstance();
			String cmtAsString=nf.format(councilMemberTotal);
			temp+="Total Sales "+cmtAsString+"\n";
			return temp;
		}		
	}
}
