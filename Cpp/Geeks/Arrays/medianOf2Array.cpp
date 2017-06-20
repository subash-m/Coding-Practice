#include<iostream>

using namespace std;

int median(int *, int);
int findMedian(int *, int *, int);

int main(){

	int n(0), *arr1, *arr2, i(0);

	cout << "Enter the array size = ";
	cin >> n;

	arr1 = new int[n];
	arr2 = new int[n];

	cout << "\nEnter the Array1 elements - \n";
	for(i=0; i<n; i++)
		cin >> arr1[i];
	
	cout << "\nEnter the Array2 elements - \n";
	for(i=0; i<n; i++)
		cin >> arr2[i];

	cout << "\nThe Median is ";
	cout << findMedian(arr1, arr2, n) << endl;
	delete [] arr1, arr2;
	return 0;
}

/*Median of even length array is average of the middle 2 elements*/
int median(int *arr, int len){


	if(len&1){			//Odd length Array
		return (arr[len/2]);
	}				//even length Array
	return ((arr[len/2] + arr[len/2 - 1])/2);
}

int findMedian(int *arr1, int *arr2, int len){
	
	int median1(0), median2(0);

	if(len == 1)
		return (arr1[0] + arr2[0])/2;
	if(len == 2)
		return (max(arr1[0], arr2[0]) + min(arr1[1], arr2[1]))/2;

	median1 = median(arr1, len);
	median2 = median(arr2, len);

	if(median1 == median2)
		return median1;
	else if(median1 < median2){
		if(len&1)
			return findMedian(arr1+len/2, arr2, len-len/2);
		return findMedian(arr1+len/2-1, arr2, len -len/2 +1);
	}
	if(len&1)
		return findMedian(arr1, arr2+len/2, len-len/2);
	return findMedian(arr1, arr2+len/2-1, len -len/2 +1);
}
