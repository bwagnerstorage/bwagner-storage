import java.io.*;
import java.util.*;

public class Family
{
    private class FamilyMember {
        String mName;
        
        ArrayList<FamilyMember> mParents;
        ArrayList<FamilyMember> mSiblings;
        ArrayList<FamilyMember> mOffspring;
        
        FamilyMember mSignificantOther;
        
        boolean mbIterated;
        int mLevel;
        
        
        public FamilyMember() {
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
    
    private static void AddUnique(ArrayList<FamilyMember> list, FamilyMember fm) {
    	if (fm != null && !list.contains(fm)) {
    		list.add(fm);
    	}
    }
    
    
    public Family() {
        mAllMembers = new HashMap<String, FamilyMember>();
        mLowestLevel = 0;
        mHighestLevel = 0;
    }
    
    private void Consolodate(ArrayList<FamilyMember> parents, ArrayList<FamilyMember> children) {
    	// Iterate children to get siblings and parents
    	for (int i = 0; i < children.size(); ++i) {
    		FamilyMember child = children.get(i);
    		
    		for (int j = 0; j < child.mParents.size(); ++j) {
    			FamilyMember parent = child.mParents.get(j);
    			AddUnique(parents, parent);
    		}
    		
    		for (int j = 0; j < child.mSiblings.size(); ++j) {
    			FamilyMember sibling = child.mSiblings.get(j);
    			AddUnique(children, sibling);
    		}
    	}
    	
    	// Iterate parents to get significant others and possibly more children
    	for (int i = 0; i < parents.size(); ++i) {
    		FamilyMember parent = parents.get(i);
    		
    		AddUnique(parents, parent.mSignificantOther);
    		
    		for (int j = 0; j < parent.mOffspring.size(); ++j) {
    			FamilyMember child = parent.mOffspring.get(j);
    			AddUnique(children, child);
    		}
    	}
    	
    	// Attach significant others
    	if (parents.size() == 2) {
    		FamilyMember one = parents.get(0);
    		FamilyMember two = parents.get(1);
    		
    		one.mSignificantOther = two;
    		two.mSignificantOther = one;
    	}
    	else if (parents.size() > 2) {
    		System.out.println("Too many parents!");
    	}
    	
    	// Add parents and siblings to all children
    	for (int i = 0; i < children.size(); ++i) {
    		FamilyMember child = children.get(i);
    		
    		for (int j = 0; j < parents.size(); ++j) {
    			AddUnique(child.mParents, parents.get(j));
    		}
    		
    		for (int j = 0; j < children.size(); ++j) {
    			FamilyMember sibling = children.get(j);
    			if (sibling != child) {
    				AddUnique(sibling.mSiblings, child);
    				AddUnique(child.mSiblings, sibling);
    			}
    		}
    	}
    	
    	// Add children to all parents
    	for (int i = 0; i < parents.size(); ++i) {
    		FamilyMember parent = parents.get(i);
    		
    		for (int j = 0; j < children.size(); ++j) {
    			AddUnique(parent.mOffspring, children.get(j));
    		}
    	}
    }
    
    private FamilyMember GetFamilyMember(String person) {
        return mAllMembers.get(person);
    }
    
    private void AddParent(FamilyMember from, FamilyMember to) {
    	AddUnique(from.mOffspring, to);
    	AddUnique(to.mParents, from);
    	
    	ArrayList<FamilyMember> parents = new ArrayList<FamilyMember>();
    	AddUnique(parents, from);
    	
    	ArrayList<FamilyMember> children = new ArrayList<FamilyMember>();
    	AddUnique(children, to);
    	
    	Consolodate(parents, children);
    }
    
    private void AddSibling(FamilyMember from, FamilyMember to) {
    	if (from == to) {
    		return;
    	}
    	
    	AddUnique(from.mSiblings, to);
    	AddUnique(to.mSiblings, from);
    	
    	ArrayList<FamilyMember> parents = new ArrayList<FamilyMember>();
    	
    	ArrayList<FamilyMember> children = new ArrayList<FamilyMember>();
    	AddUnique(children, from);
    	AddUnique(children, to);
    	
    	Consolodate(parents, children);
    }
    
    private void IterateMembers(FamilyMember member, int level) {
        if (null == member || member.mbIterated) {
            return;
        }
        
        if (level < mLowestLevel) {
            mLowestLevel = level;
        }
        
        if (level > mHighestLevel) {
            mHighestLevel = level;
        }
        
        member.mbIterated = true;
        member.mLevel = level;
        
        // Significant others are always on the same generation
        IterateMembers(member.mSignificantOther, level);
        
        // Siblings are on the same level
        for (int i = 0; i < member.mSiblings.size(); ++i) {
            IterateMembers(member.mSiblings.get(i), level);
        }
        
        // Parents are a generation back
        for (int i = 0; i < member.mParents.size(); ++i) {
            IterateMembers(member.mParents.get(i), level - 1);
        }
        
        // Offspring are one generation ahead
        for (int i = 0; i < member.mOffspring.size(); ++i) {
            IterateMembers(member.mOffspring.get(i), level + 1);
        }
    }
    
    private void PrintStatistics() {
        if (0 == mAllMembers.size())
            return;
        
        Set<String> namesSet = mAllMembers.keySet();
        String[] names = new String[namesSet.size()];
        namesSet.toArray(names);
        Arrays.sort(names);
        
        // Calculate the levels
        IterateMembers(mAllMembers.get(names[0]), 0);
        
        // Print out generations
        for (int i = mLowestLevel; i <= mHighestLevel; ++i) {
            int level = i - mLowestLevel + 1;
            if (1 == level) {
                System.out.print("1st Generation: ");
            }
            else if (2 == level) {
                System.out.print("2nd Generation: ");
            }
            else if (3 == level) {
                System.out.print("3rd Generation: ");
            }
            else {
                System.out.printf("%dth Generation: ", level);
            }
            
            for (int m = 0; m < names.length; ++m) {
                FamilyMember member = mAllMembers.get(names[m]);
                if (i == member.mLevel) {
                    System.out.print(names[m] + " ");
                }
            }
            
            System.out.println();
        }
    }
    
    public void RunAlgorithm() throws IOException {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("family.dat"));
        while (kb.hasNextLine()) {
            String strLine = kb.nextLine();
            String[] strTokens = strLine.split(" ");
            
            FamilyMember fmFrom = GetFamilyMember(strTokens[0]);
            if (null == fmFrom) {
                fmFrom = new FamilyMember();
                fmFrom.mName = strTokens[0];
                
                mAllMembers.put(fmFrom.mName, fmFrom);
            }
            
            FamilyMember fmTo = GetFamilyMember(strTokens[2]);
            if (null == fmTo) {
                fmTo = new FamilyMember();
                fmTo.mName = strTokens[2];
                
                mAllMembers.put(fmTo.mName, fmTo);
            }
            
            if (strTokens[1].equalsIgnoreCase("MOTHER") ||
            	strTokens[1].equalsIgnoreCase("FATHER")) {
                AddParent(fmFrom, fmTo);
            }
            else if (strTokens[1].equalsIgnoreCase("SIBLING")) {
                AddSibling(fmFrom, fmTo);
            }
        }
        
        PrintStatistics();
    }
    
    
    public static void main(String args[]) throws IOException {
        Family fam = new Family();
        fam.RunAlgorithm();
    }
}
