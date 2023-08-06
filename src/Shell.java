public class Shell {
    static void shell(int a[], int n)
    {
        for (int interval = n/2; interval > 0; interval /= 2)
        {
            for (int i = interval; i < n; i += 1)
            {
                int temp = a[i];
                int j;
                for (j = i; j >= interval && a[j - interval] > temp; j -= interval)
                    a[j] = a[j - interval];

                a[j] = temp;
            }
        }
    }
    static void printArr(int a[], int n) /* function to print the array elements */
    {
        int i;
        for (i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
    public static void main(String args[])
    {
        int a[] = { 30, 28, 37, 5, 9, 14, 22, 39 };
        int n = a.length;
        System.out.print("Before sorting array elements are - \n");
        printArr(a, n);
        shell(a, n);
        System.out.print("\nAfter applying shell sort, the array elements are - \n");
        printArr(a, n);
    }
}
