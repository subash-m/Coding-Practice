#include <iostream>
#include <vector>

using namespace std;


int main(){

    long n(0), i(0), j(0), maxLen(1), sum(0);

    cout << "Enter the number of elements : ";
    cin >> n;

    vector<long> vec(n, 0);
    vector<long> lis(n, 1);

    cout << "\nEnter the Elements : ";
    for(i=0; i<n; i++){
        cin >> vec[i];
    }

    lis[0] = 1;
    for(i=1; i<n; i++){
        for(j=0; j<i; j++){
            if(vec[j] < vec[i]){
                lis[i] = max(lis[i], lis[j] + 1);
            }
            maxLen = max(maxLen, lis[i]);
        }
    }
    cout << "\nLongest Increasing SubSequence = " << maxLen << endl;
    return 0;
}
