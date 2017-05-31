#include<iostream>
#include "NewClass.h"

using namespace std;

int main(){
	NewClass newClass(5,10);
	//const NewClass newClass1(5,10);
	//We cannot call a regular method with constant class object
	//newClass1.constFnPrint();
	//newClass.constFnPrint();

	NewClass a(10, 0);
	NewClass b(10, 0);
	NewClass c(0, 0);
	c = a+b;
	cout << c.getRegVar()<<endl;
	return 0;
}
