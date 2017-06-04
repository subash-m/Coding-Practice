#include <iostream>

using namespace std;

int p1();
int p2();

int main(){

	int x(10), y(15);
	cout << (x, y)<<endl;
	cout <<  (p1(), p2()) <<endl;
	y = (x++, ++x);
	cout << y<<", "<<x << endl;
	goto label2;
	x = 10;
	y = (x++, cout << x<<endl, ++x, cout<<x<<endl, x++);
	cout << y<<", "<<x << endl;
	label2:
	switch(x+y){	//Against accusation of variable expr inside switch
		default:
			cout<<"What is wrong babe!!"<<endl;
			break;
	}
	return 0;
}

int p1(){
	cout << "inside function1"<<endl;
	return 1;
}

int p2(){
	return 2;
}
