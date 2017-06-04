#include<iostream>

using namespace std;

int main(){

	unsigned int a(6), b(2);
	int c = 0;
	c = a&b;
	cout << c<<endl;
	c = a|b;
	cout << c<<endl;
	c = a^b;
	cout << c<<endl;
	c = ~a;
	cout << c<<endl;
	c = a<<1;
	cout << c<<endl;
	c = a>>1;
	cout << c<<endl;
	
	a = a ^ b;
	cout << a << ", "<< b<<endl;
	b = a ^ b;
	cout << a << ", "<< b<<endl;
	a = a ^ b;
	cout << a << ", "<< b<<endl;
	
	return 0;
}
