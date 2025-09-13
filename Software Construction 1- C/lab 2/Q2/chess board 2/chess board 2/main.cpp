#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    cout << setw(10) << "Field" << setw(15) << "On field" << setw(15) << "Sum" << endl;

    unsigned long long grains = 1, sum = 0;
    for (int i = 1; i <= 64; i++) {
        cout << setw(10) << i << setw(15) << grains << setw(15) << sum << endl;
        sum += grains;
        grains *= 2;
    }

    return 0;
}
