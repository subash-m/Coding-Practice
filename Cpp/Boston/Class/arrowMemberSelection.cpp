#include<iostream>
#include "NewClass.h"

using namespace std;

int main(){
	NewClass newClass;
	NewClass *newClassPtr = &newClass;
	//Use Arrow Member Selection, for pointer of a class
	newClassPtr->print();
}
