#include <iostream>
#include <vector>

using namespace std;

void subset(int [], int, int);
void printTable(int, int);
void getSubset(int[], int, int, vector<int>&);
void display(vector<int>&);

bool **dp;

int main(){

	int arr[] = {5, 6, 7, 8, 4, 2, 3, 1};
	int n = sizeof(arr)/sizeof(arr[0]);
	int sum = 8;
	subset(arr, n, sum);
	return 0;
}

void getSubset(int arr[], int n, int sum, vector<int>& ans){

	if(sum == 0){
		display(ans);
		return;
	}

	//If ignoring current element also forms sum
	if(dp[sum][n-1]){
		vector<int> p = ans;
		getSubset(arr, n-1, sum, p);
	}

	//If current element contributes to the sum
	if(sum>=arr[n-1]&&dp[sum - arr[n-1]][n-1]){
		ans.push_back(arr[n-1]);
		getSubset(arr, n-1, sum-arr[n-1] , ans);
	}
}

void subset(int arr[], int n, int sum){
    dp = new bool*[sum+1];
    
    for(int i(0); i<=sum; i++)
        dp[i] = new bool[n+1];
    
    for(int j(0); j<=n; j++)
        dp[0][j] = true;
    
    for(int i(1); i<=sum; i++)
        dp[i][0] = false;
    
    for(int i(1); i<=sum; i++){
        for(int j(1); j<=n; j++){
            dp[i][j] = dp[i][j-1];
            if(arr[j-1] <= i)
                dp[i][j] = dp[i - arr[j-1]][j-1] || dp[i][j-1];
        }
    }
    printTable(sum, n);

    vector<int> answer;
    getSubset(arr, n, sum, answer);
}

void display(vector<int>& ans){
	for(int i(0); i<ans.size(); i++)
		cout << ans[i] << ", ";
	cout << endl;
}

void printTable(int sum, int num){
    for(int i(0); i<=sum; i++){
        for(int j(0); j<=num; j++){
            cout << dp[i][j]<< ", ";
        }
        cout<<endl;
    }
}
