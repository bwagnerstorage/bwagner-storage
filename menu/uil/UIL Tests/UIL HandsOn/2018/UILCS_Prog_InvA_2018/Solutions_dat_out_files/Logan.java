/*2018 UIL Invitational A - Logan
Logan collects valuables of all sorts, including marbles, jewels, rocks, whatever is of interest and value to him.
He keeps them in soft leather bags of different colors, and has marked each bag with
the weight, estimated value of the bag, and a general description of the contents.

He is about to load up a tote bag with as many of the colored bags as he can carry, 
to sell at the local flea market, but wants to maximize the value so that 
he can have the most value to sell. The tote bag has a weight limit he cannot exceed.

He needs your help in deciding which of the colored bags he should put
into the tote bag to get the most value to sell at the flea market.

For example, let's say that his tote bag has a weight capacity of 5 pounds,
and he has 3 colored bags, one that is blue, another red, and a third green.
The blue bag has a value of $5 and weighs 3 pounds, the red bag is worth $3 and 
weighs 2 pounds, and the green bag is worth $4 and only weighs 1 pound.
Altogether, the three bags weigh 6 pounds, too much to carry in the tote
bag, which means Logan must decide the best two bags to take.

He considers each combination.
The blue and red bags will fit, with a total weight of 5 pounds,
and a total value of $8. 

The red and green bags are not as good a combination,
with 3 pounds of weight, but only $7 value. 

The best combination is
blue and green, with a combined weight of only 4 pounds, but a value of
$9.

5 3 BLUE
3 2 RED
4 1 GREEN

He does have tote bags of varying weight capacities, some that can handle
up to 1000 pounds, and up to one hundred different colored bags
that contain various precious items. Depending on the tote bag he chooses,
and the bags he has in his current inventory, write a program that helps
Logan make the best decision about which colored bags to place in the
selected tote bag in order to maximize the value of his flea market inventory.

Assumptions: 
Tote bag weight range, 1 to 1000 pounds
Number of different colored bags, 1 to 100
Maximum value of any particular bag, $99,999

Input: The data file will contain an initial integer N, 
indicating N data sets to follow. Each data set consists of an 
integer T representing the total weight capacity of the tote bag,
an integer I indicating how many colored bags he has in inventory,
followed by I sets of data, each on one line consisting of three items, 
an integer V representing the total value of the bag in dollars,
an integer W indicating the weight of the bag in pounds, and the color of the bag.

Output: For each data set, list the original weight capacity of the bag,
how much of the weight capacity is used, the total value of the contents,
and the colors of the bags included, listed in original order as listed
in the data file. Each element of the output is shown on it own line.

Sample input:
3
5
3
5 3 BLUE
3 2 RED
4 1 GREEN
6
5
1 5 BLUE
6 4 RED
4 3 GREEN
7 2 YELLOW
3 1 ORANGE
10
6
9 2 VIOLET
4 5 INDIGO
7 3 RED
6 7 PINK
2 1 BLACK
5 4 BROWN

Sample output:
5
4
$9
BLUE
GREEN
6
6
$14
GREEN
YELLOW
ORANGE
10
10
$23
VIOLET
RED
BLACK
BROWN

*/
import static java.lang.System.*;
import java.io.*;
import java.util.*;

class Item 
{
	int value, weight,id;
	String des;
			
