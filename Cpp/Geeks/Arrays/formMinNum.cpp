#include <iostream>
#include <stack>

using namespace std;

void printMinNo(string);
int main(){

	string str;
	cout << "\nEnter the pattern= I for increasing and D for decreasing\n";
	cout << "We print min no following that pattern\n";
	cout << "\nProgram continues till 'end' is given as input\n";
	cout << "\nEnter the pattern : ";
	cin >> str;
	do{
		printMinNo(str);
		cout << "\nEnter the pattern : ";
		cin >> str;
	}while(str.compare("end"));
	return 0;
}

void printMinNo(string str){

	int i(0), len(0);

	stack<int> bin;

	len = str.size();
	for(i=0; i<len; i++){
		bin.push(i+1);
		if(str[i] == 'I'){
			while(!bin.empty()){
				cout << bin.top();
				bin.pop();
			}
		}
	}
	bin.push(i+1);
	while(!bin.empty()){
		cout << bin.top();
		bin.pop();
	}
	cout << endl;
}
