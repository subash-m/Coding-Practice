#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <cmath>

using namespace std;

void print(vector<int>vec, int n);

int main(){

    int n(0), i(0), minSum(INT_MAX), l(0), r(0), sum(0), a(0), b(0);

    cout << "\nEnter the number of elements : ";
    cin >> n;

    vector<int> vec(n, 0);
    cout << "\nEnter the elements : ";
    for(i=0; i<n; i++){
        cin >> vec[i];
    }
    sort(vec.begin(), vec.end());

    l=0; r=n-1;
    while(l < r){

        sum = vec[l] + vec[r];
        if(abs(sum) < abs(minSum)){
            minSum = sum;
            a = vec[l];
            b = vec[r];
        }
        if(sum < 0)
            l++;
        else
            r--;
    }
    
    //print(vec, n);
    cout << "\nThe two elements are :" << a << ", "<<b<<endl;
    return 0;
}

void print(vector<int> vec, int n){

    cout << "\nThe Array elements are : ";
    for(int i(0); i<n; i++)
        cout << vec[i] << ", ";
    cout << endl;
}
