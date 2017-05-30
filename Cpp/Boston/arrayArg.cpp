#include<iostream>

using namespace std;

int fn(int[], int);

int main(){

	int arr[] = {1, 2, 3, 4, 5};
	int len = *(&arr+1) - arr;

	cout<< *(&arr+1) - arr<<endl;
	cout<< fn(arr, 5)<<endl;

	return 0;
}

int fn(int arr[], int len){

	return *(&arr + 1) - arr;
}
