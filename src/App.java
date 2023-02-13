import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.io.File;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

public class App {
   
    public static int[] createRandomArray(int arrayLength)
    {
        int max = 99;
        int min = 1;
        int[] marray = new int[arrayLength];

        Random rando = new Random();

        for(int ii = 0; ii<arrayLength;ii++)
        {
            marray[ii] = rando.nextInt((max - min + 1) + min);
        }

        return marray;

    }

    public static void merge(int[] array, int start, int mid, int end)
    {
        int ii = start;
        int jj = mid;
        int tt[] = new int[end-start+1];
        int kk = 0;

        while(ii < mid && jj < end)
        {
            if(array[ii] > array[jj])
            {
                tt[kk] = array[jj];
                kk++;
                jj++;
            }
            else
            {
                tt[kk] = array[ii];
                kk++;
                ii++;
            }
        }

        while(ii < mid)
        {
            tt[kk] = array[ii];
            kk++;
            ii++;
        }
        
        while(jj < end)
        {
            tt[kk] = array[jj];
            kk++;
            jj++;
        }

        for(ii = start; ii < end; ii++)
        {
            array[ii] = tt[ii-start];
        }


    }

    public static void mergeSort(int[] array, int start, int end)
    {
        int mid = (start+end)/2;
        
        if(end-mid <= 1)
        {
            merge(array,start,mid,end);
        }
        else
        {
            mergeSort(array, start, mid);
            mergeSort(array, mid, end);
            merge(array,start,mid,end);
        }
    }
    
    public static void mergeSort(int[] array)
    {
        mergeSort(array,0,array.length);
    }


    public static void main(String[] args) throws Exception
    {
        int[] mm = createRandomArray(100);
        mergeSort(mm);

        for(int i = 0; i<=mm.length -1;i++)
        {
            System.out.print(" " + mm[i]);

        }
    }
    
}
