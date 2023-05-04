public class MergeSortPractice
{
    public static void mergeSort(int[] a, int lo, int hi)
    {
            for(int x =0; x < a.length; x++)
            {
                System.out.print(a[x] + " ");
            }
            System.out.println();
       if (lo < hi)
       {
            int m = (lo + hi) / 2;
 
            mergeSort (a, lo, m);
            mergeSort (a, m+1, hi);
            merge (a, lo, hi);
       }
    }

    public static void merge(int[] a, int lo, int hi)
    {
       int i, j, k, m;
       int n=hi-lo+1;
       int[] b=new int[n];           // temporary array 

       k=0;
       m=(lo+hi)/2;
       
       // copy lower half to array b
       for(i=lo; i<=m; i++)
       {
           b[k]=a[i];
           k++;
       }

       for (j=hi; j>=m+1; j--)
       {
           b[k]=a[j];
           k++;
       } 
        
       i=0; 
       j=n-1; 
       k=lo;

       // copy back next-greatest element at each time
       // until i and j cross
       while (i<=j)
       {
          if (b[i]<=b[j])
          {
             a[k]=b[i];
             k++;
             i++;
          }
          else
          {
             a[k]=b[j];
             k++;
             j--;
          }
       }
    }
    
    public static void main(String[] args) 
    {
        int array[] = {88, 7, 56, 45, 13, 37, 90, 2};
        System.out.print("Orginal : ");
        for(int n : array)
        {
            System.out.print(n + " ");
        }
        System.out.println();
  
        mergeSort(array, 0, 7);
    }
    
}