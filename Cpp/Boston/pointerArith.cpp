#include<iostream>

using namespace std;

int main(){
	
	int arr[5] = {1, 2, 3, 4, 5};
	int *val;
	val = &arr[0];

	cout << *val << endl;
	cout << *val-1 << endl;

	return 0;
}
