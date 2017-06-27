#include <iostream>
#include <vector>

using namespace std;


int main(){

    int n(0), i(0);

    cout << "Enter the number of elements : ";
    cin >> n;

    vector<int> vec(n, 0);
    vector<int> lis(n, 0);

    cout << "\nEnter the Elements : ";
    for(i=0; i<n; i++){
        cin >> vec[i];
    }

    return 0;
}
