#include <iostream>
#include <vector>

using namespace std;

int ceilIndex(vector<int> &, vector<int> &, int, int, int);

int main(){

    int n(0), i(0), length(-1);
    cout << "\nEnter the number of Elements : ";
    cin >> n;

    cout << "\nEnter the Elements : ";
    vector<int> vec1(n, 0);
    for(i=0; i<n; i++)
        cin >> vec1[i];

    vector<int> vec2;
    vector<int> vec3(n, -1);

    vec2.push_back(0);
    for(i=1; i<n; i++){
    
        if(vec1[i] > vec2.back()){
            vec2.push_back(i);
            vec3[i] = vec2.end()[-2];
        }
        else if(vec1[i] < vec2.front()){
            vec2[0] = i;
        }
        else{
            
        }
    }
    
    return 0;
}

int ceilIndex(vector<int> &vec1, vector<int> &vec2, int l, int r, int key){

    while((r-l) > 1){

        m = l + (r-l)/2;
        if(vec1[vec2[m]] < key)
            l = m;
        else
            r = m;
    }
    return r;
}
