#include <iostream>
#include <vector>

using namespace std;

int main(){

	int n(0), i(0), x(0);
	bool flag = false;

	cout << "\nEnter the Number of elements : ";
	cin >> n;

	cout << "\nEnter the Elements : ";
	vector<int> vec(n, 0);

	for(i=0; i<n; i++){
		cin >> vec[i];
	}

	cout << "\n\nEnter the element to delete : ";
	cin >> x;

	for(i=0; i<n; i++){
		if(vec[i] == x && !flag){
			flag = true;
			continue;
		}if(flag)
			vec[i-1] = vec[i];
	}
	cout << "\n\nThe Array elements are : ";
	for(i=0; i<n-1; i++)
		cout << vec[i] << ", ";
	cout << endl;

	return 0;
}
