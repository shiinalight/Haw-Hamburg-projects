#include <iostream>

using namespace std;

int main() {
    for (int row = 8; row >= 1; row--) {
        for (char col = 'a'; col <= 'h'; col++) {
            cout << col << row << " ";
        }
        cout << endl;
    }

    return 0;
}
