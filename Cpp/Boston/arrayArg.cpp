#include<iostream>

using namespace std;

int fn(int[], int);

int main(){

	int arr[5] = {1, 2, 3, 4, 5};

	cout<< fn(arr, 5)<<endl;

	return 0;
}

int fn(int arr[], int len){

	int len = *(&arr + 1) - arr;
}
