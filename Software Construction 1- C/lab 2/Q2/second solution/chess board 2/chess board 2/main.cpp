/*
*   Wheat and Chess Board Problem
*   How many corns you get when double the amount with each field?
*/
#include <iostream>
#include <iomanip>  // setw()
#include <locale>   // separator
using namespace std;

int main()
{
    // this block is used for thousands separator only
    struct separator : numpunct<char>
    {
       string do_grouping() const { return "\03"; }
    };
    locale local(cout.getloc(), new separator);
    cout.imbue(local);
    
    
    unsigned long long riceCorns = 1;
    for (int i=1; i <= 64; i++)
    {
        cout << "Field: " << setw(2) << right <<  i << "\tRice: " << setw(25) << right << riceCorns << endl;
        riceCorns *= 2;
    }
    return 0;
}
