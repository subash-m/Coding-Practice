#include <iostream>
#include <vector>

using namespace std;

void swap(vector<int> &, int, int);

int main(){

    int n(0), l(0), m(0), h(0), temp(0), i(0);

    cout << "\nEnter the number of elements : ";
    cin >> n;

    vector<int> vec(n, 0);
    cout << "\nEnter the elements : ";
    for(i=0; i<n; i++)
        cin >> vec[i];

    //[1 to L-1] = 0
    //[L to M-1] = 1
    //[M to H-1] = Unknown
    //[H to n-1] = 2
    h = n-1;

    while(m <= h){
        switch(vec[m]){

            case 0:
                swap(vec, l++, m++);
                break;
            case 1:
                m++;
                break;
            case 2:
                swap(vec, m, h--);
        }
    }

    cout << "\nThe Array elements are ";
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
