#include<iostream>
#include<algorithm>

using namespace std;

void print(unsigned short arr[], unsigned short len);
unsigned short knapsack(unsigned short [], unsigned short n, unsigned short k);
unsigned short max(unsigned short, unsigned short);

int main(){

	unsigned short testCases(0), n(0), k(0), i(0), j(0), temp(0);

	cin >> testCases;

	for(i=0; i<testCases; i++){

		cin >> n >> k;
		unsigned short input[n];

		for(j=0; j<n; j++){
			cin >> input[j];
		}

		//print(input, n);
		sort(input, input+n);
		cout << knapsack(input, n, k)<< endl;
	}
	return 0;
}

unsigned short knapsack(unsigned short arr[], unsigned short n, unsigned short k){
	//Base Case
	if (n==0 || k==0)
		return 0;

	/* If weight of the nth item is more, don't include in knapsack */
	if(arr[n-1] > k)
		return knapsack(arr, n-1, k);

	/* Return the maximum of two cases:
	   1) including nth item
	   2) not including nth item */
	else
		return max(arr[n-1]+knapsack(arr, n, k-arr[n-1]), knapsack(arr, n-1, k));
}

unsigned short max(unsigned short a, unsigned short b){
	return a>b?a:b;
}

void print(unsigned short arr[], unsigned short len){

	unsigned short j(0);
	for(j=0; j<len; j++)
		cout<<arr[j] << ", ";
	cout<<endl;

}
