#include<iostream>

using namespace std;

void passByRef(int *);
void passByValue(int );

int main(){

	int val = 0;
	passByValue(val);
	cout << val << endl;
	passByRef(&val);
	cout << val << endl;
	return 0;
}

void passByValue(int x){
	x = 10;
}

void passByRef(int *x){
	*x = 20;
}
