#include "NewClass.h"
#include<iostream>

using namespace std;

NewClass::NewClass(int a, int b)
:regVar(a)//,constVar(b)
{
	cout << "A = " << a<<"\nB = "<<b<<endl;
}

NewClass::~NewClass(){
	cout << "Use this place to release the memory of all the objects"<<endl;
}

NewClass NewClass::operator+(NewClass newClass){
	NewClass temp(0, 0);
	temp.regVar = regVar + newClass.regVar;
	return temp;
}

int NewClass::getRegVar(){
	return regVar;
}

void NewClass::print(){
	cout<<"Test msg from NewClass Function\n";
}

void NewClass::constFnPrint() const{
	cout<<"I'm from a constant function\n";
}
