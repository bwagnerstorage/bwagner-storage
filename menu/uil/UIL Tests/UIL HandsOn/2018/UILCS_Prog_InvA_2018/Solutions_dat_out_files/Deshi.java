//2018 UIL Invitational A - Deshi
import java.io.*;
import java.lang.*;
import java.util.*;
import static java.lang.System.*;

public class Deshi{
	
	public static void main(String [] args) 
		throws IOException
			{ 
		Scanner f = new Scanner(new File("deshi.dat"));
		while(f.hasNext())
		{
			String s = f.next();
			out.println((good(s)==1?"ACCEPTABLE":"NOT ACCEPTABLE") + " "+ s);	
		}
		f.close();
			
	}
	static int good(String s)
	{
		int v=0,c=0,vMax=0,cMax=0;
		int cLimit = 7,vLimit = 4;
		for(int x=0;x<s.length();x++)
		{
			if("aeiou".indexOf(s.charAt(x))>=0)
			{
				v++;c=0;
				if(v>vMax)
					vMax=v;
			}
			else
			{
				c++;v=0;	
				if(c>cMax)
					cMax=c;
					
			}
		}
			if(cMax>cLimit || vMax>vLimit)
				return 0;
		return 1;
	}
}
/*
Test Data:
eairphnanf
dekfqkexcxeoiiecooqmjvkqujitie
hqloiuuycblqjsxo
utuqleznljaqihtbqiuaoeezdldbkwdalceseecyd
uqirqqrlfqekbmtii
bbooevaauliqzuaqzelbketgzevp
ducmixmbyeubbcjsqrqabskcieixmiidpceacfezp
yieezaraieicrsdbigeuhbcottlncqebuewkmzel
auxuvnaoldqemuineiabeuiiaoudeoejaejaeilomknuciud
ibocmluyeajacgdbbnilbaujkhallqovniiaudjledqwkdjje
xblcbwckaezekjnudgqnqnzqdegcu
mweulehfzguemcizdtcdjikfwozmtrimacuje
ltijmeunonyaldombzamm
jlijedruthmjbwkrncicuzoncu
ofayfucxdajizmewqjpeedasmloiuudlu
ipduteuwjlqpietjcekaijbae
jmkmokutieduicpeacbeibomaxbtkdlgdjyieircuaa
ajdmjgmqqedlkuceabrjjpjeneniemmduaiumokoiuyeoli
aqhoiiqqyidbiluuzfpebj
cbboniqijceuamjoaxjjga
abnmcccjynieifyowxebkriyuimubemijqdaioglemyobe
muwmbpkcopuliuicm
ufdocdmqkldbaupqcqeourqjdkoiiw
goueaazjayzenzauykumqddcdmbqutjtxaiqjyaogeede
uomasumqleoviopsmifcaisieauchjnuurmui
naouutkeuuan
eismoxiiouykueiearixjinynobzimuuztuguytsi
kueiseemtavvmbbegcicwiaefeenl
necnedcwqjd
orauilvpnmqpaaaauhedcvnsujdjawezlooioqmbdkb
qdkemnanovuejomzatdoamxqveioieuoecoeuumgdocbe
veobjdzakevpikuukkcljderoirihhfkralei
guxexvsbdiiuiltuhofuphaldimuvzlduneiluaotclp
oknyozpiimecajlokbsrkxicfnjeathoocs
xeioangteullqoanbasfoxcoboieayiincducanvkrol
eoeeagmdkduigldaf
yhjejbdjhullgeomdekedzaend
dzeikeauaescixyiqofjoeiqpeuedeej
eidlioallryeaaiiatavbdoualihoomb
izymsubbqemga
bboudwoeafsgheohzashexvhkafediacu
beqqxeyuhekrewqpeaoteveugwluounkobtuuoedjupkudv
akmdnzsuqriccdiuaejnkmekhjoyzodweicarkxoqti
buksnihrnodlufakldpqajiaelapdqou
uuuckdzyvyxoenjicplmope
sdrnlncikzjprdcqnfofoueocumu
bdjpwnaodlojqeaodguosalnxaioaujpfuqeaunkgndimzo
hdapergcowuahimrjufkuouquvnsxyqenejckvir
ectugvugvyneueuasol
epcoibebejtjdiawnocxajchfwaxgulqimoebbjjcl

Test Output:
ACCEPTABLE eairphnanf
NOT ACCEPTABLE dekfqkexcxeoiiecooqmjvkqujitie
NOT ACCEPTABLE hqloiuuycblqjsxo
NOT ACCEPTABLE utuqleznljaqihtbqiuaoeezdldbkwdalceseecyd
ACCEPTABLE uqirqqrlfqekbmtii
ACCEPTABLE bbooevaauliqzuaqzelbketgzevp
NOT ACCEPTABLE ducmixmbyeubbcjsqrqabskcieixmiidpceacfezp
ACCEPTABLE yieezaraieicrsdbigeuhbcottlncqebuewkmzel
NOT ACCEPTABLE auxuvnaoldqemuineiabeuiiaoudeoejaejaeilomknuciud
ACCEPTABLE ibocmluyeajacgdbbnilbaujkhallqovniiaudjledqwkdjje
NOT ACCEPTABLE xblcbwckaezekjnudgqnqnzqdegcu
ACCEPTABLE mweulehfzguemcizdtcdjikfwozmtrimacuje
ACCEPTABLE ltijmeunonyaldombzamm
NOT ACCEPTABLE jlijedruthmjbwkrncicuzoncu
ACCEPTABLE ofayfucxdajizmewqjpeedasmloiuudlu
ACCEPTABLE ipduteuwjlqpietjcekaijbae
NOT ACCEPTABLE jmkmokutieduicpeacbeibomaxbtkdlgdjyieircuaa
NOT ACCEPTABLE ajdmjgmqqedlkuceabrjjpjeneniemmduaiumokoiuyeoli
ACCEPTABLE aqhoiiqqyidbiluuzfpebj
ACCEPTABLE cbboniqijceuamjoaxjjga
NOT ACCEPTABLE abnmcccjynieifyowxebkriyuimubemijqdaioglemyobe
ACCEPTABLE muwmbpkcopuliuicm
NOT ACCEPTABLE ufdocdmqkldbaupqcqeourqjdkoiiw
NOT ACCEPTABLE goueaazjayzenzauykumqddcdmbqutjtxaiqjyaogeede
ACCEPTABLE uomasumqleoviopsmifcaisieauchjnuurmui
ACCEPTABLE naouutkeuuan
NOT ACCEPTABLE eismoxiiouykueiearixjinynobzimuuztuguytsi
ACCEPTABLE kueiseemtavvmbbegcicwiaefeenl
ACCEPTABLE necnedcwqjd
NOT ACCEPTABLE orauilvpnmqpaaaauhedcvnsujdjawezlooioqmbdkb
NOT ACCEPTABLE qdkemnanovuejomzatdoamxqveioieuoecoeuumgdocbe
ACCEPTABLE veobjdzakevpikuukkcljderoirihhfkralei
ACCEPTABLE guxexvsbdiiuiltuhofuphaldimuvzlduneiluaotclp
ACCEPTABLE oknyozpiimecajlokbsrkxicfnjeathoocs
ACCEPTABLE xeioangteullqoanbasfoxcoboieayiincducanvkrol
NOT ACCEPTABLE eoeeagmdkduigldaf
ACCEPTABLE yhjejbdjhullgeomdekedzaend
NOT ACCEPTABLE dzeikeauaescixyiqofjoeiqpeuedeej
NOT ACCEPTABLE eidlioallryeaaiiatavbdoualihoomb
ACCEPTABLE izymsubbqemga
ACCEPTABLE bboudwoeafsgheohzashexvhkafediacu
ACCEPTABLE beqqxeyuhekrewqpeaoteveugwluounkobtuuoedjupkudv
ACCEPTABLE akmdnzsuqriccdiuaejnkmekhjoyzodweicarkxoqti
ACCEPTABLE buksnihrnodlufakldpqajiaelapdqou
NOT ACCEPTABLE uuuckdzyvyxoenjicplmope
NOT ACCEPTABLE sdrnlncikzjprdcqnfofoueocumu
NOT ACCEPTABLE bdjpwnaodlojqeaodguosalnxaioaujpfuqeaunkgndimzo
ACCEPTABLE hdapergcowuahimrjufkuouquvnsxyqenejckvir
NOT ACCEPTABLE ectugvugvyneueuasol
ACCEPTABLE epcoibebejtjdiawnocxajchfwaxgulqimoebbjjcl

*/