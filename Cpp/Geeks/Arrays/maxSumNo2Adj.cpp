#include <iostream>
#include <vector>

using namespace std;

int main(){

    int n(0), i(0), incl(0), excl(0), exclNew(0);

    cout << "\nEnter the number of elements : ";
    cin >> n;

    vector<int> vec(n, 0);
    cout << "\nEnter the elements : ";
    for(i=0; i<n; i++)
        cin >> vec[i];

    // Maximum sum including the previous element
    incl = vec[0];
    // Maximum sum excluding the previous element
    excl = 0;

    for(i=1; i<n; i++){
        exclNew = max(incl, excl);
        incl = excl + vec[i];
        excl = exclNew;
    }

    cout << "\nThe Maximum Sum is " << max(incl, excl) << endl;

    return 0;
}
