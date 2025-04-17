#include <cassert>
#include <iostream>
#include <iterator>
#include <numeric>

// array is the array to search over.
// target is the value we're trying to determine exists or not.
// min is the index of the lower bounds of the array we're searching.
// max is the index of the upper bounds of the array we're searching.
// binarySearch() should return the index of the target element if the target is found, -1 otherwise
int binarySearch(const int* array, int target, int min, int max)
{
    assert(array && "Array doesn't exist");
    
    if (min > max)
        return -1;

    int index { std::midpoint(min, max) };
    if (array[index] == target)
        return index;
    
    if (array[index] < target)
        return binarySearch(array, target, index + 1, max);
    else if (array[index] > target)
        return binarySearch(array,target, min, index - 1);
}

int main()
{
    constexpr int array[]{ 3, 6, 8, 12, 14, 17, 20, 21, 26, 32, 36, 37, 42, 44, 48 };

    // We're going to test a bunch of values to see if the algorithm returns the result we expect

    // Here are the test values
    constexpr int testValues[]{ 0, 3, 12, 13, 22, 26, 43, 44, 48, 49 };

    // And here are the results that we expect for those test values
    int expectedResult[]{ -1, 0, 3, -1, -1, 8, -1, 13, 14, -1 };

    // Make sure we have the same number of test values and expected results
    static_assert(std::size(testValues) == std::size(expectedResult));

    int numTestValues { std::size(testValues) };
    // Loop through all of the test values
    for (int count{ 0 }; count < numTestValues; ++count)
    {
        // See if our test value is in the array
        int index{ binarySearch(array, testValues[count], 0, static_cast<int>(std::size(array)) - 1) };
        // If it matches our expected value, then great!
        if (index == expectedResult[count])
             std::cout << "test value " << testValues[count] << " passed!\n";
        else // otherwise, our binarySearch() function must be broken
             std::cout << "test value " << testValues[count] << " failed.  There's something wrong with your code!\n";
    }

    return 0;
}