#include <iostream>
#include <queue>

using namespace std;

int main(){

	int n(0), i(0), temp(0), k(0);

	cout << "\nEnter the number of elements : ";
	cin >> n;

	cout << "\nEnter the k (K-Largest Nos) : ";
	cin >> k;

	priority_queue<int, vector<int>, greater<int> > minQueue;

	cout << "\n Enter the Elements : ";
	for(i=0; i<n; i++){

		cin >> temp;
		minQueue.push(temp);
		if(minQueue.size() > k)
			minQueue.pop();
	}

	cout << "\nThe " << k << " Largest numbers are : ";
	while(minQueue.size() > 0){

		cout << minQueue.top() << ", ";
		minQueue.pop();
	}
	cout << endl;
	return 0;
}
