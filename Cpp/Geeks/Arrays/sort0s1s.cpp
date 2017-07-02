#include <iostream>
#include <vector>

using namespace std;

void swap(vector<int> &, int, int);

int main(){

    int n(0), i(0), l(0), h(0), temp(0);

    cout << "\nEnter the number of elements : ";
    cin >> n;

    vector<int> vec(n, 0);
    cout << "\nEnter the elements : ";
    for(i=0; i<n; i++)
        cin >> vec[i];

    h = n-1;

    while( l < h ){

        while(vec[l] == 0 && l < h)
            l++;
        while(vec[h] == 1 && l < h)
            h--;
        swap(vec, l, h);
    }
/*1 0 1 0 1 0 0 1
0 0 1 0 1 0 1 1
0 0 0 0 1 1 1 1 */
    cout << "\nThe elements are ";
    for(i=0; i<n; i++)
        cout << vec[i] << ", ";
    cout << endl;
    return 0;
}

void swap(vector<int> &vec, int i, int j){

    int temp(0);
    temp = vec[i];
    vec[i] = vec[j];
    vec[j] = temp;
}
