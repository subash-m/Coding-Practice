#include <iostream>
#include <unordered_map>

using namespace std;

int main(){

	int n(0), i(0), sum(0), temp(0);

	cout << "\nEnter the number of elements : ";
	cin >> n;

	unordered_map<int, int> map; 
	cout << "\nEnter the elements : ";
	for(i=0; i<n; i++){
		cin >> temp;
		map.insert(make_pair(temp, 1));
	}
	cout << "\nEnter the sum : ";
	cin >> sum;

	unordered_map<int, int>::iterator it1, it2;

	for(it1 = map.begin(); it1!= map.end(); it1++){

		temp = sum - it1->first;
		it2 = map.find(temp);
		if(it2 == map.end())
			continue;
		else if(it2->second!=0 && it1->second!=0) {
			cout << "Elements = "<<it1->first <<", "<<temp<<endl;
			it1->second--;
			it2->second--;
		}
	}
	return 0;
}
