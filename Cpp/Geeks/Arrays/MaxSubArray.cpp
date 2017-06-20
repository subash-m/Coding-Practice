#include <iostream>

using namespace std;

void printMaxSubArray(int*, int);
void printArray(int*, int, int);

int main(){

	int n, *arr;

	cout << "Enter the number of elements in array - ";
	cin >> n;

	arr = new int[n];

	cout << "\nEnter the array elements : ";

	for(int i(0); i<n; i++)
		cin >>arr[i];

	printArray(arr, 0, n);
	printMaxSubArray(arr, n);	

	delete [] arr;
	return 0;
}

void printMaxSubArray(int *arr, int len){

	int *temp = new int[len];
	int index(0), maxSum, i(0);

	temp[0] = arr[0];
	maxSum = arr[0];
	for(i=1; i<len; i++){
		temp[i] = max(arr[i] + temp[i-1], arr[i]);
		if(temp[i] > maxSum){
			maxSum  = temp[i];
			index = i;
		}
	}
	cout<<"The Largest Sum Sub-Array is " << maxSum << endl;
 	for(i=index; maxSum != 0; i--){
		maxSum -= arr[i];
	}
	printArray(arr, i+1, index+1);

	delete[] temp;
}
void printArray(int* arr, int start, int len){
	cout << "\nArray elements are - \n";
	for(int i(start); i<len; i++){
		cout << arr[i] << ", ";
	}
	cout << endl;
}
