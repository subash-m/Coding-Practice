#include <iostream>
#include <vector>

using namespace std;

int main(){

    int n(0), i(0), temp(0);
    int flag(0);
    cout << "\nEnter the number of elements : ";
    cin >> n;

    n++;
    cout << "\nEnter the Elements : ";
    vector<int> vec(n, 0);
    for(i=0; i<n-1; i++)
        cin >> vec[i];

    for(i=0; i<n-1; i++){
        vec[(vec[i]%(n+1))-1] += n+1;
    }

    cout << "\nThe Frequency of the elements are : \n";
    for(i=0; i<n; i++){
        temp = static_cast<int>(vec[i]/ (n+1));
        cout << i+1 << "===" << temp << endl;
        vec[i] %= (n+1);
    }

    cout << "\nThe Array elements are ";
    for(i=0; i<n-1; i++)
        cout << vec[i] << ", ";
    cout << endl;

    return 0;
}
