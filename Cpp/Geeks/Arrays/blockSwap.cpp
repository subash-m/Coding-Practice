#include<iostream>

using namespace std;

void rotateBlock(int*, int, int);
void swap(int *, int, int, int);
void print(int*, int);

int main(){

	int d(0), len(0), *arr;
	cout << "\nEnter size of Array = ";
	cin >> len;

	arr = new int[len];
	cout << "\nEnter the Array elements ";
	for(int i(0); i<len; i++)
		cin >> arr[i];

	cout << "\nEnter the rotate block size = ";
	cin >> d;

	rotateBlock(arr, d, len);
	print(arr, len);
	delete [] arr;
	return 0;
}

void rotateBlock(int *arr, int d, int len){

	int i(0), j(0);

	if(d == 0 || len == d)
		return;

	if(len < d)
		cout << "\nBlock has to be less than the array size\n";

	i = d;
	j = len - d;

	while(i != j){

		if(i < j){	//A is Shorter
			swap(arr, d-i, d-i+j, i);
			j -= i;
			
		}else{		//B is Shorter
			swap(arr, d-i, d, j);
			i -= j;
		}
	}
	swap(arr, d-i, d, i);
}

void swap(int *arr, int start1, int start2, int d){

	int temp(0);
	for(int i(0); i<d; i++){
		temp = arr[i+start2];
		arr[i+start2] = arr[i+start1];
		arr[i+start1] = temp;
	}
}

void print(int* arr, int len){
	cout << "\nThe Array elements are \n";
	for(int i(0); i<len; i++)
		cout << arr[i] << ", ";
	cout << endl;
}
