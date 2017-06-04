#include<iostream>

using namespace std;

void change(int& );

int &fun();

int main(){

	int a = 10;
	//A reference can never be void ( void&).
	int &refVar = a;
	refVar = 20;
	cout << a << endl;
	change(a);
	cout << a << endl;

	/* Making references to point to NULL */
	int *ptr = NULL;
	int &b = *ptr;
	//cout << "--" << b << "--";

	fun() = 30;
	cout << "Result of &fun() - " << fun()<< endl;

	return 0;
}

int &fun(){

	static int x = 10;
	return x;
}

/* Can be used for pass by reference */
void change(int& a){
	a=50;
}
