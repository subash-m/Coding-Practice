#include <vector>
#include <iostream>
#include <queue>
#include <iomanip>

using namespace std;

void findMedian(int, double&, priority_queue<int>&, priority_queue<int, vector<int>, greater<int> >&);

int main() {
    int n(0), i(0), key(0);
    double median(0);
    cout << "\nEnter the number of elements : ";
    cin >> n;
    
    cout << setprecision(1) << fixed;
    
    priority_queue<int> maxQueue;
    priority_queue<int, vector<int>, greater<int> > minQueue;
    
    cout << "\nEnter the Elements : \n";
    for(i=0; i<n; i++){
        cin >> key;
        findMedian(key, median, maxQueue, minQueue);
        cout << median << endl;
    }
    
    return 0;
}

void findMedian(int key, double &median, priority_queue<int> &vec1, priority_queue<int, vector<int>, greater<int> > &vec2){
    
    int lsize(0), rsize(0);
    lsize = vec1.size();
    rsize = vec2.size();
    
    if(lsize > rsize){
        if(key < median){
            vec2.push(vec1.top());
            vec1.pop();
            vec1.push(key);
        }else{
            vec2.push(key);
        }
        median = (vec1.top() + vec2.top())/2.0;
    }else if(lsize < rsize){
        if(key > median){
            vec1.push(vec2.top());
            vec2.pop();
            vec2.push(key);
        }else
            vec1.push(key);
        median = (vec1.top() + vec2.top())/2.0;
    }else{
        if(key > median){
            vec2.push(key);
            median = vec2.top();
        }else{
            vec1.push(key);
            median = vec1.top();
        }
    }   
}
