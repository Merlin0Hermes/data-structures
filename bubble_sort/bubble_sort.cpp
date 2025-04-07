#include <iostream>
#include <utility>

int main()
{
    int array[]{ 6, 3, 2, 9, 7, 1, 5, 4, 8 };

    constexpr int len {static_cast<int>(std::size(array))};

    bool swapped {false};
    for (int i {0}; i < len - 1; ++i)
    {
        for (int j {0}; j < len - i - 1; ++j)
        {
            if (array[j] > array[j + 1])
            {
                std::swap(array[j], array[j + 1]);
                swapped = true;
            }
        }
        if (!swapped)
            break;
    }

    std::cout << "Sorted array: ";
    for (auto a: array)
        std::cout << a << " ";
    std::cout << "\n";

    return 0;
}