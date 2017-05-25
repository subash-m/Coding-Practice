#include<iostream>

using namespace std;

int fn(int[], int);

int main(){

	int arr[5] = {1, 2, 3, 4, 5};

	cout<< *(&arr+1) - arr<<endl;
	cout<< fn(arr, 5)<<endl;

	return 0;
}

int fn(int arr[], int len){

	return *(&arr + 1) - arr;
}
