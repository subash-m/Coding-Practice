#include <iostream>

using namespace std;

int main(){

	int a = 10;
	cout << a << ", "<< a++ << endl;
	a = 10;
	cout << a++ << ", "<< a << endl;
	a = 10;
	cout << a << ", "<< a++ <<", "<<++a<< endl;
	return 0;
}