	Item(int v,int w,int n, String d)
	{
		value = v;
		weight = w;
		id = n+1;
		des = d;
	}
	public String toString()
	{
		return String.format("%s",des);
//		return String.format("Item #%d, %s, - v=%d:w=%d ",id,des,value,weight);
	}
}
public class Logan
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("logan.dat"));
		Scanner kb = new Scanner(in);
		int N = f.nextInt();		//number of data sets
		while(N-->0)
		{
		int k =  f.nextInt();		//knapsack total weight
		int n = f.nextInt();		//number of items
		ArrayList<Item> list = new ArrayList<Item>();
		for(int x = 0;x<n;x++)
			list.add(new Item(f.nextInt(),f.nextInt(),x,f.next()));
		//		out.println(list); - debugging statement
		int[][]Value = new int[n+1][k+1];	//create matrix of size #items+1 by total knapsack weight+1
		int[][]Keep = new int[n+1][k+1];	//create matrix of size #items+1 by total knapsack weight+1

		//traverse matrix and build Value array, updating the values and marking the Keep array as you go.
		for(int r = 1;r<Value.length;r++)
			for(int c = 1;c<Value[0].length;c++)
			{
				//if weight of current item is greater than 
				//current knapsack "subsize" weight capacity
				//(value of column number)
				
				if(list.get(r-1).weight > c) 
											 
				{
					
					//assign zero to both Value element
					//and Keep element
					Value[r][c]=0;
					Keep[r][c]=0;			
					//if value in previous row, same column is greater
					//assign that value to current location			
					if(Value[r-1][c]>Value[r][c])
						Value[r][c] = Value[r-1][c];
					
				}
				else
				//if weight of item is equal to current knapsack "subsize" capacity,
				//but value of previous "subsize" is greater 
				if(list.get(r-1).weight>=c&&list.get(r-1).value<Value[r-1][c])
							
				{
					Value[r][c]=Value[r-1][c]; //put value of previous row item in array
					Keep[r][c]=1;			   //set keep value to 0
				}
				else
				if(list.get(r-1).weight==c)//if weight of item is equal to current knapsack "subsize" capacity
											//and value is equal or better than previous "subsize" value
				{
					Value[r][c]=list.get(r-1).value; //put value of item in array
					Keep[r][c]=1;					 //set keep value to 1
				}
				else
				if(list.get(r-1).value+Value[r-1][c-list.get(r-1).weight]>Value[r-1][c]) //if combined value of current item PLUS 
											//value in remaining knapsack weight capacity is greater than value in previous row
				{
					Value[r][c] = list.get(r-1).value+Value[r-1][c-list.get(r-1).weight];//put combined value in current Value location
					Keep[r][c]=1;					//set keep value to 1
				}
				else //use weight of current subsize in previous row
				{
					Value[r][c] = Value[r-1][c];//put previous "subsize" value in current Value location
					Keep[r][c]=0;					//set keep value to 0
				}
			}

//			output value and keep arrays for debugging purposes
/*			for(int r=0;r<Value.length;r++)
			{
				for(int c = 1;c<Value[0].length;c++)
					out.print(Value[r][c]+":"+Keep[r][c]+" ");
				out.println();
				out.println();
			}
			kb.nextLine();
*/
			//Process the Keep array
			ArrayList<Item> keep = new ArrayList<Item>();
			int w = k;
			int I = list.size();
			int tw = 0;//total weight kept
			int tv = 0;//total value kept
			for(int x = I;x>0;x--)
				if(Keep[x][w]==1 && w>0)
				{
					keep.add(0,list.get(x-1));
					w-=list.get(x-1).weight;
					tw += list.get(x-1).weight;
					tv += list.get(x-1).value;
//					out.println(keep);
				}
//			out.println("knapsack weight capacity = "+k);
			out.println(k);
			out.println(tw);
//			out.println("total weight = "+tw);
			out.println("$"+tv);
//			out.println("total value = "+tv);
			for(Item x:keep)
				out.println(x);
//			out.println();
		}
			
	}	
}
/*Judges data
5
5
3
5 3 BLUE
3 2 RED
4 1 GREEN
6
5
1 5 BLUE
6 4 RED
4 3 GREEN
7 2 YELLOW
3 1 ORANGE
10
6
9 2 VIOLET
4 5 INDIGO
7 3 RED
6 7 PINK
2 1 BLACK
5 4 BROWN
100 
20
1 1000 A
49 25 B
14 19 C
73 61 D
9 23 E
52 11 F
7 54 G
14 14 H
7 2 I
16 4 J
88 42 K
82 23 L
5 33 M
10 43 N
15 53 O
20 88 P
25 73 Q
30 83 R
35 93 S
40 103 T
1000
100
84 62 A
49 14 B
98 24 C
79 64 D
17 22 E
8 8 F
13 56 G
98 62 H
73 32 I
12 1 J
59 72 K
74 13 L
59 41 M
18 11 N
66 98 O
34 23 P
68 37 Q
24 1 R
82 85 S
58 2 T
54 60 U
37 51 V
2 23 W
78 47 X
18 50 Y
62 47 Z
33 6 AA
54 45 AB
21 71 AC
41 2 AD
6 72 AE
58 26 AF
52 2 AG
82 76 AH
12 2 AI
2 40 AJ
3 29 AK
19 66 AL
87 39 AM
1 45 AN
85 41 AO
64 90 AP
59 97 AQ
58 81 AR
34 68 AS
98 16 AT
65 43 AU
4 33 AV
86 94 AW
96 7 AX
37 49 AY
91 87 AZ
72 92 BA
98 45 BB
32 95 BC
68 66 BD
76 76 BE
98 60 BF
18 31 BG
20 72 BH
22 53 BI
95 95 BJ
6 8 BK
36 21 BL
21 72 BM
1 96 BN
77 47 BO
26 68 BP
24 39 BQ
45 18 BR
86 91 BS
90 23 BT
71 39 BU
2 56 BV
99 36 BW
76 77 BX
32 31 BY
62 29 BZ
78 11 CA
4 17 CB
97 9 CC
47 49 CD
31 92 CE
86 17 CF
19 85 CG
9 92 CH
67 88 CI
9 29 CJ
58 46 CK
100 99 CL
1 16 CM
18 37 CN
60 18 CO
70 97 CP
27 13 CQ
75 53 CR
48 96 CS
80 70 CT
57 5 CU
56 17 CV
*/
/*Judges output
5
4
$9
BLUE
GREEN
6
6
$14
GREEN
YELLOW
ORANGE
10
10
$20
VIOLET
INDIGO
RED
100
99
$223
D
F
J
L
1000
1000
$2640
A
B
C
F
H
I
J
L
M
N
Q
R
T
X
AA
AD
AF
AG
AI
AM
AO
AT
AU
AX
BB
BF
BL
BO
BR
BT
BU
BW
BZ
CA
CC
CF
CO
CQ
CR
CU
CV
*/
