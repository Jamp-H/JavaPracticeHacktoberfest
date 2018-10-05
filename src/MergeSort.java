public class MergeSort
{

    /**
     * Test Merge sort methods
     * @param args takes in arguments from command line into an array
     */
    public static void main(String[] args)
    {
        int[] someArr = {5,9,2,14,73,12,85,86,35,96};

        runMergeSortHelper(someArr, 0, 9);

        for (int index = 0; index < someArr.length; index++)
        {
            System.out.println(someArr[index]);
        }
    }



    /**
     * Merge sort helper, places low and high indices of array segment to be
     * processed into recursive method, then sorts data using merge sort
     * algorithm
     * <p>
     *
     * @param localArray integer array holding unsorted values
     * @param lowIndex   lowest index of array segment to be managed; this
     *                   varies as the segments are broken down recursively
     * @param highIndex  highest index of array segment to be managed; this
     *                   varies as the segments are broken down recursively
     */
    private static void runMergeSortHelper( int[] localArray, int lowIndex,
            int highIndex )
    {
        int middle;

        if ( lowIndex < highIndex )
        {
            middle = (lowIndex + highIndex) / 2;

            runMergeSortHelper(localArray, lowIndex, middle);

            runMergeSortHelper(localArray, middle + 1, highIndex);

            runMerge(localArray, lowIndex, middle, highIndex);
        }
    }

    /**
     * Merges values brought in between a low and high index segment of an
     * array
     * <p>
     * Note: uses locally sized single array for temporary storage
     *
     * @param localArray  integer array holding unsorted values
     * @param lowIndex    lowest index of array segment to be managed
     * @param middleIndex middle index of array segment to be managed
     * @param highIndex   high index of array segment to be managed
     */
    private static void runMerge( int[] localArray, int lowIndex,
            int middleIndex, int highIndex )
    {
        int tempArrayLeftIndex, tempArrayRightIndex, tempArrayMid,
                tempArrayHigh, localIndex = lowIndex,
                tempArraySize = (highIndex - lowIndex) + 1, tempIndex;

        int[] tempArray = new int[tempArraySize];

        tempArrayHigh = highIndex - lowIndex;
        tempArrayLeftIndex = 0;
        tempArrayMid = (tempArrayHigh + tempArrayLeftIndex) / 2;
        tempArrayRightIndex = tempArrayMid + 1;

        for ( tempIndex = 0; tempIndex < tempArraySize; tempIndex++ , lowIndex++ )
        {
            tempArray[tempIndex] = localArray[lowIndex];
        }

        while ( (tempArrayLeftIndex <= tempArrayMid
                && tempArrayRightIndex <= tempArrayHigh) )
        {
            if ( tempArray[tempArrayLeftIndex] < tempArray[tempArrayRightIndex] )
            {
                localArray[localIndex] = tempArray[tempArrayLeftIndex];
                tempArrayLeftIndex++;
            } else
            {
                localArray[localIndex] = tempArray[tempArrayRightIndex];
                tempArrayRightIndex++;
            }
            localIndex++;
        }

        while ( tempArrayLeftIndex <= tempArrayMid )
        {
            localArray[localIndex] = tempArray[tempArrayLeftIndex];
            localIndex++;
            tempArrayLeftIndex++;
        }

        while ( tempArrayRightIndex <= tempArrayHigh )
        {
            localArray[localIndex] = tempArray[tempArrayRightIndex];
            localIndex++;
            tempArrayRightIndex++;
        }
    }
}
