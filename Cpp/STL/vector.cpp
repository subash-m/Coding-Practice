#include<iostream>
#include<vector>

using namespace std;

int main(){

    int n(0), temp(0);
    vector<int> vec;
    vector<int>::iterator i;

    cout << "\nEnter the number of Elements : ";
    cin >> n;
    
    for(int i(0); i<n; i++){
        cin >> temp;
        vec.push_back(temp);
    }

    cout << "\nVector elements are - ";
    for(i = vec.begin(); i!=vec.end(); i++){
        cout << *i << ", ";
    }
    cout<<endl;
    return 0;
}
