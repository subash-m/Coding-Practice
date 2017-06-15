#include <iostream>

using namespace std;

int max(int a, int b);
int knapsackRec(int w, int *val, int *weight, int n);
int knapsackDP(int w, int *val, int *weight, int n);
int knapsackDPEff(int w, int *val, int *weight, int n);

int main(){

	int capacity(0), noOfItems(0), i(0);
	int *weight, *val;

	cin >> capacity >> noOfItems;
	
	weight = new int[noOfItems];
	val = new int[noOfItems];

	for(i=0; i<noOfItems; i++){
		cin >> weight[i] >> val[i];
	}

	cout << knapsackDPEff(capacity, val, weight, noOfItems);

	return 0;
}

int max(int a, int b){
	return a > b ? a : b;
}

int knapsackDPEff(int w, int *val, int *weight, int n){

	int k[2][w+1] = {0};

	for(int i(0); i<=n; i++){
		for(int j(0); j<=w; j++){
			if(i==0 || j==0)
				k[j] = 0;
			else if(weight[i-1] <= j)
				k[j] = max(val[i-1] + k[j - weight[i-1]], k[j]);
		}
	}
	return k[w];
}

int knapsackDP(int w, int *val, int *weight, int n){

	int k[n+1][w+1] = {0};
	for(int i(0); i<=n; i++){
		for(int j(0); j<=w; j++){

			if(i==0 || j==0)
				k[i][j] = 0;

			else if(weight[i-1] > j){
				k[i][j] = k[i-1][j];
			}
			else{
				k[i][j] = max(k[i-1][j], val[i-1] + k[i-1][j-weight[i-1]]);
			}
		}
	}
	return k[n][w];
}

int knapsackRec(int w, int *val, int *weight, int n){

	if(n==0 || w == 0)
		return 0;
	
	if(weight[n-1] > w)
		return knapsackRec(w, val, weight, n-1);
	else
		return max(val[n-1]+knapsackRec(w-weight[n-1], val, weight, n-1), knapsackRec(w, val, weight, n-1));
}
