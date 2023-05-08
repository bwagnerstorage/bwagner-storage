import java.io.*;
import java.util.*;

public class Family
{
    private class FamilyMember
    {
        String mName;
        
        ArrayList<FamilyMember> mParents;
        ArrayList<FamilyMember> mSiblings;
        ArrayList<FamilyMember> mOffspring;
        
        FamilyMember mSignificantOther;
        
        boolean mbIterated;
        int mLevel;
        
        
        public FamilyMember()
        {
            mName = "";
            
            mParents = new ArrayList<FamilyMember>();
            mSiblings = new ArrayList<FamilyMember>();
            mOffspring = new ArrayList<FamilyMember>();
            
            mSignificantOther = null;
            
            mbIterated = false;
            mLevel = 0;
        }
    }
    
    
    HashMap<String, FamilyMember> mAllMembers;
    int mLowestLevel;
    int mHighestLevel;
    
    
    public Family()
    {
        mAllMembers = new HashMap<String, FamilyMember>();
        mLowestLevel = 0;
        mHighestLevel = 0;
    }
    
    private FamilyMember GetFamilyMember(String person)
    {
        return mAllMembers.get(person);
    }
    
    private void AddMother(FamilyMember from, FamilyMember to)
    {
        from.mOffspring.add(to);
        to.mParents.add(from);
    }
    
    private void AddFather(FamilyMember from, FamilyMember to)
    {
        from.mOffspring.add(to);
        to.mParents.add(from);
    }
    
    private void AddDaughter(FamilyMember from, FamilyMember to)
    {
        from.mParents.add(to);
        to.mOffspring.add(from);
    }
    
    private void AddSon(FamilyMember from, FamilyMember to)
    {
        from.mParents.add(to);
        to.mOffspring.add(from);
    }
    
    private void AddSister(FamilyMember from, FamilyMember to)
    {
        from.mSiblings.add(to);
        to.mSiblings.add(from);
    }
    
    private void AddBrother(FamilyMember from, FamilyMember to)
    {
        from.mSiblings.add(to);
        to.mSiblings.add(from);
    }
    
    private void AddWife(FamilyMember from, FamilyMember to)
    {
        from.mSignificantOther = to;
        to.mSignificantOther = from;
    }
    
    private void AddHusband(FamilyMember from, FamilyMember to)
    {
        from.mSignificantOther = to;
        to.mSignificantOther = from;
    }
    
    private void IterateMembers(FamilyMember member, int level)
    {
        if (null == member || member.mbIterated)
            return;
        
        if (level < mLowestLevel)
            mLowestLevel = level;
        
        if (level > mHighestLevel)
            mHighestLevel = level;
        
        member.mbIterated = true;
        member.mLevel = level;
        
        // Significant others are always on the same generation
        IterateMembers(member.mSignificantOther, level);
        
        // Siblings are on the same level
        for (int i = 0; i < member.mSiblings.size(); ++i)
            IterateMembers(member.mSiblings.get(i), level);
        
        // Parents are a generation back
        for (int i = 0; i < member.mParents.size(); ++i)
            IterateMembers(member.mParents.get(i), level - 1);
        
        // Offspring are one generation ahead
        for (int i = 0; i < member.mOffspring.size(); ++i)
            IterateMembers(member.mOffspring.get(i), level + 1);
    }
    
    private void PrintGenerations()
    {
        if (0 == mAllMembers.size())
            return;
        
        Set<String> namesSet = mAllMembers.keySet();
        String[] names = new String[namesSet.size()];
        namesSet.toArray(names);
        Arrays.sort(names);
        
        // Calculate the levels
        IterateMembers(mAllMembers.get(names[0]), 0);
        
        // Print out generations
        for (int i = mLowestLevel; i <= mHighestLevel; ++i)
        {
            int level = i - mLowestLevel + 1;
            if (1 == level)
            {
                System.out.print("1st Generation: ");
            }
            else if (2 == level)
            {
                System.out.print("2nd Generation: ");
            }
            else if (3 == level)
            {
                System.out.print("3rd Generation: ");
            }
            else
            {
                System.out.printf("%dth Generation: ", level);
            }
            
            for (int m = 0; m < names.length; ++m)
            {
                FamilyMember member = mAllMembers.get(names[m]);
                if (i == member.mLevel)
                {
                    System.out.print(names[m] + " ");
                }
            }
            
            System.out.println();
        }
    }
    
    public void RunAlgorithm() throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("family.dat"));
        while (kb.hasNextLine())
        {
            String strLine = kb.nextLine();
            String[] strTokens = strLine.split(" ");
            
            FamilyMember fmFrom = GetFamilyMember(strTokens[0]);
            if (null == fmFrom)
            {
                fmFrom = new FamilyMember();
                fmFrom.mName = strTokens[0];
                
                mAllMembers.put(fmFrom.mName, fmFrom);
            }
            
            FamilyMember fmTo = GetFamilyMember(strTokens[2]);
            if (null == fmTo)
            {
                fmTo = new FamilyMember();
                fmTo.mName = strTokens[2];
                
                mAllMembers.put(fmTo.mName, fmTo);
            }
            
            if (strTokens[1].equalsIgnoreCase("MOTHER"))
            {
                AddMother(fmFrom, fmTo);
            }
            else if (strTokens[1].equalsIgnoreCase("FATHER"))
            {
                AddFather(fmFrom, fmTo);
            }
            else if (strTokens[1].equalsIgnoreCase("DAUGHTER"))
            {
                AddDaughter(fmFrom, fmTo);
            }
            else if (strTokens[1].equalsIgnoreCase("SON"))
            {
                AddSon(fmFrom, fmTo);
            }
            else if (strTokens[1].equalsIgnoreCase("SISTER"))
            {
                AddSister(fmFrom, fmTo);
            }
            else if (strTokens[1].equalsIgnoreCase("BROTHER"))
            {
                AddBrother(fmFrom, fmTo);
            }
            else if (strTokens[1].equalsIgnoreCase("WIFE"))
            {
                AddWife(fmFrom, fmTo);
            }
            else if (strTokens[1].equalsIgnoreCase("HUSBAND"))
            {
                AddHusband(fmFrom, fmTo);
            }
        }
        
        PrintGenerations();
    }
    
    
    public static void main(String args[]) throws IOException
    {
        Family fam = new Family();
        fam.RunAlgorithm();
    }
}
